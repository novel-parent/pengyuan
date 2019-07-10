package com.pengyuan.backstage.bean;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/**
 * @author LX
 * @date 2019/7/7 - 14:42
 */
public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private long uid ;
    private String userName;
    private String password;
    private long fid;
    private Factory factory;
    private String tel;
    private int flag;
    
    public User() {
    	
    }

    public User(long uid, String userName, String password, long fid, Factory factory, String tel, int flag) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.password = password;
		this.fid = fid;
		this.factory = factory;
		this.tel = tel;
		this.flag = flag;
	}


	public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fid=" + fid +
                ", factory=" + factory +
                ", tel='" + tel + '\'' +
                ", flag=" + flag +
                '}';
    }
}
