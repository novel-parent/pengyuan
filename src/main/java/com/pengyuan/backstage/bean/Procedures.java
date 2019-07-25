package com.pengyuan.backstage.bean;

public class Procedures {

	private long pid;
	private String pName;
	private String main;
	private String remarks;
	private String path;
	private Long times;
	private Integer flag;
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
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
	public Long getTimes() {
		return times;
	}
	public void setTimes(Long times) {
		this.times = times;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "Procedures [pid=" + pid + ", name=" + pName + ", main=" + main + ", remarks=" + remarks + ", path="
				+ path + ", times=" + times + ", flag=" + flag + "]";
	}




}
