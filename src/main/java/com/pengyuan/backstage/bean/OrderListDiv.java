package com.pengyuan.backstage.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author LX
 * @date 2019/7/10 - 21:16
 */
public class OrderListDiv implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Orders> list;

    private String sum ;

    private int size;

    private long number;

    private String priceSum;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    private int pageNumber;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(String priceSum) {
        this.priceSum = priceSum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public List<Orders> getList() {
        return list;
    }

    public void setList(List<Orders> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "OrderListDiv{" +
                "list=" + list +
                ", sum='" + sum + '\'' +
                ", size=" + size +
                ", number=" + number +
                ", priceSum='" + priceSum + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
