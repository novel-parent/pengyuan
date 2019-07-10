package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.OrderListDiv;
import com.pengyuan.backstage.bean.Orders;
import com.pengyuan.backstage.mapper.OrderMapper;
import com.pengyuan.backstage.service.OrderService;
import com.pengyuan.backstage.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/8 - 13:45
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderListDiv searchOrder(String corporateName, String goodsName, Long startTime, Long endTime, String key) {

        List<Orders> ordersList = orderMapper.selForSearch(corporateName,goodsName ,startTime, endTime, key);

        OrderListDiv orderListDiv = null ;
        if(ordersList !=null && ordersList.size() > 0){

            orderListDiv = new OrderListDiv();
            long sum = 0;

            int length  = ordersList.size();

            for ( int i = 0 ; i<length ; i++ ){

                Orders orders = ordersList.get(i);

                long money  = Long.parseLong(orders.getMoney());

                sum +=money;

                orders.setMoney(MoneyUtil.formatMoney(money));
            }

            orderListDiv.setList(ordersList);

            orderListDiv.setSum(MoneyUtil.formatMoney(sum));

            orderListDiv.setSize(length);
        }
        return orderListDiv;
    }
}
