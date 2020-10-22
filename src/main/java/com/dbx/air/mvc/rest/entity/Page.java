package com.dbx.air.mvc.rest.entity;

public class Page {
    public Integer previousPageIndex;
    public Integer pageIndex;
    public Integer pageSize;
    public Integer length;

    public Page(Integer previousPageIndex, Integer pageIndex, Integer pageSize, Integer length) {
        this.previousPageIndex = previousPageIndex;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.length = length;
    }

    public Integer getPreviousPageIndex() {
        return previousPageIndex;
    }

    public void setPreviousPageIndex(Integer previousPageIndex) {
        this.previousPageIndex = previousPageIndex;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
