package com.scicrop.soil_table_reader;

public class App {
    public static void main( String[] args ) throws Exception {
    	
    	String jsonOutputString = TableParser.getInstance().tableToJsonString("dist/template.json", "/tmp/laudo.pdf");
    	System.out.println(jsonOutputString);
    	
    }
}
