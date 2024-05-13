package com.scicrop.soil_table_reader.utils;

import java.util.List;

public class OutputRow {

	private List<Column> columnList;

	public OutputRow(List<Column> columnList) {
		this.columnList = columnList;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}
	
}
