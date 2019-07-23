package com.pengyuan.backstage.bean;


import java.io.Serializable;

/**
 * @author LX
 * @date 2019/7/12 - 0:03
 */
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long oid;

    private String corporateName;

    private String goodsName;

    private String documents;

    private Integer number;

    private Long price;

    private String signatory;

    private Long times;

    private Long money;

    private String company;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

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
}
