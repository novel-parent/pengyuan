package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.Orders;
import com.pengyuan.backstage.mapper.OrderMapper;
import com.pengyuan.backstage.service.OrderService;
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
    public List<Orders> showOrder() {


        return orderMapper.selAll();
    }
}
