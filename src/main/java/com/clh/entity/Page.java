package com.clh.entity;

/**
 * @auth chenlh
 * @data 2020/6/24 15:52
 * @Description
 */
public class Page {
    private Integer pageCount;
    private Integer count;
    private Integer size = 5;
    private Integer pageCurrent;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }
}
