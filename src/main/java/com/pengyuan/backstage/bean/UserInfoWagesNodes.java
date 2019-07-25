package com.pengyuan.backstage.bean;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/25 - 11:45
 */
public class UserInfoWagesNodes {

    private List<WagesNode> wagesNodes;

    private String money;

    private int size;

    private int pageNumber;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<WagesNode> getWagesNodes() {
        return wagesNodes;
    }

    public void setWagesNodes(List<WagesNode> wagesNodes) {
        this.wagesNodes = wagesNodes;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
