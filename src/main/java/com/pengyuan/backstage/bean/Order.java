package com.pengyuan.backstage.bean;


import java.io.Serializable;

/**
 * @author LX
 * @date 2019/7/12 - 0:03
 */
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;

    private long oid;

    private String corporateName;

    private String goodsName;

    private String documents;

    private int number;

    private long price;

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", corporateName='" + corporateName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", documents='" + documents + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", signatory='" + signatory + '\'' +
                ", times=" + times +
                ", money=" + money +
                ", company='" + company + '\'' +
                '}';
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    private String signatory;

    private long times;

    private long money;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    private String company;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
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

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {

        this.number = number;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

}
