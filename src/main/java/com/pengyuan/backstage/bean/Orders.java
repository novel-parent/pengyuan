package com.pengyuan.backstage.bean;

import com.pengyuan.backstage.util.DateUtil;
import com.pengyuan.backstage.util.MoneyUtil;

/**
 *
 * @author LX
 * @date 2019/7/8 - 13:19
 */
public class Orders {

    private long oid;

    private String corporateName;

    private String goodsName;

    private String documents;

    private int number;

    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(int price) {
        String s = MoneyUtil.formatMoney( price );
        this.price = s;
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
        times = DateUtil.getMonthAndDayForAdmin( times );
        this.times = times ;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney( long money ) {
        String s = MoneyUtil.formatMoney( money );
        this.money = s;
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
