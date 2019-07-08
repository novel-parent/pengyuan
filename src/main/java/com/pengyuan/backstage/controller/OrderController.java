package com.pengyuan.backstage.controller;

import com.pengyuan.backstage.bean.Orders;
import com.pengyuan.backstage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("/order")
    public List<Orders> search(){
        return service.showOrder();
    }

}
