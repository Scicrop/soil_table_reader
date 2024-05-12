
package com.scicrop.soil_table_reader.utils;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Column {

    @SerializedName("column")
    @Expose
    private String column;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("unit")
    @Expose
    private String unit;
    
    private Object value;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void transformValue(String text, String type) {

		switch (type) {
		case "String":
			setValue(text);
			break;
		case "Float":
			text = BasicHelper.getInstance().convertToPointSeparator(text);
			setValue(Double.parseDouble(text));
			break;
		case "Integer":
			setValue(Integer.parseInt(text));
		default:
			setValue(text);
			break;
		}
		
		
	}


}
