# Path Value Resolver

## Overview
This project provides a `Resolver` component for extracting values from JSON strings based on a specified path. The `Resolver` supports both simple and complex JSON structures, utilizing the `ValueExtractor` class to handle path resolution logic.

## Features
- Extract values from JSON based on a specified path.
- Supports both simple and complex JSON structures.
- Gracefully handles errors during JSON processing.

## Components
### Resolver
- **Class**: `com.bloomteq.pathvalueresolution.resolver.Resolver`
- **Description**: The main component for resolving values from a JSON string. It provides methods to extract values from both simple and complex JSON structures.

#### Methods:
- `getSimpleJsonValue(String json, String path)`: Extracts value from the simple JSON string using the specified path.
- `getComplexJsonValue(String json, String path)`: Extracts value from the complex JSON string using the specified path.

### ValueExtractor
- **Class**: `com.bloomteq.pathvalueresolution.util.ValueExtractor`
- **Description**: Contains methods for extracting values from a JSON tree based on a specified path. Handles both simple and complex extraction logic.

#### Methods:
- `extractSimpleJsonValue(JsonNode nodes, String path)`: Extracts value (text) from the JSON tree.
- `extractComplexJsonValue(JsonNode nodes, String path)`: Extracts value (could involve array traversal) from the JSON tree.

### PathResolverApplication
- **Class**: `com.bloomteq.pathvalueresolution.PathResolverApplication`
- **Description**: The entry point of the application that demonstrates how to use the `Resolver` to extract values from JSON.

## Example 1: Simple JSON Path Resolution

### Input JSON:
```json
{
  "property1": "value1",
  "property2": "value2"
}
```
### Path:
```angular2html
property1
```
### Result
```angular2html
value1
```
## Example 2: Complex JSON Path Resolution
```json
{
  "property1": [
    {
      "property2": "value1"
    },
    {
      "property2": "value2"
    }
  ]
}
```
### Path:
```angular2html
property1.property2
```

### Result
```angular2html
value1
``` 