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
     *        显示 所有的  订单信息
     * @return
     */
    List<Orders> showOrder();
}
