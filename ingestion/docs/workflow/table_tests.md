## `metadata.sdk.data_quality.tests.table_tests`

Table-level test definitions for DQ as Code API.

**Classes:**

- [**TableColumnCountToBeBetween**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween) – Validates that the number of columns in a table falls within a specified range.
- [**TableColumnCountToEqual**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual) – Validates that the table has an exact number of columns.
- [**TableColumnNameToExist**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist) – Validates that a specific column exists in the table schema.
- [**TableColumnToMatchSet**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet) – Validates that table columns match an expected set of column names.
- [**TableCustomSQLQuery**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery) – Validates data using a custom SQL query expression.
- [**TableDiff**](#metadata.sdk.data_quality.tests.table_tests.TableDiff) – Compares two tables and identifies differences in their data.
- [**TableRowCountToBeBetween**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween) – Validates that the number of rows in a table falls within a specified range.
- [**TableRowCountToEqual**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual) – Validates that the table has an exact number of rows.
- [**TableRowInsertedCountToBeBetween**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween) – Validates that the number of rows inserted within a time range is within bounds.

### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween`

```python
TableColumnCountToBeBetween(
    min_count=None,
    max_count=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[TableTest](#metadata.sdk.data_quality.tests.base_tests.TableTest)</code>

Validates that the number of columns in a table falls within a specified range.

This test checks if the column count is between the minimum and maximum values.
Useful for schema validation and detecting unexpected column additions or removals.

**Parameters:**

- **min_count** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Minimum acceptable number of columns (inclusive)
- **max_count** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Maximum acceptable number of columns (inclusive)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = TableColumnCountToBeBetween(min_count=5, max_count=10)
>>> test = TableColumnCountToBeBetween(min_count=5)  # Only minimum
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_compute_row_count`

```python
with_compute_row_count(compute=True)
```

Enable or disable passed/failed row count computation.

When enabled, the test will compute and report the number and percentage
of rows that passed or failed the test validation.

**Parameters:**

- **compute** (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail statistics

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual`

```python
TableColumnCountToEqual(
    column_count, name=None, display_name=None, description=None
)
```

Bases: <code>[TableTest](#metadata.sdk.data_quality.tests.base_tests.TableTest)</code>

Validates that the table has an exact number of columns.

This test ensures the column count matches a specific expected value.
Useful for strict schema validation.

**Parameters:**

- **column_count** (<code>[int](#int)</code>) – Expected number of columns in the table
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = TableColumnCountToEqual(column_count=10)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_compute_row_count`

```python
with_compute_row_count(compute=True)
```

Enable or disable passed/failed row count computation.

When enabled, the test will compute and report the number and percentage
of rows that passed or failed the test validation.

**Parameters:**

- **compute** (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail statistics

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist`

```python
TableColumnNameToExist(
    column_name, name=None, display_name=None, description=None
)
```

Bases: <code>[TableTest](#metadata.sdk.data_quality.tests.base_tests.TableTest)</code>

Validates that a specific column exists in the table schema.

This test checks for the presence of a required column by name.
Useful for ensuring critical columns are not dropped from the schema.

**Parameters:**

- **column_name** (<code>[str](#str)</code>) – Name of the column that must exist
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = TableColumnNameToExist(column_name="user_id")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_compute_row_count`

```python
with_compute_row_count(compute=True)
```

Enable or disable passed/failed row count computation.

When enabled, the test will compute and report the number and percentage
of rows that passed or failed the test validation.

**Parameters:**

- **compute** (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail statistics

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet`

```python
TableColumnToMatchSet(
    column_names, ordered=False, name=None, display_name=None, description=None
)
```

Bases: <code>[TableTest](#metadata.sdk.data_quality.tests.base_tests.TableTest)</code>

Validates that table columns match an expected set of column names.

This test ensures the table schema contains exactly the specified columns.
Optionally can enforce column order matching.

**Parameters:**

- **column_names** (<code>[List](#typing.List)\[[str](#str)\]</code>) – List of expected column names
- **ordered** (<code>[bool](#bool)</code>) – If True, column order must match exactly
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = TableColumnToMatchSet(column_names=["id", "name", "email"])
>>> test = TableColumnToMatchSet(column_names=["col1", "col2"], ordered=True)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_compute_row_count`

```python
with_compute_row_count(compute=True)
```

Enable or disable passed/failed row count computation.

When enabled, the test will compute and report the number and percentage
of rows that passed or failed the test validation.

**Parameters:**

- **compute** (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail statistics

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery`

```python
TableCustomSQLQuery(
    sql_expression,
    strategy="ROWS",
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[TableTest](#metadata.sdk.data_quality.tests.base_tests.TableTest)</code>

Validates data using a custom SQL query expression.

This test allows you to define custom data quality logic using SQL.
The query should return rows that fail the validation criteria.

**Parameters:**

- **sql_expression** (<code>[str](#str)</code>) – SQL query to execute (returns failing rows)
- **strategy** (<code>[str](#str)</code>) – Validation strategy - "ROWS" counts failing rows, "COUNT" expects a count
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = TableCustomSQLQuery(
...     sql_expression="SELECT * FROM {table} WHERE price < 0",
...     strategy="ROWS"
... )
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_compute_row_count`

```python
with_compute_row_count(compute=True)
```

Enable or disable passed/failed row count computation.

When enabled, the test will compute and report the number and percentage
of rows that passed or failed the test validation.

**Parameters:**

- **compute** (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail statistics

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.table_tests.TableDiff`

```python
TableDiff(
    table2,
    key_columns=None,
    table2_key_columns=None,
    use_columns=None,
    extra_columns=None,
    table2_extra_columns=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[TableTest](#metadata.sdk.data_quality.tests.base_tests.TableTest)</code>

Compares two tables and identifies differences in their data.

This test performs a row-by-row comparison between two tables to detect
discrepancies. Useful for validating data migrations, replication, or transformations.

**Parameters:**

- **table2** (<code>[str](#str)</code>) – Fully qualified name of the table to compare against
- **key_columns** (<code>[Optional](#typing.Optional)\[[List](#typing.List)\[[str](#str)\]\]</code>) – Columns to use as join keys for comparison
- **table2_key_columns** (<code>[Optional](#typing.Optional)\[[List](#typing.List)\[[str](#str)\]\]</code>) – Columns from table 2 to use as join keys for comparison
- **use_columns** (<code>[Optional](#typing.Optional)\[[List](#typing.List)\[[str](#str)\]\]</code>) – Specific columns to compare (compares all if not specified)
- **extra_columns** (<code>[Optional](#typing.Optional)\[[List](#typing.List)\[[str](#str)\]\]</code>) – Additional columns to include in diff output
- **table2_extra_columns** (<code>[Optional](#typing.Optional)\[[List](#typing.List)\[[str](#str)\]\]</code>) – Additional columns from table 2 to include in diff output
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = TableDiff(
...     table2="service.database.schema.reference_table",
...     key_columns=["id"],
...     use_columns=["name", "value"]
... )
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.table_tests.TableDiff.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.with_compute_row_count`

```python
with_compute_row_count(compute=True)
```

Enable or disable passed/failed row count computation.

When enabled, the test will compute and report the number and percentage
of rows that passed or failed the test validation.

**Parameters:**

- **compute** (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail statistics

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableDiff.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween`

```python
TableRowCountToBeBetween(
    min_count=None,
    max_count=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[TableTest](#metadata.sdk.data_quality.tests.base_tests.TableTest)</code>

Validates that the number of rows in a table falls within a specified range.

This test checks if the row count is between the minimum and maximum values.
Useful for monitoring data volume and detecting data loss or unexpected growth.

**Parameters:**

- **min_count** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Minimum acceptable number of rows (inclusive)
- **max_count** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Maximum acceptable number of rows (inclusive)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = TableRowCountToBeBetween(min_count=1000, max_count=5000)
>>> test = TableRowCountToBeBetween(min_count=100)  # Only minimum
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_compute_row_count`

```python
with_compute_row_count(compute=True)
```

Enable or disable passed/failed row count computation.

When enabled, the test will compute and report the number and percentage
of rows that passed or failed the test validation.

**Parameters:**

- **compute** (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail statistics

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual`

```python
TableRowCountToEqual(row_count, name=None, display_name=None, description=None)
```

Bases: <code>[TableTest](#metadata.sdk.data_quality.tests.base_tests.TableTest)</code>

Validates that the table has an exact number of rows.

This test ensures the row count matches a specific expected value.
Useful for validating fixed-size reference tables or dimension tables.

**Parameters:**

- **row_count** (<code>[int](#int)</code>) – Expected number of rows in the table
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = TableRowCountToEqual(row_count=50)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_compute_row_count`

```python
with_compute_row_count(compute=True)
```

Enable or disable passed/failed row count computation.

When enabled, the test will compute and report the number and percentage
of rows that passed or failed the test validation.

**Parameters:**

- **compute** (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail statistics

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween`

```python
TableRowInsertedCountToBeBetween(
    min_count=None,
    max_count=None,
    range_type="DAY",
    range_interval=1,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[TableTest](#metadata.sdk.data_quality.tests.base_tests.TableTest)</code>

Validates that the number of rows inserted within a time range is within bounds.

This test monitors data ingestion rates by checking if newly inserted rows
fall within expected thresholds over a specified time period. Requires a timestamp
column to track insertions.

**Parameters:**

- **min_count** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Minimum acceptable number of inserted rows (inclusive)
- **max_count** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Maximum acceptable number of inserted rows (inclusive)
- **range_type** (<code>[str](#str)</code>) – Time unit for the range ("HOUR", "DAY", "WEEK", "MONTH")
- **range_interval** (<code>[int](#int)</code>) – Number of time units to look back
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = TableRowInsertedCountToBeBetween(min_count=100, max_count=1000, range_type="DAY", range_interval=1)
>>> test = TableRowInsertedCountToBeBetween(min_count=50, range_type="HOUR", range_interval=6)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_compute_row_count`

```python
with_compute_row_count(compute=True)
```

Enable or disable passed/failed row count computation.

When enabled, the test will compute and report the number and percentage
of rows that passed or failed the test validation.

**Parameters:**

- **compute** (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail statistics

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining
