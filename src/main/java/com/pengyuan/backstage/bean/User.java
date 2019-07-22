package com.pengyuan.backstage.bean;

import java.io.Serializable;

/**
 * @author LX
 * @date 2019/7/7 - 14:42
 */
public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private Long uid ;
    private String userName;
    private String password;
    private Long fid;
    private Factory factory;
    private String tel;
    private Integer flag;
    
    public User() {
    	
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

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
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

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public User(Long uid, String userName, String password, Long fid, Factory factory, String tel, Integer flag) {
        this.uid = uid;
        this.userName = userName;
        this.password = password;
        this.fid = fid;
        this.factory = factory;
        this.tel = tel;
        this.flag = flag;
    }
}
