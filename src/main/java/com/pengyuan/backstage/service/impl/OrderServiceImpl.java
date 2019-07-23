package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.HotKey;
import com.pengyuan.backstage.bean.Order;
import com.pengyuan.backstage.bean.OrderListDiv;
import com.pengyuan.backstage.bean.Orders;
import com.pengyuan.backstage.mapper.OrderMapper;
import com.pengyuan.backstage.service.OrderService;
import com.pengyuan.backstage.util.DateUtil;
import com.pengyuan.backstage.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void updHotKey(String corporateName ,String goodsName ){

        if (corporateName!=null){
            stringRedisTemplate.opsForValue().set("goodsName:"+goodsName,"1" );
        }

        if (goodsName!=null){
            stringRedisTemplate.opsForValue().set("corporateName:"+corporateName,"1" );
        }
    }

    public void delHotKey(String corporateName ,String goodsName ){

        if (corporateName!=null){
            stringRedisTemplate.delete("goodsName:"+goodsName);
        }

        if (goodsName!=null){
            stringRedisTemplate.delete("corporateName:"+corporateName);
        }
    }

    @Override
    public String updOrder(Order order) {

        String msg = "-1";

        HotKey hotKey = orderMapper.selOrdersByOid(order.getOid());

        int i = orderMapper.updOrder(order);

        if( i > 0 ){

            msg = "1";

            delHotKey(hotKey.getCorporateName(), hotKey.getGoodsName());

            updHotKey(order.getCorporateName(), order.getGoodsName());
        }
        return msg;
    }

    @Override
    public String insOrder(Order order) {

        String msg = "1";

        order.setTimes(DateUtil.getTimes());

        int insOrder = orderMapper.insOrder(order);

        if(insOrder <= 0){
            msg="-1";
            return msg;
        }

        updHotKey(order.getCorporateName(), order.getGoodsName());

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
