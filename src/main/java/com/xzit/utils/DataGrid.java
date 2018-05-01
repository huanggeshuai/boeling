package com.xzit.utils;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1 0001.
 */
public class DataGrid<T> {
    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
