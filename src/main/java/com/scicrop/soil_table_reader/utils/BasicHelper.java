package com.scicrop.soil_table_reader.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BasicHelper {

	private static BasicHelper INSTANCE = null;
	private BasicHelper(){}
	public static BasicHelper getInstance(){
		if(null == INSTANCE) INSTANCE = new BasicHelper();
		return INSTANCE;
	}
	
	public String readTextFileToString(File source) throws Exception {
		StringBuffer output = null;

		if(source != null && source.exists() && source.isFile()) {
			Path path = source.toPath();
			try {
				List<String> lst = Files.readAllLines(path);
				output = new StringBuffer();
				for (int i = 0; i < lst.size(); i++) {
					output.append(lst.get(i)+"\n");
				}
			} catch (IOException e) {
				throw new Exception("invalid file");
			}
		}else throw new Exception("invalid file");



		return output.toString();
	}

	public String convertToPointSeparator(String value) {
        String valueWithoutThousandSeparator = value.replaceAll("\\.", "");
        String valueWithDecimalPoint = valueWithoutThousandSeparator.replace(',', '.');
        return valueWithDecimalPoint;
    }

	
}
