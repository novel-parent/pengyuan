package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/8 - 13:29
 */
public interface OrderMapper {


    /**
     *        查询 所有订单
     * @return
     */
    @Select("SELECT * FROM orders")
    List<Orders> selAll();
}
