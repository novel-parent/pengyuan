package com.pengyuan.backstage.bean;

import java.io.Serializable;

import com.pengyuan.backstage.util.DateUtil;
import com.pengyuan.backstage.util.MoneyUtil;

/**
 *
 * @author LX
 * @date 2019/7/8 - 13:19
 */
public class Orders implements Serializable{

	private static final long serialVersionUID = 1L;

	private long oid;

    private String corporateName;

    private String goodsName;

    private String documents;

    private int number;

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String signatory;

    private String times;

    private String money;

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

    public String getTimes() {
        return times;
    }

    public void setTimes(String times ) {
        times = DateUtil.getDayForAdmin( times );
        this.times = times ;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney( String money ) {
        this.money = money;
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
                '}';
    }
}
