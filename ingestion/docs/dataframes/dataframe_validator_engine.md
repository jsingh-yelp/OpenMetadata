## `metadata.sdk.data_quality.dataframes.dataframe_validation_engine`

Orchestration engine for DataFrame validation execution.

**Classes:**

- [**DataFrameValidationEngine**](#metadata.sdk.data_quality.dataframes.dataframe_validation_engine.DataFrameValidationEngine) – Orchestrates execution of multiple validators on a DataFrame.

**Attributes:**

- [**logger**](#metadata.sdk.data_quality.dataframes.dataframe_validation_engine.logger) –

### `metadata.sdk.data_quality.dataframes.dataframe_validation_engine.DataFrameValidationEngine`

```python
DataFrameValidationEngine(test_cases)
```

Orchestrates execution of multiple validators on a DataFrame.

**Functions:**

- [**execute**](#metadata.sdk.data_quality.dataframes.dataframe_validation_engine.DataFrameValidationEngine.execute) – Execute all validations and return aggregated results.

**Attributes:**

- [**test_cases**](#metadata.sdk.data_quality.dataframes.dataframe_validation_engine.DataFrameValidationEngine.test_cases) (<code>[List](#typing.List)\[[TestCase](#metadata.generated.schema.tests.testCase.TestCase)\]</code>) –

#### `metadata.sdk.data_quality.dataframes.dataframe_validation_engine.DataFrameValidationEngine.execute`

```python
execute(df, mode=FailureMode.SHORT_CIRCUIT)
```

Execute all validations and return aggregated results.

**Parameters:**

- **df** (<code>[DataFrame](#pandas.DataFrame)</code>) – DataFrame to validate
- **mode** (<code>[FailureMode](#metadata.sdk.data_quality.dataframes.validation_results.FailureMode)</code>) – Validation mode (only "short-circuit" supported)

**Returns:**

- <code>[ValidationResult](#metadata.sdk.data_quality.dataframes.validation_results.ValidationResult)</code> – ValidationResult with outcomes for all tests

#### `metadata.sdk.data_quality.dataframes.dataframe_validation_engine.DataFrameValidationEngine.test_cases`

```python
test_cases: List[TestCase] = test_cases
```

### `metadata.sdk.data_quality.dataframes.dataframe_validation_engine.logger`

```python
logger = logging.getLogger(__name__)
```
