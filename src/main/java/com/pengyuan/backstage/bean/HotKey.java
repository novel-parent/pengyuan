package com.pengyuan.backstage.bean;

/**
 * @author LX
 * @date 2019/7/20 - 11:23
 */
public class HotKey {

    private String corporateName;
    private String goodsName;

    @Override
    public String toString() {
        return "HotKey{" +
                "corporateName='" + corporateName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
