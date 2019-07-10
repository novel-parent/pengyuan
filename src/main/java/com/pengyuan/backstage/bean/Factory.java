package com.pengyuan.backstage.bean;

import java.io.Serializable;

/**
 * @author LX
 * @date 2019/7/7 - 15:17
 */
public class Factory implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private long fid;

	private String factoryName;

	public Factory() {
    	
    }
	

	public Factory(long fid, String factoryName) {
		super();
		this.fid = fid;
		this.factoryName = factoryName;
	}


	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	@Override
	public String toString() {
		return "Factory{" + "fid=" + fid + ", factoryName='" + factoryName + '\'' + '}';
	}
}
