package com.pengyuan.backstage.controller;

import com.pengyuan.backstage.bean.Order;
import com.pengyuan.backstage.bean.OrderListDiv;
import com.pengyuan.backstage.bean.Orders;
import com.pengyuan.backstage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.util.List;

/**
 * @author LX
 * @date 2019/7/8 - 13:27
 */
@Controller
public class OrderController {


    @Autowired
    private OrderService service;

    @ResponseBody
    @RequestMapping("/updOrder.b")
    public String updOrder(Order order){

        return null;
    }

    @ResponseBody
    @RequestMapping("/newOrder.b")
    public String newOrder(Order order){

        String msg = "-1";

        try {
            msg = service.insOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }

    @ResponseBody
    @RequestMapping("/order.b")
    public OrderListDiv search(@RequestParam(required = false) String corporateName ,
                               @RequestParam(required = false) String goodsName,
                               @RequestParam(required = false) Long startTime ,
                               @RequestParam(required = false) Long endTime,
                               @RequestParam(required = false)  String key,
                               @RequestParam(required = false) int pageSize,
                               @RequestParam(required = false) int page){

        OrderListDiv orderListDiv = null ;

        System.out.println("1:"+corporateName+"===="+goodsName);
        try {

            orderListDiv = service.searchOrder(corporateName, goodsName, startTime, endTime, key, pageSize, page);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return orderListDiv;
    }

    @ResponseBody
    @RequestMapping("/delOrder.b")
    public String delOrder( Long oid){

        String msg = "-1";

        try {
            msg = service.delOrder(oid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

}
