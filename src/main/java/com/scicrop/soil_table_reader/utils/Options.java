
package com.scicrop.soil_table_reader.utils;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Options {

    @SerializedName("discard_rows")
    @Expose
    private List<Integer> discardRows;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("top")
    @Expose
    private Integer top;
    @SerializedName("left")
    @Expose
    private Integer left;
    @SerializedName("bottom")
    @Expose
    private Integer bottom;
    @SerializedName("right")
    @Expose
    private Integer right;

    public List<Integer> getDiscardRows() {
        return discardRows;
    }

    public void setDiscardRows(List<Integer> discardRows) {
        this.discardRows = discardRows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

}
