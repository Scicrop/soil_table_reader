# soil_table_reader

Basic implementation of tabula-java to extract soil analysis table from PDFs. It allows the user to extract table data from PDFs in different formats, using templates and converting the result to JSON.

## How to create Templates
Templates are JSON files that describes the table content, that is inside a PDF.

### Define table area
Tabula has the ability to detect tables, however you can define a region (a rectangle) where the table will appear. This is a good approach when in a single PDF page there are several tables and you want to extract only one. There are 4 parameters that you need to check in order to define the table area: Top, Left, Bottom, Right. In the image bellow you can understand how these parameter are placed:

![image17568](https://github.com/Scicrop/soil_table_reader/assets/692043/b54cd850-d37d-4040-bc01-bd9788007652)
