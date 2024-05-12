package com.scicrop.soil_table_reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scicrop.soil_table_reader.utils.BasicHelper;
import com.scicrop.soil_table_reader.utils.Column;
import com.scicrop.soil_table_reader.utils.Template;

import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.PageIterator;
import technology.tabula.Rectangle;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

public class TableParser {
	
	private static TableParser INSTANCE = null;
	private TableParser(){}
	public static TableParser getInstance(){
		if(null == INSTANCE) INSTANCE = new TableParser();
		return INSTANCE;
	}


	public List<List<Column>> tableToObject(String templatePath, String pdfPath) throws Exception {
		List<List<Column>> output_rows = new ArrayList<>();

		String templateJsonStr = BasicHelper.getInstance().readTextFileToString(new File(templatePath));

		Gson gson = new Gson();

		Template tableTemplate = gson.fromJson(templateJsonStr, Template.class);

		File initialFile = new File(pdfPath);

		InputStream in = new FileInputStream(initialFile);
		try (PDDocument document = PDDocument.load(in)) {
			SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();
			PageIterator pi = new ObjectExtractor(document).extract();
			while (pi.hasNext()) {

				Page page = pi.next();

				Rectangle area = new Rectangle(tableTemplate.getOptions().getTop(), 
						tableTemplate.getOptions().getLeft(), 
						tableTemplate.getOptions().getRight() - tableTemplate.getOptions().getLeft(), 
						tableTemplate.getOptions().getBottom() - tableTemplate.getOptions().getTop());

				page = page.getArea(area);

				List<Column> templateColumns = tableTemplate.getColumns();
				List<Table> table = (List<Table>) sea.extract(page);

				for(Table tables: table) {
					List<List<RectangularTextContainer>> rows = tables.getRows();
					int countRow = 0;
					List<Column> output_columns = new ArrayList<Column>();
					for (List<RectangularTextContainer> cells : rows) {
						if(!tableTemplate.getOptions().getDiscardRows().contains(countRow)) {

							int countCell = 0;

							for (RectangularTextContainer content : cells) {
								String text = content.getText().replace("\r", " ");
								Column column = templateColumns.get(countCell);
								column.transformValue(text, column.getType());			
								output_columns.add(column);
								countCell++;
							}
						}else {
							System.out.println("Discarding row: "+countRow);
						}


						output_rows.add(output_columns);
						countRow++;

					}
					gson = new GsonBuilder().setPrettyPrinting().create();
					String jsonOutputRows = gson.toJson(output_rows);
					System.out.println(jsonOutputRows);
				}
			}
		}

		return output_rows;
	}


	public String tableToJsonString(String templatePath, String pdfPath) throws Exception {
		List<List<Column>> output_rows = tableToObject(templatePath, pdfPath);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(output_rows);
	}

}
