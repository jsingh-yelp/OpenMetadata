package org.openmetadata.service.notifications.channels.teams;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.openmetadata.service.apps.bundles.changeEvent.msteams.TeamsMessage;

final class TeamsCardAssembler extends AbstractVisitor {
  private static final int TEAMS_MAX_TEXT_LENGTH = 5000;
  private static final TeamsMarkdownFormatter INLINE_FORMATTER = new TeamsMarkdownFormatter();

  private final List<TeamsMessage.BodyItem> body = new ArrayList<>();
  private final StringBuilder currentText = new StringBuilder();

  // State tracking
  private boolean inList = false;

  List<TeamsMessage.BodyItem> getBodyItems() {
    return new ArrayList<>(body);
  }

  @Override
  public void visit(Document document) {
    visitChildren(document);
    flushCurrentText();
  }

  // --- Block Visitors ---

  @Override
  public void visit(Heading heading) {
    flushCurrentText();
    String text = INLINE_FORMATTER.renderInlineChildren(heading).trim();
    if (!text.isEmpty()) {
      int size = Math.max(1, Math.min(4, heading.getLevel()));
      body.add(createTextBlock(text, "heading", size));
    }
  }

  @Override
  public void visit(Paragraph paragraph) {
    if (!inList) flushCurrentText();
    String text = INLINE_FORMATTER.renderInlineChildren(paragraph);
    if (!text.isBlank()) currentText.append(text);
    if (!inList) flushCurrentText();
  }

  @Override
  public void visit(BlockQuote blockQuote) {
    flushCurrentText();
    StringBuilder content = new StringBuilder();

    for (Node child = blockQuote.getFirstChild(); child != null; child = child.getNext()) {
      String childText = renderNodeToText(child);
      if (!childText.isBlank()) {
        childText.lines().forEach(line -> content.append("> ").append(line).append("\n"));
        content.append("\n");
      }
    }

    String quoted = content.toString().trim();
    if (!quoted.isEmpty()) {
      body.add(
          TeamsMessage.Container.builder()
              .type("Container")
              .style("emphasis")
              .items(List.of(createTextBlock(quoted, null, 0)))
              .build());
    }
  }

  @Override
  public void visit(FencedCodeBlock block) {
    addCodeBlock(block.getLiteral());
  }

  @Override
  public void visit(IndentedCodeBlock block) {
    addCodeBlock(block.getLiteral());
  }

  @Override
  public void visit(ThematicBreak breakNode) {
    flushCurrentText();
    body.add(TeamsMessage.TextBlock.builder().type("TextBlock").separator(true).build());
  }

  @Override
  public void visit(CustomBlock block) {
    if (block instanceof TableBlock table) processTable(table);
    else super.visit(block);
  }

  // --- List Visitors ---

  @Override
  public void visit(BulletList list) {
    processList(list, 0, null);
  }

  @Override
  public void visit(OrderedList list) {
    processList(list, 0, list.getMarkerStartNumber());
  }

  @Override
  public void visit(ListItem item) {
    visitChildren(item);
  }

  // --- Inline Visitors (Accumulate to currentText) ---

  @Override
  public void visit(Text text) {
    currentText.append(text.getLiteral());
  }

  @Override
  public void visit(SoftLineBreak breakNode) {
    currentText.append("\n");
  }

  @Override
  public void visit(HardLineBreak breakNode) {
    currentText.append("\n");
  }

  @Override
  public void visit(Emphasis em) {
    wrapText("*", em);
  }

  @Override
  public void visit(StrongEmphasis em) {
    wrapText("**", em);
  }

  @Override
  public void visit(Code code) {
    currentText.append("`").append(code.getLiteral()).append("`");
  }

  @Override
  public void visit(CustomNode node) {
    if (node instanceof Strikethrough s) wrapText("~~", s);
    else super.visit(node);
  }

  @Override
  public void visit(Link link) {
    int before = currentText.length();
    visitChildren(link);
    String label = currentText.substring(before).trim();
    currentText.setLength(before);

    String url = link.getDestination();
    if (!isAllowedLinkUrl(url)) {
      if (!label.isEmpty()) currentText.append(escapeMdLabel(label));
    } else {
      String safeLabel = label.isEmpty() ? escapeMdUrl(url) : escapeMdLabel(label);
      currentText.append("[").append(safeLabel).append("](").append(escapeMdUrl(url)).append(")");
    }
  }

  // --- Core Processing Logic ---

  private void processList(Node list, int indent, Integer startNum) {
    flushCurrentText();
    inList = true;

    int index = (startNum == null) ? 1 : Math.max(1, startNum);
    String padding = "  ".repeat(indent);

    for (Node node = list.getFirstChild(); node != null; node = node.getNext()) {
      if (!(node instanceof ListItem li)) continue;

      TableBlock table = findChild(li, TableBlock.class).orElse(null);
      String itemText = renderListItemText(li);

      if (!itemText.isEmpty()) {
        String bullet = (startNum == null) ? "- " : index + ". ";
        flushLine(padding + bullet + itemText);
      }

      if (table != null) {
        flushCurrentText();
        processTable(table);
      }

      if (startNum != null) index++;

      for (Node child = li.getFirstChild(); child != null; child = child.getNext()) {
        if (child instanceof BulletList bl) processList(bl, indent + 1, null);
        else if (child instanceof OrderedList ol)
          processList(ol, indent + 1, ol.getMarkerStartNumber());
      }
    }

    flushCurrentText();
    inList = false;
  }

  private void processTable(TableBlock tableBlock) {
    flushCurrentText();
    TableData data = extractTableData(tableBlock);
    if (data.isEmpty()) return;

    int totalRecords = data.rows.size();

    if (totalRecords > 1) {
      body.add(
          TeamsMessage.TextBlock.builder()
              .type("TextBlock")
              .text(String.format("📋 %d records", totalRecords))
              .weight("Bolder")
              .spacing("Medium")
              .wrap(true)
              .build());
    }

    for (int i = 0; i < totalRecords; i++) {
      boolean showHeader = totalRecords > 1;
      boolean addSpacing = i > 0 || !showHeader;
      body.add(
          buildTransposedRecord(data.headers, data.rows.get(i), i + 1, showHeader, addSpacing));
    }
  }

  /**
   * REFACTORED: Wraps code in an 'emphasis' container to provide a background color box.
   */
  private void addCodeBlock(String literal) {
    flushCurrentText();
    if (literal == null || literal.isEmpty()) return;

    // 1. Create the TextBlock with Monospace font
    TeamsMessage.TextBlock codeText =
        TeamsMessage.TextBlock.builder()
            .type("TextBlock")
            .text(truncate(literal))
            .wrap(true)
            .fontType("Monospace")
            .size("Small") // Code often looks better slightly smaller
            .build();

    // 2. Wrap it in a Container with 'emphasis' style (Grey background in Teams)
    TeamsMessage.Container container =
        TeamsMessage.Container.builder()
            .type("Container")
            .style("emphasis")
            .items(List.of(codeText))
            .build();

    body.add(container);
  }

  // --- Helpers: Table Construction ---

  private TeamsMessage.Table buildTransposedRecord(
      List<String> headers, List<String> row, int recordNum, boolean showHeader, boolean spacing) {
    List<TeamsMessage.TableRow> tableRows = new ArrayList<>();

    if (showHeader) {
      tableRows.add(createRow("📋 Record " + recordNum, "", true));
    }

    for (int i = 0; i < headers.size(); i++) {
      String val = (i < row.size() && row.get(i) != null) ? row.get(i) : "";
      if (val.length() > 60) val = val.substring(0, 57) + "…";
      tableRows.add(createRow(headers.get(i), val, false));
    }

    TeamsMessage.Table.TableBuilder builder =
        TeamsMessage.Table.builder()
            .type("Table")
            .gridStyle("accent")
            .firstRowAsHeader(showHeader)
            .columns(
                List.of(
                    TeamsMessage.TableColumnDefinition.builder().width("auto").build(),
                    TeamsMessage.TableColumnDefinition.builder().width("stretch").build()))
            .rows(tableRows);

    if (spacing) builder.spacing("Medium");
    return builder.build();
  }

  private TeamsMessage.TableRow createRow(String col1, String col2, boolean isHeader) {
    return TeamsMessage.TableRow.builder()
        .type("TableRow")
        .cells(List.of(createCell(col1, true), createCell(col2, false)))
        .build();
  }

  private TeamsMessage.TableCell createCell(String text, boolean bold) {
    TeamsMessage.TextBlock.TextBlockBuilder txt =
        TeamsMessage.TextBlock.builder().type("TextBlock").text(text).wrap(true);
    if (bold) txt.weight("Bolder");
    return TeamsMessage.TableCell.builder().type("TableCell").items(List.of(txt.build())).build();
  }

  private TableData extractTableData(TableBlock table) {
    List<String> headers = new ArrayList<>();
    List<List<String>> rows = new ArrayList<>();

    for (Node child = table.getFirstChild(); child != null; child = child.getNext()) {
      if (child instanceof TableHead head) {
        findChild(head, TableRow.class).ifPresent(r -> headers.addAll(extractCells(r)));
      } else if (child instanceof TableBody body) {
        for (Node row = body.getFirstChild(); row != null; row = row.getNext()) {
          if (row instanceof TableRow r) rows.add(extractCells(r));
        }
      }
    }

    if (headers.isEmpty() && rows.isEmpty()) return new TableData(List.of(), List.of());

    int maxCols = rows.stream().mapToInt(List::size).max().orElse(headers.size());

    if (headers.isEmpty()) {
      IntStream.range(0, maxCols).mapToObj(i -> "Column " + (i + 1)).forEach(headers::add);
    }

    return new TableData(headers, rows);
  }

  private List<String> extractCells(TableRow row) {
    List<String> cells = new ArrayList<>();
    for (Node c = row.getFirstChild(); c != null; c = c.getNext()) {
      if (c instanceof TableCell) {
        cells.add(INLINE_FORMATTER.renderInlineChildren(c).trim().replace("\n", " "));
      }
    }
    return cells;
  }

  // --- Helpers: Text & Structure ---

  private void flushCurrentText() {
    if (currentText.isEmpty()) return;
    String text = currentText.toString().trim();
    if (!text.isEmpty()) {
      for (String line : text.split("\\n+")) {
        if (!line.trim().isEmpty()) body.add(createTextBlock(line.trim(), null, 0));
      }
    }
    currentText.setLength(0);
  }

  private void flushLine(String line) {
    currentText.append(line).append("\n");
    flushCurrentText();
  }

  private TeamsMessage.TextBlock createTextBlock(String text, String style, int size) {
    TeamsMessage.TextBlock.TextBlockBuilder builder =
        TeamsMessage.TextBlock.builder().type("TextBlock").text(truncate(text)).wrap(true);
    if ("heading".equals(style)) {
      builder.weight("Bolder");
      builder.size(
          switch (size) {
            case 1 -> "ExtraLarge";
            case 2 -> "Large";
            case 3 -> "Medium";
            default -> "Default";
          });
    }
    return builder.build();
  }

  private void wrapText(String wrapper, Node node) {
    currentText.append(wrapper);
    visitChildren(node);
    currentText.append(wrapper);
  }

  private String renderListItemText(ListItem li) {
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (Node c = li.getFirstChild(); c != null; c = c.getNext()) {
      if (c instanceof TableBlock || c instanceof BulletList || c instanceof OrderedList) continue;

      String text = renderNodeToText(c);
      if (text.isEmpty()) continue;

      if (!first) sb.append(" ");
      sb.append(text);
      first = false;
    }
    return sb.toString();
  }

  private String renderNodeToText(Node node) {
    if (node instanceof FencedCodeBlock f) return truncate(f.getLiteral());
    if (node instanceof IndentedCodeBlock i) return truncate(i.getLiteral());
    return INLINE_FORMATTER.renderInlineChildren(node).trim();
  }

  private <T> Optional<T> findChild(Node parent, Class<T> clazz) {
    for (Node c = parent.getFirstChild(); c != null; c = c.getNext()) {
      if (clazz.isInstance(c)) return Optional.of(clazz.cast(c));
    }
    return Optional.empty();
  }

  // --- Helpers: Formatting ---

  private String truncate(String s) {
    if (s == null) return "";
    return s.length() <= TEAMS_MAX_TEXT_LENGTH
        ? s
        : s.substring(0, TEAMS_MAX_TEXT_LENGTH - 3) + "…";
  }

  private static boolean isAllowedLinkUrl(String url) {
    if (url == null) return false;
    try {
      String s = URI.create(url.trim()).getScheme();
      return s != null
          && (s.equalsIgnoreCase("http")
              || s.equalsIgnoreCase("https")
              || s.equalsIgnoreCase("mailto"));
    } catch (Exception e) {
      return false;
    }
  }

  private static String escapeMdLabel(String s) {
    return s == null
        ? ""
        : s.replace("[", "\\[").replace("]", "\\]").replace("(", "\\(").replace(")", "\\)");
  }

  private static String escapeMdUrl(String s) {
    return s == null ? "" : s.trim().replace(" ", "%20").replace(")", "%29").replace("(", "%28");
  }

  private record TableData(List<String> headers, List<List<String>> rows) {
    boolean isEmpty() {
      return headers.isEmpty() && rows.isEmpty();
    }
  }
}
