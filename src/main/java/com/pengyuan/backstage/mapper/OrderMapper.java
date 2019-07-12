package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/8 - 13:29
 */
public interface OrderMapper {

    /**
     *       更新  flag
     * @param oid
     * @return
     */
    @Update("UPDATE orders SET flag=0 WHERE oid=#{oid} ")
    int updOrderByOid(@Param("oid") long oid);


    /**
     *           根据条件搜索   订单
     * @param corporateName
     * @param goodsName
     * @param startTime
     * @param endTime
     * @param key
     * @return
     */
    List<Orders> selForSearch(@Param("corporateName") String corporateName, @Param("goodsName") String goodsName,@Param("startTime") Long startTime,@Param("endTime") Long endTime,@Param("key") String key);
}
