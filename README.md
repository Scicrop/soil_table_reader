# soil_table_reader

Basic implementation of tabula-java to extract soil analysis table from PDFs. It allows the user to extract table data from PDFs in different formats, using templates and converting the result to JSON.

## How to create Templates
Templates are JSON files that describes the table content, that is inside a PDF. Here you can find an example: https://github.com/Scicrop/soil_table_reader/blob/main/dist/template.json

### Define table area
Tabula has the ability to detect tables, however you can define a region (a rectangle) where the table will appear. This is a good approach when in a single PDF page there are several tables and you want to extract only one. There are 4 parameters that you need to check in order to define the table area: Top, Left, Bottom, Right. In the image bellow you can understand how these parameter are placed:

![image17568](https://github.com/Scicrop/soil_table_reader/assets/692043/b54cd850-d37d-4040-bc01-bd9788007652)

## Implementation
### Return a JSON String
```java
String jsonOutputString = TableParser.getInstance().tableToJsonString("dist/template.json", "/tmp/laudo.pdf");
```
### Return an Object
```java
List<List<Column>> object = TableParser.getInstance().tableToObject("dist/template.json", "/tmp/laudo.pdf");
```

## Results
Here you can see an example of just one row extracted from PDF table:
```js
[
    {
        "column": "analysis_code",
        "description": "Código da Análise",
        "type": "String",
        "unit": "",
        "value": "Analysis-0001"
    },
    {
        "column": "sample",
        "description": "Amostra",
        "type": "String",
        "unit": "",
        "value": "Farm A 0-20"
    },
    {
        "column": "ph_1",
        "description": "pH H2O",
        "type": "Float",
        "unit": "",
        "value": 5.3
    },
    {
        "column": "ph_2",
        "description": "pH CaCl2",
        "type": "Float",
        "unit": "",
        "value": 4.7
    },
    {
        "column": "mo",
        "description": "M.O.",
        "type": "Integer",
        "unit": "g dm-3",
        "value": "28"
    },
    {
        "column": "p_mg",
        "description": "P",
        "type": "Float",
        "unit": "mg dm-3",
        "value": 0.71
    },
    {
        "column": "k_plus_mg",
        "description": "K+",
        "type": "Integer",
        "unit": "mg dm-3",
        "value": "64"
    },
    {
        "column": "so4_3_minus_mg",
        "description": "SO4 2-",
        "type": "Integer",
        "unit": "mg dm-3",
        "value": "6"
    },
    {
        "column": "k_plus_cmol",
        "description": "K+",
        "type": "Float",
        "unit": "cmol c dm-3",
        "value": 0.17
    },
    {
        "column": "ca2_plus_cmol",
        "description": "Ca2+",
        "type": "Float",
        "unit": "cmol c dm-3",
        "value": 1.21
    },
    {
        "column": "mg2_plus_cmol",
        "description": "Mg2+",
        "type": "Float",
        "unit": "cmol c dm-3",
        "value": 0.51
    },
    {
        "column": "ca_plus_mg_cmol",
        "description": "Ca+Mg",
        "type": "Float",
        "unit": "cmol c dm-3",
        "value": 1.73
    },
    {
        "column": "al3_plus_cmol",
        "description": "Al3+",
        "type": "Float",
        "unit": "cmol c dm-3",
        "value": 0.25
    },
    {
        "column": "h_plus_al_cmol",
        "description": "H+Al",
        "type": "Float",
        "unit": "cmol c dm-3",
        "value": 5.32
    }
]
```
