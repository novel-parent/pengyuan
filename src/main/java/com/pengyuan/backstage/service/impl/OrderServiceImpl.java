package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.Order;
import com.pengyuan.backstage.bean.OrderListDiv;
import com.pengyuan.backstage.bean.Orders;
import com.pengyuan.backstage.mapper.OrderMapper;
import com.pengyuan.backstage.service.OrderService;
import com.pengyuan.backstage.util.DateUtil;
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
    public String updOrder(Order order) {

        return null;
    }

    @Override
    public String insOrder(Order order) {

        String msg = "1";

        order.setTimes(DateUtil.getTimes());

        int insOrder = orderMapper.insOrder(order);

        if(insOrder <= 0){
            msg="-1";
        }
        return msg;
    }

    @Override
    public String delOrder(long oid) {

        String msg = "1";
        int i = orderMapper.updOrderByOid(oid);

        if(i<=0){
            msg = "-1";
        }

        return msg;
    }

    @Override
    public OrderListDiv searchOrder(String corporateName, String goodsName, Long startTime, Long endTime, String key,int pageSize,int page) {

        int index = (page-1)*pageSize;

        List<Orders> ordersList = orderMapper.selForSearch(corporateName,goodsName ,startTime, endTime, key,index,pageSize);

        int size = orderMapper.selAllForGetSize(corporateName, goodsName, startTime, endTime, key);

        System.out.println(size);

        OrderListDiv orderListDiv = null ;
        if(ordersList !=null && ordersList.size() > 0){

            orderListDiv = new OrderListDiv();
            long sum = 0;

            long priceSum = 0;

            int number =0;

            int length  = ordersList.size();

            for ( int i = 0 ; i<length ; i++ ){

                Orders orders = ordersList.get(i);

                long money  = Long.parseLong(orders.getMoney());

                sum +=money;

                orders.setMoney(MoneyUtil.formatMoney(money));

                long price = Long.parseLong(orders.getPrice());

                priceSum += price;

                orders.setPrice(MoneyUtil.formatMoney(price));

                number += orders.getNumber();
            }

            orderListDiv.setList(ordersList);

            orderListDiv.setSum(MoneyUtil.formatMoney(sum));

            orderListDiv.setSize(length);

            orderListDiv.setPriceSum(MoneyUtil.formatMoney(priceSum));

            orderListDiv.setNumber(number);

            orderListDiv.setPageNumber(size%pageSize==0?(size/pageSize):(size/pageSize +1));
        }
        return orderListDiv;
    }
}
