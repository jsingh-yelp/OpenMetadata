## `metadata.sdk.data_quality`

Simplified Data Quality as Code API for OpenMetadata SDK.

**Modules:**

- [**result_capturing_processor**](#metadata.sdk.data_quality.result_capturing_processor) – Processor wrapper that captures test case results without modifying the processor.
- [**runner**](#metadata.sdk.data_quality.runner) – Class that allows running data quality checks by code
- [**tests**](#metadata.sdk.data_quality.tests) – Convenience classes that represent test definitions
- [**workflow_config_builder**](#metadata.sdk.data_quality.workflow_config_builder) – Builder for creating OpenMetadata workflow configurations for test suite execution.

**Classes:**

- [**BaseTest**](#metadata.sdk.data_quality.BaseTest) – Base class for all data quality test definitions.
- [**ColumnTest**](#metadata.sdk.data_quality.ColumnTest) – Base class for column-level data quality test definitions.
- [**ColumnValueLengthsToBeBetween**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween) – Validates that the length of string values in a column falls within a specified range.
- [**ColumnValueMaxToBeBetween**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween) – Validates that the maximum value in a column falls within a specified range.
- [**ColumnValueMeanToBeBetween**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween) – Validates that the mean (average) value in a column falls within a specified range.
- [**ColumnValueMedianToBeBetween**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween) – Validates that the median value in a column falls within a specified range.
- [**ColumnValueMinToBeBetween**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween) – Validates that the minimum value in a column falls within a specified range.
- [**ColumnValueStdDevToBeBetween**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween) – Validates that the standard deviation of column values falls within a specified range.
- [**ColumnValuesMissingCount**](#metadata.sdk.data_quality.ColumnValuesMissingCount) – Validates that the count of missing or null values meets expectations.
- [**ColumnValuesSumToBeBetween**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween) – Validates that the sum of all values in a column falls within a specified range.
- [**ColumnValuesToBeAtExpectedLocation**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation) – Validates that a specific value appears at an expected row position.
- [**ColumnValuesToBeBetween**](#metadata.sdk.data_quality.ColumnValuesToBeBetween) – Validates that all values in a column fall within a specified numeric range.
- [**ColumnValuesToBeInSet**](#metadata.sdk.data_quality.ColumnValuesToBeInSet) – Validates that all values in a column belong to a specified set of allowed values.
- [**ColumnValuesToBeNotInSet**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet) – Validates that column values do not contain any forbidden values.
- [**ColumnValuesToBeNotNull**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull) – Validates that a column contains no null or missing values.
- [**ColumnValuesToBeUnique**](#metadata.sdk.data_quality.ColumnValuesToBeUnique) – Validates that all values in a column are unique with no duplicates.
- [**ColumnValuesToMatchRegex**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex) – Validates that column values match a specified regular expression pattern.
- [**ColumnValuesToNotMatchRegex**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex) – Validates that column values do not match a forbidden regular expression pattern.
- [**TableColumnCountToBeBetween**](#metadata.sdk.data_quality.TableColumnCountToBeBetween) – Validates that the number of columns in a table falls within a specified range.
- [**TableColumnCountToEqual**](#metadata.sdk.data_quality.TableColumnCountToEqual) – Validates that the table has an exact number of columns.
- [**TableColumnNameToExist**](#metadata.sdk.data_quality.TableColumnNameToExist) – Validates that a specific column exists in the table schema.
- [**TableColumnToMatchSet**](#metadata.sdk.data_quality.TableColumnToMatchSet) – Validates that table columns match an expected set of column names.
- [**TableCustomSQLQuery**](#metadata.sdk.data_quality.TableCustomSQLQuery) – Validates data using a custom SQL query expression.
- [**TableDiff**](#metadata.sdk.data_quality.TableDiff) – Compares two tables and identifies differences in their data.
- [**TableRowCountToBeBetween**](#metadata.sdk.data_quality.TableRowCountToBeBetween) – Validates that the number of rows in a table falls within a specified range.
- [**TableRowCountToEqual**](#metadata.sdk.data_quality.TableRowCountToEqual) – Validates that the table has an exact number of rows.
- [**TableRowInsertedCountToBeBetween**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween) – Validates that the number of rows inserted within a time range is within bounds.
- [**TableTest**](#metadata.sdk.data_quality.TableTest) – Base class for table-level data quality test definitions.
- [**TestRunner**](#metadata.sdk.data_quality.TestRunner) – Simplified test runner for executing data quality tests on OpenMetadata tables.

### `metadata.sdk.data_quality.BaseTest`

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

- [**test_definition_name**](#metadata.sdk.data_quality.BaseTest.test_definition_name) (<code>[str](#str)</code>) – Internal name of the test definition type
- [**parameters**](#metadata.sdk.data_quality.BaseTest.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) – List of test case parameter values
- [**name**](#metadata.sdk.data_quality.BaseTest.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Unique identifier for this test case instance
- [**display_name**](#metadata.sdk.data_quality.BaseTest.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Human-readable name shown in UI
- [**description**](#metadata.sdk.data_quality.BaseTest.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Detailed description of what the test validates
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.BaseTest.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail counts

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.BaseTest.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.BaseTest.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.BaseTest.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.BaseTest.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.BaseTest.with_name) – Set a custom test case name.

**Parameters:**

- **test_definition_name** (<code>[str](#str)</code>) – Internal name matching the test definition in OpenMetadata
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Unique identifier for this test case (auto-generated if not provided)
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Human-readable name for UI display (auto-generated if not provided)
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Description of what this test validates (auto-generated if not provided)

#### `metadata.sdk.data_quality.BaseTest.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.BaseTest.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.BaseTest.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.BaseTest.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.BaseTest.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.BaseTest.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.BaseTest.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.BaseTest.with_compute_row_count`

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

#### `metadata.sdk.data_quality.BaseTest.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.BaseTest.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.BaseTest.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnTest`

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

- [**column_name**](#metadata.sdk.data_quality.ColumnTest.column_name) (<code>[str](#str)</code>) – Name of the column this test validates

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnTest.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnTest.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnTest.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnTest.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnTest.with_name) – Set a custom test case name.

**Parameters:**

- **test_definition_name** (<code>[str](#str)</code>) – Internal name matching the test definition in OpenMetadata
- **column** (<code>[str](#str)</code>) – Name of the column to test
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Unique identifier for this test case (auto-generated if not provided)
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Human-readable name for UI display (auto-generated if not provided)
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Description of what this test validates (auto-generated if not provided)

#### `metadata.sdk.data_quality.ColumnTest.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnTest.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnTest.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnTest.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnTest.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnTest.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnTest.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnTest.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnTest.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnTest.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnTest.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnTest.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween`

```python
ColumnValueLengthsToBeBetween(
    column,
    min_length=None,
    max_length=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the length of string values in a column falls within a specified range.

This test checks character count for text columns, useful for validating string
constraints, preventing truncation, and ensuring data format compliance.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_length** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Minimum acceptable string length
- **max_length** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Maximum acceptable string length
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueLengthsToBeBetween(column="username", min_length=3, max_length=20)
>>> test = ColumnValueLengthsToBeBetween(column="description", min_length=10, max_length=500)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueLengthsToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween`

```python
ColumnValueMaxToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the maximum value in a column falls within a specified range.

This test computes the maximum value across all rows and checks if it's within bounds.
Useful for monitoring data ranges and detecting outliers in the upper range.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable maximum value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable maximum value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMaxToBeBetween(column="temperature", min_value=-50, max_value=50)
>>> test = ColumnValueMaxToBeBetween(column="score", min_value=90, max_value=100)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValueMaxToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueMaxToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween`

```python
ColumnValueMeanToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the mean (average) value in a column falls within a specified range.

This test computes the arithmetic mean of all values and checks if it's within bounds.
Useful for statistical validation and detecting data drift in numeric columns.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable mean value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable mean value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMeanToBeBetween(column="rating", min_value=3.0, max_value=4.5)
>>> test = ColumnValueMeanToBeBetween(column="response_time_ms", min_value=100, max_value=500)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValueMeanToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueMeanToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween`

```python
ColumnValueMedianToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the median value in a column falls within a specified range.

This test computes the median (middle value) and checks if it's within bounds.
More robust than mean for skewed distributions, useful for detecting outliers.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable median value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable median value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMedianToBeBetween(column="salary", min_value=50000, max_value=75000)
>>> test = ColumnValueMedianToBeBetween(column="age", min_value=25, max_value=45)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValueMedianToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueMedianToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValueMinToBeBetween`

```python
ColumnValueMinToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the minimum value in a column falls within a specified range.

This test computes the minimum value across all rows and checks if it's within bounds.
Useful for monitoring data ranges and detecting outliers in the lower range.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable minimum value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable minimum value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMinToBeBetween(column="temperature", min_value=-50, max_value=0)
>>> test = ColumnValueMinToBeBetween(column="age", min_value=0, max_value=18)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValueMinToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueMinToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween`

```python
ColumnValueStdDevToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the standard deviation of column values falls within a specified range.

This test computes the standard deviation (measure of variance) and checks if it's within bounds.
Useful for detecting unexpected data variability or consistency issues.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable standard deviation
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable standard deviation
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueStdDevToBeBetween(column="response_time", min_value=0, max_value=100)
>>> test = ColumnValueStdDevToBeBetween(column="score", min_value=5, max_value=15)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValueStdDevToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesMissingCount`

```python
ColumnValuesMissingCount(
    column,
    missing_count_value=None,
    missing_value_match=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the count of missing or null values meets expectations.

This test counts rows with missing values and validates against expected thresholds.
Supports custom missing value patterns beyond NULL (e.g., "N/A", "", "NULL").

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **missing_count_value** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Expected number of missing values
- **missing_value_match** (<code>[Optional](#typing.Optional)\[[List](#typing.List)\[[str](#str)\]\]</code>) – List of strings to treat as missing values (optional)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesMissingCount(column="optional_field", missing_count_value=100)
>>> test = ColumnValuesMissingCount(column="status", missing_value_match=["N/A", "Unknown"])
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesMissingCount.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesMissingCount.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesMissingCount.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesMissingCount.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesMissingCount.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesMissingCount.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesMissingCount.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesMissingCount.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesMissingCount.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesMissingCount.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesMissingCount.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesMissingCount.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesMissingCount.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween`

```python
ColumnValuesSumToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the sum of all values in a column falls within a specified range.

This test computes the total sum across all rows and checks if it's within bounds.
Useful for validating totals, aggregates, and detecting unexpected data volumes.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable sum
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable sum
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesSumToBeBetween(column="revenue", min_value=1000000, max_value=5000000)
>>> test = ColumnValuesSumToBeBetween(column="quantity", min_value=100, max_value=1000)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesSumToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesSumToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation`

```python
ColumnValuesToBeAtExpectedLocation(
    column,
    expected_value,
    row_index=0,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that a specific value appears at an expected row position.

This test checks for an exact value at a particular row index, useful for validating
sorted data, header rows, or expected entries at known positions.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **expected_value** (<code>[str](#str)</code>) – The exact value expected at the specified location
- **row_index** (<code>[int](#int)</code>) – Zero-based row position to check (default: 0)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeAtExpectedLocation(column="id", expected_value="1", row_index=0)
>>> test = ColumnValuesToBeAtExpectedLocation(column="rank", expected_value="first", row_index=0)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeAtExpectedLocation.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesToBeBetween`

```python
ColumnValuesToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that all values in a column fall within a specified numeric range.

This test checks that individual column values are between minimum and maximum bounds.
Useful for validating numeric constraints, age ranges, prices, quantities, etc.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable value (inclusive)
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable value (inclusive)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeBetween(column="age", min_value=0, max_value=120)
>>> test = ColumnValuesToBeBetween(column="price", min_value=0.01, max_value=9999.99)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesToBeInSet`

```python
ColumnValuesToBeInSet(
    column, allowed_values, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that all values in a column belong to a specified set of allowed values.

This test ensures data integrity by checking that column values are constrained
to a predefined list. Useful for enum-like columns or categorical data.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **allowed_values** (<code>[List](#typing.List)\[[str](#str)\]</code>) – List of acceptable values for the column
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeInSet(column="status", allowed_values=["active", "inactive", "pending"])
>>> test = ColumnValuesToBeInSet(column="country_code", allowed_values=["US", "UK", "CA"])
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesToBeInSet.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeInSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet`

```python
ColumnValuesToBeNotInSet(
    column, forbidden_values, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that column values do not contain any forbidden values.

This test detects the presence of blacklisted or invalid values in a column.
Useful for data quality checks where certain values should never appear.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **forbidden_values** (<code>[List](#typing.List)\[[str](#str)\]</code>) – List of values that must not appear in the column
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeNotInSet(column="email", forbidden_values=["test@test.com", "admin@admin.com"])
>>> test = ColumnValuesToBeNotInSet(column="status", forbidden_values=["deleted", "archived"])
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotInSet.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeNotInSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesToBeNotNull`

```python
ColumnValuesToBeNotNull(column, name=None, display_name=None, description=None)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that a column contains no null or missing values.

This test ensures data completeness by checking for NULL values in a column.
One of the most common data quality tests for required fields.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeNotNull(column="user_id")
>>> test = ColumnValuesToBeNotNull(column="email")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesToBeNotNull.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeNotNull.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesToBeUnique`

```python
ColumnValuesToBeUnique(column, name=None, display_name=None, description=None)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that all values in a column are unique with no duplicates.

This test checks for duplicate values in columns that should contain unique identifiers
or keys. Essential for primary key and unique constraint validation.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeUnique(column="user_id")
>>> test = ColumnValuesToBeUnique(column="email")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesToBeUnique.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToBeUnique.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesToMatchRegex`

```python
ColumnValuesToMatchRegex(
    column, regex, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that column values match a specified regular expression pattern.

This test ensures data format consistency by checking that values conform to
expected patterns. Useful for emails, phone numbers, IDs, and formatted strings.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **regex** (<code>[str](#str)</code>) – Regular expression pattern that values must match
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToMatchRegex(column="email", regex=r"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$")
>>> test = ColumnValuesToMatchRegex(column="phone", regex=r"^\+?1?\d{9,15}$")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesToMatchRegex.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToMatchRegex.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex`

```python
ColumnValuesToNotMatchRegex(
    column, regex, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that column values do not match a forbidden regular expression pattern.

This test detects values that match unwanted patterns, useful for identifying
invalid formats, test data, or security risks.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **regex** (<code>[str](#str)</code>) – Regular expression pattern that values must NOT match
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToNotMatchRegex(column="email", regex=r".*@test\.com$")
>>> test = ColumnValuesToNotMatchRegex(column="name", regex=r"^test.*")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.column_name`

```python
column_name: str = column
```

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.with_compute_row_count`

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

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.ColumnValuesToNotMatchRegex.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableColumnCountToBeBetween`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableColumnCountToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableColumnCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableColumnCountToEqual`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableColumnCountToEqual.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableColumnCountToEqual.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableColumnCountToEqual.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableColumnCountToEqual.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableColumnCountToEqual.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableColumnCountToEqual.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableColumnCountToEqual.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableColumnCountToEqual.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableColumnCountToEqual.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableColumnCountToEqual.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableColumnCountToEqual.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.TableColumnCountToEqual.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.TableColumnCountToEqual.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.TableColumnCountToEqual.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.TableColumnCountToEqual.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.TableColumnCountToEqual.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.TableColumnCountToEqual.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.TableColumnCountToEqual.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.TableColumnCountToEqual.with_compute_row_count`

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

#### `metadata.sdk.data_quality.TableColumnCountToEqual.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableColumnCountToEqual.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableColumnCountToEqual.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableColumnNameToExist`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableColumnNameToExist.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableColumnNameToExist.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableColumnNameToExist.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableColumnNameToExist.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableColumnNameToExist.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableColumnNameToExist.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableColumnNameToExist.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableColumnNameToExist.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableColumnNameToExist.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableColumnNameToExist.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableColumnNameToExist.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.TableColumnNameToExist.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.TableColumnNameToExist.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.TableColumnNameToExist.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.TableColumnNameToExist.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.TableColumnNameToExist.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.TableColumnNameToExist.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.TableColumnNameToExist.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.TableColumnNameToExist.with_compute_row_count`

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

#### `metadata.sdk.data_quality.TableColumnNameToExist.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableColumnNameToExist.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableColumnNameToExist.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableColumnToMatchSet`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableColumnToMatchSet.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableColumnToMatchSet.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableColumnToMatchSet.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableColumnToMatchSet.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableColumnToMatchSet.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableColumnToMatchSet.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableColumnToMatchSet.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableColumnToMatchSet.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableColumnToMatchSet.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableColumnToMatchSet.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableColumnToMatchSet.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.TableColumnToMatchSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.TableColumnToMatchSet.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.TableColumnToMatchSet.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.TableColumnToMatchSet.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.TableColumnToMatchSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.TableColumnToMatchSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.TableColumnToMatchSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.TableColumnToMatchSet.with_compute_row_count`

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

#### `metadata.sdk.data_quality.TableColumnToMatchSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableColumnToMatchSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableColumnToMatchSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableCustomSQLQuery`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableCustomSQLQuery.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableCustomSQLQuery.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableCustomSQLQuery.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableCustomSQLQuery.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableCustomSQLQuery.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableCustomSQLQuery.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableCustomSQLQuery.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableCustomSQLQuery.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableCustomSQLQuery.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableCustomSQLQuery.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableCustomSQLQuery.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.TableCustomSQLQuery.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.TableCustomSQLQuery.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.TableCustomSQLQuery.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.TableCustomSQLQuery.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.TableCustomSQLQuery.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.TableCustomSQLQuery.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.TableCustomSQLQuery.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.TableCustomSQLQuery.with_compute_row_count`

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

#### `metadata.sdk.data_quality.TableCustomSQLQuery.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableCustomSQLQuery.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableCustomSQLQuery.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableDiff`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableDiff.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableDiff.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableDiff.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableDiff.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableDiff.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableDiff.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableDiff.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableDiff.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableDiff.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableDiff.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableDiff.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.TableDiff.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.TableDiff.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.TableDiff.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.TableDiff.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.TableDiff.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.TableDiff.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.TableDiff.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.TableDiff.with_compute_row_count`

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

#### `metadata.sdk.data_quality.TableDiff.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableDiff.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableDiff.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableRowCountToBeBetween`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableRowCountToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableRowCountToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableRowCountToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableRowCountToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableRowCountToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableRowCountToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableRowCountToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableRowCountToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableRowCountToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableRowCountToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableRowCountToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableRowCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableRowCountToEqual`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableRowCountToEqual.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableRowCountToEqual.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableRowCountToEqual.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableRowCountToEqual.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableRowCountToEqual.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableRowCountToEqual.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableRowCountToEqual.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableRowCountToEqual.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableRowCountToEqual.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableRowCountToEqual.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableRowCountToEqual.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.TableRowCountToEqual.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.TableRowCountToEqual.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.TableRowCountToEqual.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.TableRowCountToEqual.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.TableRowCountToEqual.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.TableRowCountToEqual.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.TableRowCountToEqual.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.TableRowCountToEqual.with_compute_row_count`

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

#### `metadata.sdk.data_quality.TableRowCountToEqual.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableRowCountToEqual.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableRowCountToEqual.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.description`

```python
description: Optional[str] = description
```

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.name`

```python
name: Optional[str] = name
```

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.with_compute_row_count`

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

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.TableRowInsertedCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.TableTest`

Bases: <code>[BaseTest](#metadata.sdk.data_quality.tests.base_tests.BaseTest)</code>

Base class for table-level data quality test definitions.

Table tests validate properties of entire tables, such as row counts,
column counts, or custom SQL queries against the table.

All table-level test definitions should inherit from this class.

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.TableTest.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.TableTest.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.TableTest.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.TableTest.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.TableTest.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.TableTest.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.TableTest.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.TableTest.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.TableTest.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.TableTest.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.TableTest.test_definition_name) (<code>[str](#str)</code>) –

### `metadata.sdk.data_quality.TestRunner`

```python
TestRunner(table_fqn, client=None)
```

Simplified test runner for executing data quality tests on OpenMetadata tables.

This class provides a fluent API for defining and executing data quality tests
against tables in OpenMetadata. It handles test case creation, workflow configuration,
and result collection.

The runner automatically fetches table metadata and service connections from OpenMetadata,
builds test cases from test definitions, and executes them using the TestSuiteWorkflow.

**Attributes:**

- [**table_fqn**](#metadata.sdk.data_quality.TestRunner.table_fqn) (<code>[str](#str)</code>) – Fully qualified name of the table to test
- [**client**](#metadata.sdk.data_quality.TestRunner.client) (<code>[OpenMetadata](#metadata.ingestion.ometa.ometa_api.OpenMetadata)\[[Any](#typing.Any), [Any](#typing.Any)\]</code>) – OpenMetadata API client

**Examples:**

```pycon
>>> from metadata.sdk.data_quality import TestRunner, TableRowCountToBeBetween
>>> runner = TestRunner.for_table("MySQL.default.db.table")
>>> runner.add_test(TableRowCountToBeBetween(min_count=100, max_count=1000))
>>> results = runner.run()
```

**Functions:**

- [**add_test**](#metadata.sdk.data_quality.TestRunner.add_test) – Add a test definition to be executed.
- [**add_tests**](#metadata.sdk.data_quality.TestRunner.add_tests) – Add multiple test definitions at once.
- [**for_table**](#metadata.sdk.data_quality.TestRunner.for_table) – Initialize runner for a specific table FQN.
- [**from_yaml**](#metadata.sdk.data_quality.TestRunner.from_yaml) – Build TestRunner from a YAML workflow string.
- [**run**](#metadata.sdk.data_quality.TestRunner.run) – Execute all added tests and return results.
- [**setup**](#metadata.sdk.data_quality.TestRunner.setup) – Change the default configuration for the workflow.

**Parameters:**

- **table_fqn** (<code>[str](#str)</code>) – Fully qualified name of the table
- **client** (<code>[Optional](#typing.Optional)\[[OpenMetadata](#metadata.ingestion.ometa.ometa_api.OpenMetadata)\[[Any](#typing.Any), [Any](#typing.Any)\]\]</code>) – Optional OpenMetadata client (will create one if not provided)

#### `metadata.sdk.data_quality.TestRunner.add_test`

```python
add_test(test_definition)
```

Add a test definition to be executed.

**Parameters:**

- **test_definition** (<code>[BaseTest](#metadata.sdk.data_quality.tests.BaseTest)</code>) – Test definition instance (e.g., TableColumnCountToBeBetween)

**Returns:**

- <code>None</code> – Self for method chaining

#### `metadata.sdk.data_quality.TestRunner.add_tests`

```python
add_tests(*test_definitions)
```

Add multiple test definitions at once.

**Parameters:**

- \***test_definitions** (<code>[BaseTest](#metadata.sdk.data_quality.tests.BaseTest)</code>) – Variable number of test definition instances

**Returns:**

- <code>None</code> – Self for method chaining

**Examples:**

```pycon
>>> runner.add_tests(
...     TableRowCountToBeBetween(min_count=100),
...     ColumnValuesToBeNotNull(column="user_id")
... )
```

#### `metadata.sdk.data_quality.TestRunner.client`

```python
client: OMeta[Any, Any] = client
```

#### `metadata.sdk.data_quality.TestRunner.config_builder`

```python
config_builder: WorkflowConfigBuilder = WorkflowConfigBuilder(client)
```

#### `metadata.sdk.data_quality.TestRunner.for_table`

```python
for_table(table_fqn, client=None)
```

Initialize runner for a specific table FQN.

**Parameters:**

- **table_fqn** (<code>[str](#str)</code>) – Fully qualified name of the table (e.g., "MySQL.default.db.table")
- **client** (<code>[Optional](#typing.Optional)\[[OpenMetadata](#metadata.ingestion.ometa.ometa_api.OpenMetadata)\[[Any](#typing.Any), [Any](#typing.Any)\]\]</code>) – Optional OpenMetadata client (will create one if not provided)

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – TestRunner instance

**Examples:**

```pycon
>>> from metadata.sdk.data_quality import TestRunner, TableColumnCountToBeBetween
>>> runner = TestRunner.for_table("MySQL.default.db.table")
>>> runner.add_test(TableColumnCountToBeBetween(min_count=10))
>>> results = runner.run()
```

#### `metadata.sdk.data_quality.TestRunner.from_yaml`

```python
from_yaml(
    *,
    yaml_string=None,
    file_path=None,
    use_connection_from_yaml=False,
    client=None
)
```

Build TestRunner from a YAML workflow string.

#### `metadata.sdk.data_quality.TestRunner.run`

```python
run()
```

Execute all added tests and return results.

**Returns:**

- <code>[List](#typing.List)\[[TestCaseResultResponse](#metadata.data_quality.api.models.TestCaseResultResponse)\]</code> – List of test case results

#### `metadata.sdk.data_quality.TestRunner.setup`

```python
setup(
    force_test_update=False,
    log_level=LogLevels.INFO,
    raise_on_error=False,
    success_threshold=90,
    enable_streamable_logs=False,
)
```

Change the default configuration for the workflow.

**Parameters:**

- **force_test_update** (<code>[bool](#bool)</code>) – Force test update even if tests already exist.
- **log_level** (<code>[LogLevels](#metadata.generated.schema.metadataIngestion.workflow.LogLevels)</code>) – Log level to use.
- **raise_on_error** (<code>[bool](#bool)</code>) – Raise exception if test data already exists.
- **success_threshold** (<code>[int](#int)</code>) – threshold below which the test will fail.
- **enable_streamable_logs** (<code>[bool](#bool)</code>) – Enable streamable logs.

**Returns:**

- <code>None</code> – None

#### `metadata.sdk.data_quality.TestRunner.table_fqn`

```python
table_fqn: str = table_fqn
```

#### `metadata.sdk.data_quality.TestRunner.test_definitions`

```python
test_definitions: List[TestCaseDefinition]
```

### `metadata.sdk.data_quality.result_capturing_processor`

Processor wrapper that captures test case results without modifying the processor.

**Classes:**

- [**ResultCapturingProcessor**](#metadata.sdk.data_quality.result_capturing_processor.ResultCapturingProcessor) – Wraps a processor to capture TestCaseResults without modifying it.

#### `metadata.sdk.data_quality.result_capturing_processor.ResultCapturingProcessor`

```python
ResultCapturingProcessor(processor)
```

Bases: <code>[Processor](#metadata.ingestion.api.steps.Processor)</code>

Wraps a processor to capture TestCaseResults without modifying it.

This processor wrapper intercepts the \_run() method to extract and store
TestCaseResultResponse objects while delegating all processing to the wrapped
processor. All other attributes are delegated to the wrapped processor.

**Functions:**

- [**close**](#metadata.sdk.data_quality.result_capturing_processor.ResultCapturingProcessor.close) – Delegate close to wrapped processor.
- [**create**](#metadata.sdk.data_quality.result_capturing_processor.ResultCapturingProcessor.create) – Not used - ResultCapturingProcessor wraps existing processors.
- [**get_results**](#metadata.sdk.data_quality.result_capturing_processor.ResultCapturingProcessor.get_results) – Return all captured test case results.

##### `metadata.sdk.data_quality.result_capturing_processor.ResultCapturingProcessor.close`

```python
close()
```

Delegate close to wrapped processor.

##### `metadata.sdk.data_quality.result_capturing_processor.ResultCapturingProcessor.create`

```python
create(config_dict, metadata, pipeline_name=None)
```

Not used - ResultCapturingProcessor wraps existing processors.

##### `metadata.sdk.data_quality.result_capturing_processor.ResultCapturingProcessor.get_results`

```python
get_results()
```

Return all captured test case results.

### `metadata.sdk.data_quality.runner`

Class that allows running data quality checks by code

**Classes:**

- [**TestRunner**](#metadata.sdk.data_quality.runner.TestRunner) – Simplified test runner for executing data quality tests on OpenMetadata tables.

#### `metadata.sdk.data_quality.runner.TestRunner`

```python
TestRunner(table_fqn, client=None)
```

Simplified test runner for executing data quality tests on OpenMetadata tables.

This class provides a fluent API for defining and executing data quality tests
against tables in OpenMetadata. It handles test case creation, workflow configuration,
and result collection.

The runner automatically fetches table metadata and service connections from OpenMetadata,
builds test cases from test definitions, and executes them using the TestSuiteWorkflow.

**Attributes:**

- [**table_fqn**](#metadata.sdk.data_quality.runner.TestRunner.table_fqn) (<code>[str](#str)</code>) – Fully qualified name of the table to test
- [**client**](#metadata.sdk.data_quality.runner.TestRunner.client) (<code>[OpenMetadata](#metadata.ingestion.ometa.ometa_api.OpenMetadata)\[[Any](#typing.Any), [Any](#typing.Any)\]</code>) – OpenMetadata API client

**Examples:**

```pycon
>>> from metadata.sdk.data_quality import TestRunner, TableRowCountToBeBetween
>>> runner = TestRunner.for_table("MySQL.default.db.table")
>>> runner.add_test(TableRowCountToBeBetween(min_count=100, max_count=1000))
>>> results = runner.run()
```

**Functions:**

- [**add_test**](#metadata.sdk.data_quality.runner.TestRunner.add_test) – Add a test definition to be executed.
- [**add_tests**](#metadata.sdk.data_quality.runner.TestRunner.add_tests) – Add multiple test definitions at once.
- [**for_table**](#metadata.sdk.data_quality.runner.TestRunner.for_table) – Initialize runner for a specific table FQN.
- [**from_yaml**](#metadata.sdk.data_quality.runner.TestRunner.from_yaml) – Build TestRunner from a YAML workflow string.
- [**run**](#metadata.sdk.data_quality.runner.TestRunner.run) – Execute all added tests and return results.
- [**setup**](#metadata.sdk.data_quality.runner.TestRunner.setup) – Change the default configuration for the workflow.

**Parameters:**

- **table_fqn** (<code>[str](#str)</code>) – Fully qualified name of the table
- **client** (<code>[Optional](#typing.Optional)\[[OpenMetadata](#metadata.ingestion.ometa.ometa_api.OpenMetadata)\[[Any](#typing.Any), [Any](#typing.Any)\]\]</code>) – Optional OpenMetadata client (will create one if not provided)

##### `metadata.sdk.data_quality.runner.TestRunner.add_test`

```python
add_test(test_definition)
```

Add a test definition to be executed.

**Parameters:**

- **test_definition** (<code>[BaseTest](#metadata.sdk.data_quality.tests.BaseTest)</code>) – Test definition instance (e.g., TableColumnCountToBeBetween)

**Returns:**

- <code>None</code> – Self for method chaining

##### `metadata.sdk.data_quality.runner.TestRunner.add_tests`

```python
add_tests(*test_definitions)
```

Add multiple test definitions at once.

**Parameters:**

- \***test_definitions** (<code>[BaseTest](#metadata.sdk.data_quality.tests.BaseTest)</code>) – Variable number of test definition instances

**Returns:**

- <code>None</code> – Self for method chaining

**Examples:**

```pycon
>>> runner.add_tests(
...     TableRowCountToBeBetween(min_count=100),
...     ColumnValuesToBeNotNull(column="user_id")
... )
```

##### `metadata.sdk.data_quality.runner.TestRunner.client`

```python
client: OMeta[Any, Any] = client
```

##### `metadata.sdk.data_quality.runner.TestRunner.config_builder`

```python
config_builder: WorkflowConfigBuilder = WorkflowConfigBuilder(client)
```

##### `metadata.sdk.data_quality.runner.TestRunner.for_table`

```python
for_table(table_fqn, client=None)
```

Initialize runner for a specific table FQN.

**Parameters:**

- **table_fqn** (<code>[str](#str)</code>) – Fully qualified name of the table (e.g., "MySQL.default.db.table")
- **client** (<code>[Optional](#typing.Optional)\[[OpenMetadata](#metadata.ingestion.ometa.ometa_api.OpenMetadata)\[[Any](#typing.Any), [Any](#typing.Any)\]\]</code>) – Optional OpenMetadata client (will create one if not provided)

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – TestRunner instance

**Examples:**

```pycon
>>> from metadata.sdk.data_quality import TestRunner, TableColumnCountToBeBetween
>>> runner = TestRunner.for_table("MySQL.default.db.table")
>>> runner.add_test(TableColumnCountToBeBetween(min_count=10))
>>> results = runner.run()
```

##### `metadata.sdk.data_quality.runner.TestRunner.from_yaml`

```python
from_yaml(
    *,
    yaml_string=None,
    file_path=None,
    use_connection_from_yaml=False,
    client=None
)
```

Build TestRunner from a YAML workflow string.

##### `metadata.sdk.data_quality.runner.TestRunner.run`

```python
run()
```

Execute all added tests and return results.

**Returns:**

- <code>[List](#typing.List)\[[TestCaseResultResponse](#metadata.data_quality.api.models.TestCaseResultResponse)\]</code> – List of test case results

##### `metadata.sdk.data_quality.runner.TestRunner.setup`

```python
setup(
    force_test_update=False,
    log_level=LogLevels.INFO,
    raise_on_error=False,
    success_threshold=90,
    enable_streamable_logs=False,
)
```

Change the default configuration for the workflow.

**Parameters:**

- **force_test_update** (<code>[bool](#bool)</code>) – Force test update even if tests already exist.
- **log_level** (<code>[LogLevels](#metadata.generated.schema.metadataIngestion.workflow.LogLevels)</code>) – Log level to use.
- **raise_on_error** (<code>[bool](#bool)</code>) – Raise exception if test data already exists.
- **success_threshold** (<code>[int](#int)</code>) – threshold below which the test will fail.
- **enable_streamable_logs** (<code>[bool](#bool)</code>) – Enable streamable logs.

**Returns:**

- <code>None</code> – None

##### `metadata.sdk.data_quality.runner.TestRunner.table_fqn`

```python
table_fqn: str = table_fqn
```

##### `metadata.sdk.data_quality.runner.TestRunner.test_definitions`

```python
test_definitions: List[TestCaseDefinition]
```

### `metadata.sdk.data_quality.tests`

Convenience classes that represent test definitions

**Modules:**

- [**base_tests**](#metadata.sdk.data_quality.tests.base_tests) – Test definition wrappers for simplified DQ as Code API.
- [**column_tests**](#metadata.sdk.data_quality.tests.column_tests) – Column-level test definitions for DQ as Code API.
- [**table_tests**](#metadata.sdk.data_quality.tests.table_tests) – Table-level test definitions for DQ as Code API.

**Classes:**

- [**BaseTest**](#metadata.sdk.data_quality.tests.BaseTest) – Base class for all data quality test definitions.
- [**ColumnTest**](#metadata.sdk.data_quality.tests.ColumnTest) – Base class for column-level data quality test definitions.
- [**ColumnValueLengthsToBeBetween**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween) – Validates that the length of string values in a column falls within a specified range.
- [**ColumnValueMaxToBeBetween**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween) – Validates that the maximum value in a column falls within a specified range.
- [**ColumnValueMeanToBeBetween**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween) – Validates that the mean (average) value in a column falls within a specified range.
- [**ColumnValueMedianToBeBetween**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween) – Validates that the median value in a column falls within a specified range.
- [**ColumnValueMinToBeBetween**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween) – Validates that the minimum value in a column falls within a specified range.
- [**ColumnValueStdDevToBeBetween**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween) – Validates that the standard deviation of column values falls within a specified range.
- [**ColumnValuesMissingCount**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount) – Validates that the count of missing or null values meets expectations.
- [**ColumnValuesSumToBeBetween**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween) – Validates that the sum of all values in a column falls within a specified range.
- [**ColumnValuesToBeAtExpectedLocation**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation) – Validates that a specific value appears at an expected row position.
- [**ColumnValuesToBeBetween**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween) – Validates that all values in a column fall within a specified numeric range.
- [**ColumnValuesToBeInSet**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet) – Validates that all values in a column belong to a specified set of allowed values.
- [**ColumnValuesToBeNotInSet**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet) – Validates that column values do not contain any forbidden values.
- [**ColumnValuesToBeNotNull**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull) – Validates that a column contains no null or missing values.
- [**ColumnValuesToBeUnique**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique) – Validates that all values in a column are unique with no duplicates.
- [**ColumnValuesToMatchRegex**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex) – Validates that column values match a specified regular expression pattern.
- [**ColumnValuesToNotMatchRegex**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex) – Validates that column values do not match a forbidden regular expression pattern.
- [**TableColumnCountToBeBetween**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween) – Validates that the number of columns in a table falls within a specified range.
- [**TableColumnCountToEqual**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual) – Validates that the table has an exact number of columns.
- [**TableColumnNameToExist**](#metadata.sdk.data_quality.tests.TableColumnNameToExist) – Validates that a specific column exists in the table schema.
- [**TableColumnToMatchSet**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet) – Validates that table columns match an expected set of column names.
- [**TableCustomSQLQuery**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery) – Validates data using a custom SQL query expression.
- [**TableDiff**](#metadata.sdk.data_quality.tests.TableDiff) – Compares two tables and identifies differences in their data.
- [**TableRowCountToBeBetween**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween) – Validates that the number of rows in a table falls within a specified range.
- [**TableRowCountToEqual**](#metadata.sdk.data_quality.tests.TableRowCountToEqual) – Validates that the table has an exact number of rows.
- [**TableRowInsertedCountToBeBetween**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween) – Validates that the number of rows inserted within a time range is within bounds.
- [**TableTest**](#metadata.sdk.data_quality.tests.TableTest) – Base class for table-level data quality test definitions.

#### `metadata.sdk.data_quality.tests.BaseTest`

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

- [**test_definition_name**](#metadata.sdk.data_quality.tests.BaseTest.test_definition_name) (<code>[str](#str)</code>) – Internal name of the test definition type
- [**parameters**](#metadata.sdk.data_quality.tests.BaseTest.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) – List of test case parameter values
- [**name**](#metadata.sdk.data_quality.tests.BaseTest.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Unique identifier for this test case instance
- [**display_name**](#metadata.sdk.data_quality.tests.BaseTest.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Human-readable name shown in UI
- [**description**](#metadata.sdk.data_quality.tests.BaseTest.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Detailed description of what the test validates
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.BaseTest.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) – Whether to compute row-level pass/fail counts

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.BaseTest.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.BaseTest.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.BaseTest.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.BaseTest.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.BaseTest.with_name) – Set a custom test case name.

**Parameters:**

- **test_definition_name** (<code>[str](#str)</code>) – Internal name matching the test definition in OpenMetadata
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Unique identifier for this test case (auto-generated if not provided)
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Human-readable name for UI display (auto-generated if not provided)
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Description of what this test validates (auto-generated if not provided)

##### `metadata.sdk.data_quality.tests.BaseTest.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.BaseTest.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.BaseTest.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.BaseTest.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.BaseTest.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.BaseTest.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.BaseTest.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.BaseTest.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.BaseTest.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.BaseTest.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.BaseTest.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnTest`

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

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnTest.column_name) (<code>[str](#str)</code>) – Name of the column this test validates

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnTest.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnTest.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnTest.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnTest.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnTest.with_name) – Set a custom test case name.

**Parameters:**

- **test_definition_name** (<code>[str](#str)</code>) – Internal name matching the test definition in OpenMetadata
- **column** (<code>[str](#str)</code>) – Name of the column to test
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Unique identifier for this test case (auto-generated if not provided)
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Human-readable name for UI display (auto-generated if not provided)
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Description of what this test validates (auto-generated if not provided)

##### `metadata.sdk.data_quality.tests.ColumnTest.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnTest.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnTest.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnTest.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnTest.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnTest.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnTest.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnTest.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnTest.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnTest.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnTest.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnTest.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween`

```python
ColumnValueLengthsToBeBetween(
    column,
    min_length=None,
    max_length=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the length of string values in a column falls within a specified range.

This test checks character count for text columns, useful for validating string
constraints, preventing truncation, and ensuring data format compliance.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_length** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Minimum acceptable string length
- **max_length** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Maximum acceptable string length
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueLengthsToBeBetween(column="username", min_length=3, max_length=20)
>>> test = ColumnValueLengthsToBeBetween(column="description", min_length=10, max_length=500)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueLengthsToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween`

```python
ColumnValueMaxToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the maximum value in a column falls within a specified range.

This test computes the maximum value across all rows and checks if it's within bounds.
Useful for monitoring data ranges and detecting outliers in the upper range.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable maximum value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable maximum value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMaxToBeBetween(column="temperature", min_value=-50, max_value=50)
>>> test = ColumnValueMaxToBeBetween(column="score", min_value=90, max_value=100)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueMaxToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween`

```python
ColumnValueMeanToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the mean (average) value in a column falls within a specified range.

This test computes the arithmetic mean of all values and checks if it's within bounds.
Useful for statistical validation and detecting data drift in numeric columns.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable mean value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable mean value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMeanToBeBetween(column="rating", min_value=3.0, max_value=4.5)
>>> test = ColumnValueMeanToBeBetween(column="response_time_ms", min_value=100, max_value=500)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueMeanToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween`

```python
ColumnValueMedianToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the median value in a column falls within a specified range.

This test computes the median (middle value) and checks if it's within bounds.
More robust than mean for skewed distributions, useful for detecting outliers.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable median value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable median value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMedianToBeBetween(column="salary", min_value=50000, max_value=75000)
>>> test = ColumnValueMedianToBeBetween(column="age", min_value=25, max_value=45)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueMedianToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween`

```python
ColumnValueMinToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the minimum value in a column falls within a specified range.

This test computes the minimum value across all rows and checks if it's within bounds.
Useful for monitoring data ranges and detecting outliers in the lower range.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable minimum value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable minimum value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMinToBeBetween(column="temperature", min_value=-50, max_value=0)
>>> test = ColumnValueMinToBeBetween(column="age", min_value=0, max_value=18)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueMinToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween`

```python
ColumnValueStdDevToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the standard deviation of column values falls within a specified range.

This test computes the standard deviation (measure of variance) and checks if it's within bounds.
Useful for detecting unexpected data variability or consistency issues.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable standard deviation
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable standard deviation
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueStdDevToBeBetween(column="response_time", min_value=0, max_value=100)
>>> test = ColumnValueStdDevToBeBetween(column="score", min_value=5, max_value=15)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValueStdDevToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount`

```python
ColumnValuesMissingCount(
    column,
    missing_count_value=None,
    missing_value_match=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the count of missing or null values meets expectations.

This test counts rows with missing values and validates against expected thresholds.
Supports custom missing value patterns beyond NULL (e.g., "N/A", "", "NULL").

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **missing_count_value** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Expected number of missing values
- **missing_value_match** (<code>[Optional](#typing.Optional)\[[List](#typing.List)\[[str](#str)\]\]</code>) – List of strings to treat as missing values (optional)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesMissingCount(column="optional_field", missing_count_value=100)
>>> test = ColumnValuesMissingCount(column="status", missing_value_match=["N/A", "Unknown"])
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesMissingCount.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesMissingCount.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween`

```python
ColumnValuesSumToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the sum of all values in a column falls within a specified range.

This test computes the total sum across all rows and checks if it's within bounds.
Useful for validating totals, aggregates, and detecting unexpected data volumes.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable sum
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable sum
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesSumToBeBetween(column="revenue", min_value=1000000, max_value=5000000)
>>> test = ColumnValuesSumToBeBetween(column="quantity", min_value=100, max_value=1000)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesSumToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation`

```python
ColumnValuesToBeAtExpectedLocation(
    column,
    expected_value,
    row_index=0,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that a specific value appears at an expected row position.

This test checks for an exact value at a particular row index, useful for validating
sorted data, header rows, or expected entries at known positions.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **expected_value** (<code>[str](#str)</code>) – The exact value expected at the specified location
- **row_index** (<code>[int](#int)</code>) – Zero-based row position to check (default: 0)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeAtExpectedLocation(column="id", expected_value="1", row_index=0)
>>> test = ColumnValuesToBeAtExpectedLocation(column="rank", expected_value="first", row_index=0)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeAtExpectedLocation.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween`

```python
ColumnValuesToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that all values in a column fall within a specified numeric range.

This test checks that individual column values are between minimum and maximum bounds.
Useful for validating numeric constraints, age ranges, prices, quantities, etc.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable value (inclusive)
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable value (inclusive)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeBetween(column="age", min_value=0, max_value=120)
>>> test = ColumnValuesToBeBetween(column="price", min_value=0.01, max_value=9999.99)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet`

```python
ColumnValuesToBeInSet(
    column, allowed_values, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that all values in a column belong to a specified set of allowed values.

This test ensures data integrity by checking that column values are constrained
to a predefined list. Useful for enum-like columns or categorical data.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **allowed_values** (<code>[List](#typing.List)\[[str](#str)\]</code>) – List of acceptable values for the column
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeInSet(column="status", allowed_values=["active", "inactive", "pending"])
>>> test = ColumnValuesToBeInSet(column="country_code", allowed_values=["US", "UK", "CA"])
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeInSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet`

```python
ColumnValuesToBeNotInSet(
    column, forbidden_values, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that column values do not contain any forbidden values.

This test detects the presence of blacklisted or invalid values in a column.
Useful for data quality checks where certain values should never appear.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **forbidden_values** (<code>[List](#typing.List)\[[str](#str)\]</code>) – List of values that must not appear in the column
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeNotInSet(column="email", forbidden_values=["test@test.com", "admin@admin.com"])
>>> test = ColumnValuesToBeNotInSet(column="status", forbidden_values=["deleted", "archived"])
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotInSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull`

```python
ColumnValuesToBeNotNull(column, name=None, display_name=None, description=None)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that a column contains no null or missing values.

This test ensures data completeness by checking for NULL values in a column.
One of the most common data quality tests for required fields.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeNotNull(column="user_id")
>>> test = ColumnValuesToBeNotNull(column="email")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeNotNull.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique`

```python
ColumnValuesToBeUnique(column, name=None, display_name=None, description=None)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that all values in a column are unique with no duplicates.

This test checks for duplicate values in columns that should contain unique identifiers
or keys. Essential for primary key and unique constraint validation.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeUnique(column="user_id")
>>> test = ColumnValuesToBeUnique(column="email")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToBeUnique.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex`

```python
ColumnValuesToMatchRegex(
    column, regex, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that column values match a specified regular expression pattern.

This test ensures data format consistency by checking that values conform to
expected patterns. Useful for emails, phone numbers, IDs, and formatted strings.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **regex** (<code>[str](#str)</code>) – Regular expression pattern that values must match
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToMatchRegex(column="email", regex=r"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$")
>>> test = ColumnValuesToMatchRegex(column="phone", regex=r"^\+?1?\d{9,15}$")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToMatchRegex.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex`

```python
ColumnValuesToNotMatchRegex(
    column, regex, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that column values do not match a forbidden regular expression pattern.

This test detects values that match unwanted patterns, useful for identifying
invalid formats, test data, or security risks.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **regex** (<code>[str](#str)</code>) – Regular expression pattern that values must NOT match
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToNotMatchRegex(column="email", regex=r".*@test\.com$")
>>> test = ColumnValuesToNotMatchRegex(column="name", regex=r"^test.*")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.column_name`

```python
column_name: str = column
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.ColumnValuesToNotMatchRegex.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableColumnCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableColumnCountToEqual`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableColumnCountToEqual.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableColumnCountToEqual.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableColumnNameToExist`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableColumnNameToExist.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableColumnNameToExist.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableColumnToMatchSet`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableColumnToMatchSet.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableColumnToMatchSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableCustomSQLQuery`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableCustomSQLQuery.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableCustomSQLQuery.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableDiff`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableDiff.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableDiff.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableDiff.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableDiff.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableDiff.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableDiff.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableDiff.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableDiff.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableDiff.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableDiff.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableDiff.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.TableDiff.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.TableDiff.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.TableDiff.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.TableDiff.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.TableDiff.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.TableDiff.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.TableDiff.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.TableDiff.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.TableDiff.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableDiff.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableDiff.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableRowCountToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableRowCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableRowCountToEqual`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableRowCountToEqual.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableRowCountToEqual.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween`

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

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.description`

```python
description: Optional[str] = description
```

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.name`

```python
name: Optional[str] = name
```

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.with_compute_row_count`

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

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.TableRowInsertedCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.TableTest`

Bases: <code>[BaseTest](#metadata.sdk.data_quality.tests.base_tests.BaseTest)</code>

Base class for table-level data quality test definitions.

Table tests validate properties of entire tables, such as row counts,
column counts, or custom SQL queries against the table.

All table-level test definitions should inherit from this class.

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.TableTest.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.TableTest.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.TableTest.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.TableTest.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.TableTest.with_name) – Set a custom test case name.

**Attributes:**

- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.TableTest.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.TableTest.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.TableTest.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.TableTest.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.TableTest.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.TableTest.test_definition_name) (<code>[str](#str)</code>) –

#### `metadata.sdk.data_quality.tests.base_tests`

Test definition wrappers for simplified DQ as Code API.

**Classes:**

- [**BaseTest**](#metadata.sdk.data_quality.tests.base_tests.BaseTest) – Base class for all data quality test definitions.
- [**ColumnTest**](#metadata.sdk.data_quality.tests.base_tests.ColumnTest) – Base class for column-level data quality test definitions.
- [**TableTest**](#metadata.sdk.data_quality.tests.base_tests.TableTest) – Base class for table-level data quality test definitions.

##### `metadata.sdk.data_quality.tests.base_tests.BaseTest`

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

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.base_tests.BaseTest.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.base_tests.ColumnTest`

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

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.base_tests.ColumnTest.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.base_tests.TableTest`

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

#### `metadata.sdk.data_quality.tests.column_tests`

Column-level test definitions for DQ as Code API.

**Classes:**

- [**ColumnValueLengthsToBeBetween**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween) – Validates that the length of string values in a column falls within a specified range.
- [**ColumnValueMaxToBeBetween**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween) – Validates that the maximum value in a column falls within a specified range.
- [**ColumnValueMeanToBeBetween**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween) – Validates that the mean (average) value in a column falls within a specified range.
- [**ColumnValueMedianToBeBetween**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween) – Validates that the median value in a column falls within a specified range.
- [**ColumnValueMinToBeBetween**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween) – Validates that the minimum value in a column falls within a specified range.
- [**ColumnValueStdDevToBeBetween**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween) – Validates that the standard deviation of column values falls within a specified range.
- [**ColumnValuesMissingCount**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount) – Validates that the count of missing or null values meets expectations.
- [**ColumnValuesSumToBeBetween**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween) – Validates that the sum of all values in a column falls within a specified range.
- [**ColumnValuesToBeAtExpectedLocation**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation) – Validates that a specific value appears at an expected row position.
- [**ColumnValuesToBeBetween**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween) – Validates that all values in a column fall within a specified numeric range.
- [**ColumnValuesToBeInSet**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet) – Validates that all values in a column belong to a specified set of allowed values.
- [**ColumnValuesToBeNotInSet**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet) – Validates that column values do not contain any forbidden values.
- [**ColumnValuesToBeNotNull**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull) – Validates that a column contains no null or missing values.
- [**ColumnValuesToBeUnique**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique) – Validates that all values in a column are unique with no duplicates.
- [**ColumnValuesToMatchRegex**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex) – Validates that column values match a specified regular expression pattern.
- [**ColumnValuesToNotMatchRegex**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex) – Validates that column values do not match a forbidden regular expression pattern.

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween`

```python
ColumnValueLengthsToBeBetween(
    column,
    min_length=None,
    max_length=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the length of string values in a column falls within a specified range.

This test checks character count for text columns, useful for validating string
constraints, preventing truncation, and ensuring data format compliance.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_length** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Minimum acceptable string length
- **max_length** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Maximum acceptable string length
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueLengthsToBeBetween(column="username", min_length=3, max_length=20)
>>> test = ColumnValueLengthsToBeBetween(column="description", min_length=10, max_length=500)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueLengthsToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween`

```python
ColumnValueMaxToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the maximum value in a column falls within a specified range.

This test computes the maximum value across all rows and checks if it's within bounds.
Useful for monitoring data ranges and detecting outliers in the upper range.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable maximum value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable maximum value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMaxToBeBetween(column="temperature", min_value=-50, max_value=50)
>>> test = ColumnValueMaxToBeBetween(column="score", min_value=90, max_value=100)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMaxToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween`

```python
ColumnValueMeanToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the mean (average) value in a column falls within a specified range.

This test computes the arithmetic mean of all values and checks if it's within bounds.
Useful for statistical validation and detecting data drift in numeric columns.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable mean value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable mean value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMeanToBeBetween(column="rating", min_value=3.0, max_value=4.5)
>>> test = ColumnValueMeanToBeBetween(column="response_time_ms", min_value=100, max_value=500)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMeanToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween`

```python
ColumnValueMedianToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the median value in a column falls within a specified range.

This test computes the median (middle value) and checks if it's within bounds.
More robust than mean for skewed distributions, useful for detecting outliers.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable median value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable median value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMedianToBeBetween(column="salary", min_value=50000, max_value=75000)
>>> test = ColumnValueMedianToBeBetween(column="age", min_value=25, max_value=45)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMedianToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween`

```python
ColumnValueMinToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the minimum value in a column falls within a specified range.

This test computes the minimum value across all rows and checks if it's within bounds.
Useful for monitoring data ranges and detecting outliers in the lower range.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable minimum value
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable minimum value
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueMinToBeBetween(column="temperature", min_value=-50, max_value=0)
>>> test = ColumnValueMinToBeBetween(column="age", min_value=0, max_value=18)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueMinToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween`

```python
ColumnValueStdDevToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the standard deviation of column values falls within a specified range.

This test computes the standard deviation (measure of variance) and checks if it's within bounds.
Useful for detecting unexpected data variability or consistency issues.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable standard deviation
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable standard deviation
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValueStdDevToBeBetween(column="response_time", min_value=0, max_value=100)
>>> test = ColumnValueStdDevToBeBetween(column="score", min_value=5, max_value=15)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValueStdDevToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount`

```python
ColumnValuesMissingCount(
    column,
    missing_count_value=None,
    missing_value_match=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the count of missing or null values meets expectations.

This test counts rows with missing values and validates against expected thresholds.
Supports custom missing value patterns beyond NULL (e.g., "N/A", "", "NULL").

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **missing_count_value** (<code>[Optional](#typing.Optional)\[[int](#int)\]</code>) – Expected number of missing values
- **missing_value_match** (<code>[Optional](#typing.Optional)\[[List](#typing.List)\[[str](#str)\]\]</code>) – List of strings to treat as missing values (optional)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesMissingCount(column="optional_field", missing_count_value=100)
>>> test = ColumnValuesMissingCount(column="status", missing_value_match=["N/A", "Unknown"])
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesMissingCount.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween`

```python
ColumnValuesSumToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that the sum of all values in a column falls within a specified range.

This test computes the total sum across all rows and checks if it's within bounds.
Useful for validating totals, aggregates, and detecting unexpected data volumes.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable sum
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable sum
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesSumToBeBetween(column="revenue", min_value=1000000, max_value=5000000)
>>> test = ColumnValuesSumToBeBetween(column="quantity", min_value=100, max_value=1000)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesSumToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation`

```python
ColumnValuesToBeAtExpectedLocation(
    column,
    expected_value,
    row_index=0,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that a specific value appears at an expected row position.

This test checks for an exact value at a particular row index, useful for validating
sorted data, header rows, or expected entries at known positions.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **expected_value** (<code>[str](#str)</code>) – The exact value expected at the specified location
- **row_index** (<code>[int](#int)</code>) – Zero-based row position to check (default: 0)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeAtExpectedLocation(column="id", expected_value="1", row_index=0)
>>> test = ColumnValuesToBeAtExpectedLocation(column="rank", expected_value="first", row_index=0)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeAtExpectedLocation.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween`

```python
ColumnValuesToBeBetween(
    column,
    min_value=None,
    max_value=None,
    name=None,
    display_name=None,
    description=None,
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that all values in a column fall within a specified numeric range.

This test checks that individual column values are between minimum and maximum bounds.
Useful for validating numeric constraints, age ranges, prices, quantities, etc.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **min_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Minimum acceptable value (inclusive)
- **max_value** (<code>[Optional](#typing.Optional)\[[float](#float)\]</code>) – Maximum acceptable value (inclusive)
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeBetween(column="age", min_value=0, max_value=120)
>>> test = ColumnValuesToBeBetween(column="price", min_value=0.01, max_value=9999.99)
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet`

```python
ColumnValuesToBeInSet(
    column, allowed_values, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that all values in a column belong to a specified set of allowed values.

This test ensures data integrity by checking that column values are constrained
to a predefined list. Useful for enum-like columns or categorical data.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **allowed_values** (<code>[List](#typing.List)\[[str](#str)\]</code>) – List of acceptable values for the column
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeInSet(column="status", allowed_values=["active", "inactive", "pending"])
>>> test = ColumnValuesToBeInSet(column="country_code", allowed_values=["US", "UK", "CA"])
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeInSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet`

```python
ColumnValuesToBeNotInSet(
    column, forbidden_values, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that column values do not contain any forbidden values.

This test detects the presence of blacklisted or invalid values in a column.
Useful for data quality checks where certain values should never appear.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **forbidden_values** (<code>[List](#typing.List)\[[str](#str)\]</code>) – List of values that must not appear in the column
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeNotInSet(column="email", forbidden_values=["test@test.com", "admin@admin.com"])
>>> test = ColumnValuesToBeNotInSet(column="status", forbidden_values=["deleted", "archived"])
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotInSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull`

```python
ColumnValuesToBeNotNull(column, name=None, display_name=None, description=None)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that a column contains no null or missing values.

This test ensures data completeness by checking for NULL values in a column.
One of the most common data quality tests for required fields.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeNotNull(column="user_id")
>>> test = ColumnValuesToBeNotNull(column="email")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeNotNull.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique`

```python
ColumnValuesToBeUnique(column, name=None, display_name=None, description=None)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that all values in a column are unique with no duplicates.

This test checks for duplicate values in columns that should contain unique identifiers
or keys. Essential for primary key and unique constraint validation.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToBeUnique(column="user_id")
>>> test = ColumnValuesToBeUnique(column="email")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToBeUnique.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex`

```python
ColumnValuesToMatchRegex(
    column, regex, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that column values match a specified regular expression pattern.

This test ensures data format consistency by checking that values conform to
expected patterns. Useful for emails, phone numbers, IDs, and formatted strings.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **regex** (<code>[str](#str)</code>) – Regular expression pattern that values must match
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToMatchRegex(column="email", regex=r"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$")
>>> test = ColumnValuesToMatchRegex(column="phone", regex=r"^\+?1?\d{9,15}$")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToMatchRegex.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex`

```python
ColumnValuesToNotMatchRegex(
    column, regex, name=None, display_name=None, description=None
)
```

Bases: <code>[ColumnTest](#metadata.sdk.data_quality.tests.base_tests.ColumnTest)</code>

Validates that column values do not match a forbidden regular expression pattern.

This test detects values that match unwanted patterns, useful for identifying
invalid formats, test data, or security risks.

**Parameters:**

- **column** (<code>[str](#str)</code>) – Name of the column to validate
- **regex** (<code>[str](#str)</code>) – Regular expression pattern that values must NOT match
- **name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test case name
- **display_name** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom display name for UI
- **description** (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) – Custom test description

**Examples:**

```pycon
>>> test = ColumnValuesToNotMatchRegex(column="email", regex=r".*@test\.com$")
>>> test = ColumnValuesToNotMatchRegex(column="name", regex=r"^test.*")
```

**Functions:**

- [**to_test_case_definition**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.to_test_case_definition) – Create a test case definition from this test definition.
- [**with_compute_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.with_compute_row_count) – Enable or disable passed/failed row count computation.
- [**with_description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.with_description) – Set a custom description.
- [**with_display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.with_display_name) – Set a custom display name.
- [**with_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.with_name) – Set a custom test case name.

**Attributes:**

- [**column_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.column_name) (<code>[str](#str)</code>) –
- [**compute_passed_failed_row_count**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.compute_passed_failed_row_count) (<code>[bool](#bool)</code>) –
- [**description**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.description) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**display_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.display_name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.name) (<code>[Optional](#typing.Optional)\[[str](#str)\]</code>) –
- [**parameters**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.parameters) (<code>[List](#typing.List)\[[TestCaseParameterValue](#metadata.generated.schema.tests.testCase.TestCaseParameterValue)\]</code>) –
- [**test_definition_name**](#metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.test_definition_name) (<code>[str](#str)</code>) –

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.column_name`

```python
column_name: str = column
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.column_tests.ColumnValuesToNotMatchRegex.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

#### `metadata.sdk.data_quality.tests.table_tests`

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

##### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnCountToEqual.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnNameToExist.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableColumnToMatchSet.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableCustomSQLQuery.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.table_tests.TableDiff`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableDiff.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableRowCountToEqual.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.compute_passed_failed_row_count`

```python
compute_passed_failed_row_count: bool = compute_passed_failed_row_count
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.description`

```python
description: Optional[str] = description
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.display_name`

```python
display_name: Optional[str] = display_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.name`

```python
name: Optional[str] = name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.parameters`

```python
parameters: List[TestCaseParameterValue] = []
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.test_definition_name`

```python
test_definition_name: str = test_definition_name
```

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.to_test_case_definition`

```python
to_test_case_definition()
```

Create a test case definition from this test definition.
Returns:
TestCaseDefinition instance

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_compute_row_count`

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

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_description`

```python
with_description(description)
```

Set a custom description.

**Parameters:**

- **description** (<code>[str](#str)</code>) – Detailed description of what this test validates

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_display_name`

```python
with_display_name(display_name)
```

Set a custom display name.

**Parameters:**

- **display_name** (<code>[str](#str)</code>) – Human-readable name for UI display

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

###### `metadata.sdk.data_quality.tests.table_tests.TableRowInsertedCountToBeBetween.with_name`

```python
with_name(name)
```

Set a custom test case name.

**Parameters:**

- **name** (<code>[str](#str)</code>) – Unique identifier for this test case

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

### `metadata.sdk.data_quality.workflow_config_builder`

Builder for creating OpenMetadata workflow configurations for test suite execution.

**Classes:**

- [**WorkflowConfigBuilder**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder) – Builds OpenMetadataWorkflowConfig for test suite execution.

**Attributes:**

- [**T**](#metadata.sdk.data_quality.workflow_config_builder.T) –

#### `metadata.sdk.data_quality.workflow_config_builder.T`

```python
T = TypeVar('T', bound=BaseModel)
```

#### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder`

```python
WorkflowConfigBuilder(client)
```

Builds OpenMetadataWorkflowConfig for test suite execution.

This builder encapsulates the logic for creating a complete workflow configuration
required to execute data quality tests against a table. It constructs the source,
processor, sink, and workflow configurations based on the provided table entity,
service connection, and test definitions.

**Attributes:**

- [**table**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.table) (<code>[Optional](#typing.Optional)\[[Table](#metadata.generated.schema.entity.data.table.Table)\]</code>) – Table entity to run tests against
- [**service_connection**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.service_connection) (<code>[Optional](#typing.Optional)\[[DatabaseConnection](#metadata.generated.schema.entity.services.databaseService.DatabaseConnection)\]</code>) – Database service connection for the table
- [**ometa_config**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.ometa_config) (<code>[Optional](#typing.Optional)\[[DatabaseConnection](#metadata.generated.schema.entity.services.databaseService.DatabaseConnection)\]</code>) – OpenMetadata server configuration
- [**test_definitions**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.test_definitions) (<code>[List](#typing.List)\[[TestCaseDefinition](#metadata.data_quality.api.models.TestCaseDefinition)\]</code>) – List of test case definitions to execute

**Functions:**

- [**add_test_definition**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.add_test_definition) – Add test definition to workflow config
- [**add_test_definitions**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.add_test_definitions) – Add test definitions to the workflow configuration.
- [**build**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.build) – Build the complete OpenMetadata workflow configuration.
- [**with_enable_streamable_logs**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_enable_streamable_logs) –
- [**with_force_test_update**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_force_test_update) –
- [**with_log_level**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_log_level) –
- [**with_raise_on_error**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_raise_on_error) –
- [**with_success_threshold**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_success_threshold) –
- [**with_table**](#metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_table) –

**Parameters:**

- **client** (<code>[OpenMetadata](#metadata.ingestion.ometa.ometa_api.OpenMetadata)\[[Any](#typing.Any), [Any](#typing.Any)\]</code>) – OpenMetadata client

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.add_test_definition`

```python
add_test_definition(test_definition)
```

Add test definition to workflow config
Args:
test_definition: Test case definition to add

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.add_test_definitions`

```python
add_test_definitions(test_definitions)
```

Add test definitions to the workflow configuration.

**Parameters:**

- **test_definitions** (<code>[List](#typing.List)\[[TestCaseDefinition](#metadata.data_quality.api.models.TestCaseDefinition)\]</code>) – List of test case definitions to add

**Returns:**

- <code>[Self](#typing_extensions.Self)</code> – Self for method chaining

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.build`

```python
build()
```

Build the complete OpenMetadata workflow configuration.

This method constructs all components of the workflow configuration:

- Source: TestSuite source with table FQN and service connection
- Processor: Test case runner with test definitions
- Sink: Metadata REST sink for persisting results
- WorkflowConfig: Logger and server settings

**Returns:**

- <code>[OpenMetadataWorkflowConfig](#metadata.generated.schema.metadataIngestion.workflow.OpenMetadataWorkflowConfig)</code> – Complete OpenMetadataWorkflowConfig ready for execution

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.client`

```python
client: OMeta[Any, Any] = client
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.enable_streamable_logs`

```python
enable_streamable_logs: bool = False
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.force_test_update`

```python
force_test_update: bool = True
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.log_level`

```python
log_level: LogLevels = LogLevels.INFO
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.raise_on_error`

```python
raise_on_error: bool = False
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.service_connection`

```python
service_connection: Optional[DatabaseConnection] = None
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.success_threshold`

```python
success_threshold: int = 90
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.table`

```python
table: Optional[Table] = None
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.test_definitions`

```python
test_definitions: List[TestCaseDefinition] = []
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_enable_streamable_logs`

```python
with_enable_streamable_logs(enable)
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_force_test_update`

```python
with_force_test_update(force_test_update)
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_log_level`

```python
with_log_level(log_level)
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_raise_on_error`

```python
with_raise_on_error(raise_on_error)
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_success_threshold`

```python
with_success_threshold(success_threshold)
```

##### `metadata.sdk.data_quality.workflow_config_builder.WorkflowConfigBuilder.with_table`

```python
with_table(table_fqn)
```
