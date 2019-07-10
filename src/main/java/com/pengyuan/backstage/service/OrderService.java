package com.pengyuan.backstage.service;

import com.pengyuan.backstage.bean.Orders;

import java.util.List;


/**
 *
 * @author LX
 * @date 2019/7/8 - 13:31
 */
public interface OrderService {

    /**
     *          订单搜索
     * @param corporateName
     * @param time
     * @param key
     * @return
     */
    List<Orders> searchOrder(String corporateName,Long startTime,Long endTime,String key);
}
