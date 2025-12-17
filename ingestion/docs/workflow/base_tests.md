## `metadata.sdk.data_quality.tests.base_tests`

Test definition wrappers for simplified DQ as Code API.

**Classes:**

- [**BaseTest**](#metadata.sdk.data_quality.tests.base_tests.BaseTest) – Base class for all data quality test definitions.
- [**ColumnTest**](#metadata.sdk.data_quality.tests.base_tests.ColumnTest) – Base class for column-level data quality test definitions.
- [**TableTest**](#metadata.sdk.data_quality.tests.base_tests.TableTest) – Base class for table-level data quality test definitions.

### `metadata.sdk.data_quality.tests.base_tests.BaseTest`

```python
BaseTest(
    test_definition_name,
    name=None,
    display_name=None,
    description=None,
    compute_passed_failed_row_count=False,
)
```

Base class for all data quality test definitions.

This class provides a fluent API for configuring test cases with metadata
and parameters. All test definitions inherit from this base class.

**Attributes:**

- [**test_definition_name**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.test_definition_name) (<code>[str](#str)</code>) – Internal name of the test definition type
- [**parameters**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) – List of test case parameter values
- [**name**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Unique identifier for this test case instance
- [**display_name**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Human-readable name shown in UI
- [**description**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Detailed description of what the test validates
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail counts

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.base_tests.BaseTest.with_name) – Set a custom test case name.

**Parameters:**

- **test_definition_name** (<code>[str](#str)</code>) – Internal name matching the test definition in OpenMetadata
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Unique identifier for this test case (auto-generated if not provided)
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Human-readable name for UI display (auto-generated if not provided)
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Description of what this test validates (auto-generated if not provided)

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.with_compute_row_count`

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

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.base_tests.BaseTest.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.base_tests.ColumnTest`

```python
ColumnTest(
    test_definition_name,
    column,
    name=None,
    display_name=None,
    description=None,
    compute_passed_failed_row_count=False,
)
```

Bases: <code>[BaseTest](#metadata.sdk.data_quality.tests.base_tests.BaseTest)</code>

Base class for column-level data quality test definitions.

Column tests validate properties of specific columns, such as uniqueness,
null values, value ranges, or pattern matching.

All column-level test definitions should inherit from this class.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.base_tests.ColumnTest.column_name) (<code>[str](#str)</code>) – Name of the column this test validates

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.base_tests.ColumnTest.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_name) – Set a custom test case name.

**Parameters:**

- **test_definition_name** (<code>[str](#str)</code>) – Internal name matching the test definition in OpenMetadata
- **column** (<code>[str](#str)</code>) – Name of the column to test
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Unique identifier for this test case (auto-generated if not provided)
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Human-readable name for UI display (auto-generated if not provided)
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Description of what this test validates (auto-generated if not provided)

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_compute_row_count`

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

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.tests.base_tests.TableTest`

Bases: <code>[BaseTest](#metadata.sdk.data_quality.tests.base_tests.BaseTest)</code>

Base class for table-level data quality test definitions.

Table tests validate properties of entire tables, such as row counts,
column counts, or custom SQL queries against the table.

All table-level test definitions should inherit from this class.

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.base_tests.TableTest.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.base_tests.TableTest.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.base_tests.TableTest.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.base_tests.TableTest.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.base_tests.TableTest.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.base_tests.TableTest.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.base_tests.TableTest.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.base_tests.TableTest.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.base_tests.TableTest.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.base_tests.TableTest.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.base_tests.TableTest.test_definition_name) (<code>[str](#str)</code>) –
