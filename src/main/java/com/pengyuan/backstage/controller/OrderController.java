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
    @RequestMapping("/updOrder")
    public String updOrder(Order order){

        return null;
    }

    @ResponseBody
    @RequestMapping("/newOrder")
    public String newOrder(Order order){
        System.out.println(order);
        return service.insOrder(order);
    }

    @ResponseBody
    @RequestMapping("/order")
    public OrderListDiv search(@RequestParam(required = false) String corporateName ,
                               @RequestParam(required = false) String goodsName,
                               @RequestParam(required = false) Long startTime ,
                               @RequestParam(required = false) Long endTime,
                               @RequestParam(required = false)  String key,
                               @RequestParam(required = false) int pageSize,
                               @RequestParam(required = false) int page){
        System.out.println(corporateName+"  "+goodsName);
        return service.searchOrder(corporateName,goodsName, startTime, endTime, key,pageSize,page);
    }

    @ResponseBody
    @RequestMapping("/delOrder")
    public String delOrder( Long oid){

        return service.delOrder(oid);
    }

}
