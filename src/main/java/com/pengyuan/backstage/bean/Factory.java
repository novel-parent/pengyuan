package com.pengyuan.backstage.bean;

/**
 * @author LX
 * @date 2019/7/7 - 15:17
 */
public class Factory {

    private long fid;

    private String factoryName;

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
        return "Factory{" +
                "fid=" + fid +
                ", factoryName='" + factoryName + '\'' +
                '}';
    }
}
