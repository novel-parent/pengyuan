package com.pengyuan.backstage.bean;

import java.io.Serializable;

public class JsonModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String msg;
	private Object obj;
	private Object other;
	
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
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Object getOther() {
		return other;
	}
	public void setOther(Object other) {
		this.other = other;
	}
	
}
