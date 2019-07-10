package com.pengyuan.backstage.service;

import com.pengyuan.backstage.bean.OrderListDiv;
import com.pengyuan.backstage.bean.Orders;

import java.util.List;


/**
 *
 * @author LX
 * @date 2019/7/8 - 13:31
 */
public interface OrderService {

    /**
     *        订单搜索
     * @param corporateName
     * @param goodsName
     * @param startTime
     * @param endTime
     * @param key
     * @return
     */
    OrderListDiv searchOrder(String corporateName, String goodsName, Long startTime, Long endTime, String key);
}
