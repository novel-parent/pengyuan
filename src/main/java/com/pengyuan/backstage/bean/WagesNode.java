package com.pengyuan.backstage.bean;

import com.pengyuan.backstage.util.DateUtil;
import com.pengyuan.backstage.util.MoneyUtil;

/**
 * @author LX
 * @date 2019/7/24 - 23:46
 */
public class WagesNode {

    private long wid;

    private long uid;

    private long pid;

    private String procedureNode;

    private String price;

    private int number;

    private String times;

    private String money;

    private int flag;

    private User user;

    private Procedures procedures;

    public Procedures getProcedures() {
        return procedures;
    }

    public void setProcedures(Procedures procedures) {
        this.procedures = procedures;
    }

    @Override
    public String toString() {
        return "WagesNode{" +
                "wid=" + wid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", procedureNode='" + procedureNode + '\'' +
                ", price='" + price + '\'' +
                ", number=" + number +
                ", times='" + times + '\'' +
                ", money='" + money + '\'' +
                ", flag=" + flag +
                ", user=" + user +
                ", procedures=" + procedures +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getProcedureNode() {
        return procedureNode;
    }

    public void setProcedureNode(String procedureNode) {
        this.procedureNode = procedureNode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = MoneyUtil.formatMoney(price);
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
        this.times = DateUtil.getDayForAdmin(times);
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
