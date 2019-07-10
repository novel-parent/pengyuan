package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/8 - 13:29
 */
public interface OrderMapper {



    List<Orders> selForSearch(@Param("corporateName") String corporateName, @Param("startTime") Long startTime,@Param("endTime") Long endTime,@Param("key") String key);
}
