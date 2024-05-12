
package com.scicrop.soil_table_reader.utils;

import java.util.List;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Template {

    @SerializedName("columns")
    @Expose
    private List<Column> columns;
    @SerializedName("options")
    @Expose
    private Options options;

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

}
