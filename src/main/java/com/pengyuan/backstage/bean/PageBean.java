package com.pengyuan.backstage.bean;

import java.io.Serializable;

public class PageBean implements Serializable{
	//所有页数
	private int totalPage;
	//每页数据条数
	private int pageSize;
	//当前为第几页
	private int currentPage;
	//对象列表
	private Object objList;
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public Object getObjList() {
		return objList;
	}
	public void setObjList(Object objList) {
		this.objList = objList;
	}
	
	
}
