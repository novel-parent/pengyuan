package com.pengyuan.backstage.service;

import com.pengyuan.backstage.bean.Order;
import com.pengyuan.backstage.bean.OrderListDiv;


/**
 *
 * @author LX
 * @date 2019/7/8 - 13:31
 */
public interface OrderService {

    /**
     *        用户修改  订单信息
     * @param order
     * @return
     */
    String updOrder(Order order);

    /**
     *        插入  一个 新的 订单
     * @param order
     * @return
     */
    String insOrder(Order order);

    /**
     *       管理员删除 订单
     * @param oid
     * @return
     */
    String delOrder(long oid);

    /**
     *        订单搜索
     * @param corporateName
     * @param goodsName
     * @param startTime
     * @param endTime
     * @param key
     * @param pageSize
     * @return
     */
    OrderListDiv searchOrder(String corporateName, String goodsName, Long startTime, Long endTime, String key,int pageSize,int page);
}
