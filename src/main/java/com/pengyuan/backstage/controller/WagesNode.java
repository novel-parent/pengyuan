package com.pengyuan.backstage.controller;

import org.springframework.stereotype.Controller;

/**
 * @author LX
 * @date 2019/7/24 - 23:46
 */
@Controller
public class WagesNode {

    private long wid;

    private long uid;

    private long pid;

    private String procedure;

    private String price;

    private int number;

    private String times;

    private String money;

    private int flag;

    @Override
    public String toString() {
        return "WagesNode{" +
                "wid=" + wid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", procedure='" + procedure + '\'' +
                ", price='" + price + '\'' +
                ", number=" + number +
                ", times='" + times + '\'' +
                ", money='" + money + '\'' +
                ", flag=" + flag +
                '}';
    }

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
