package me.cathub.change.common.base;

import java.util.List;

/**
 * View 分页对象
 */
public class PageResult {
    private List rows;
    private int total;

    public PageResult() {}

    public PageResult(List rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
