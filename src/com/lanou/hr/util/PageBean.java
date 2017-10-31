package com.lanou.hr.util;

import java.util.List;

/**
 * Created by dllo on 17/10/28.
 */
public class PageBean<T> {

    private int pageNum; // 第几页
    private int pageSize; // 每页显示的条数
    private int totalRecord; // 总的记录数

    private int startIndex; // 开始
    private int totalPage; // 总分页数

    private List<T> data; // 数据的集合

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", startIndex=" + startIndex +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }

    public PageBean(int pageNum, int pageSize, int totalRecord, int startIndex, int totalPage, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.startIndex = startIndex;
        this.totalPage = totalPage;
        this.data = data;
    }

    public PageBean(int pageNum, int pageSize, int totalRecord, int startIndex, int totalPage) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.startIndex = startIndex;
        this.totalPage = totalPage;
    }

    public PageBean(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
    }

    public PageBean() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getStartIndex() {
        return (pageNum-1)*pageSize;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
       if (totalRecord%pageSize != 0){
          return totalRecord/pageSize +1 ;
       }else {
          return totalRecord/pageSize;
       }
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
