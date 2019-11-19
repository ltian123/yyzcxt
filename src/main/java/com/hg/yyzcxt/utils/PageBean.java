package com.hg.yyzcxt.utils;

public class PageBean {

    private int page; // 页码
    private int pageSize; // 单页数据量
    private int start;
    private int end;


    public PageBean(int page, int pageSize) {
        super();
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (page - 1) * pageSize +1 ;
    }

	public int getEnd() {
		return page * pageSize;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setStart(int start) {
		this.start = start;
	}

    
}
