package com.pengyuan.backstage.bean;

public class Procedures {

	private long pid;
	private String name;
	private String main;
	private String remarks;
	private String path;
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Procedures [pid=" + pid + ", name=" + name + ", main=" + main + ", remarks=" + remarks + ", path="
				+ path + "]";
	}
	
	
}
