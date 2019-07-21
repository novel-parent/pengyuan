package com.pengyuan.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable{
	//所有页数
	private int totalPage;
	//每页数据条数
	private int pageSize;
	//当前为第几页
	private int currentPage;
	
	private int code;
	
	private String msg;
	//对象列表
	private List<User> obj;
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
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<User> getObj() {
		return obj;
	}
	public void setObj(List<User> obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "PageBean [totalPage=" + totalPage + ", pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", code=" + code + ", msg=" + msg + ", obj=" + obj + "]";
	}
	
}
