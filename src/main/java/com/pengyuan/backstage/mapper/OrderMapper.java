package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.HotKey;
import com.pengyuan.backstage.bean.Order;
import com.pengyuan.backstage.bean.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/8 - 13:29
 */
public interface OrderMapper {

    /**
     *       更新数据库  订单信息
     * @param order
     * @return
     */
    int updOrder(Order order);

    /**
     *      根据oid  查询 订单的     公司名称 和  商品名称
     * @param oid
     * @return
     */
    @Select("SELECT corporateName , goodsName FROM orders WHERE oid = #{oid}")
    HotKey selOrdersByOid(@Param("oid") long oid);

    /**
     *        插入new 的订单信息
     * @param order
     * @return
     */
    @Insert("INSERT INTO orders (corporateName,goodsName," +
            "documents,number,company,price,money,times,signatory) " +
            "VALUE(#{corporateName},#{goodsName},#{documents},#{number},#{company},#{price},#{money},#{times},#{signatory}) ")
    int insOrder(Order order);
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
     * @param index
     * @param  pageSize
     * @return
     */
    List<Orders> selForSearch(@Param("corporateName") String corporateName, @Param("goodsName") String goodsName, @Param("startTime") Long startTime, @Param("endTime") Long endTime, @Param("key") String key, @Param("index") int index, @Param("pageSize") int pageSize);

    /**
     *      查询 符合条件的所有数据 的数目
     * @param corporateName
     * @param goodsName
     * @param startTime
     * @param endTime
     * @param key
     * @return
     */
    int selAllForGetSize(@Param("corporateName") String corporateName, @Param("goodsName") String goodsName,@Param("startTime") Long startTime,@Param("endTime") Long endTime,@Param("key") String key);
}
