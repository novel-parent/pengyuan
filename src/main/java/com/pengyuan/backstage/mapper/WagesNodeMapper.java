package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.WagesNode;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/25 - 11:35
 */
public interface WagesNodeMapper {

    /**
     *     查询 页数
     * @param startTime
     * @param endTime
     * @param pid
     * @param uid
     * @return
     */
    int selWagesNodeNumber( @Param("startTime") Long startTime, @Param("endTime") Long endTime,
                           @Param("pid") Long pid,@Param("uid") Long uid);

    /**
     *       查询  员工 工资节点
     * @param index
     * @param pageSize
     * @param startTime
     * @param endTime
     * @param pid
     * @param uid
     * @return
     */
    List<WagesNode> selWagesNode(@Param("index") int index, @Param("pageSize") int pageSize,
                                 @Param("startTime") Long startTime, @Param("endTime") Long endTime,
                                 @Param("pid") Long pid,@Param("uid") Long uid);




    @Select("select * from wages_node where pid=#{pid} and price=#{price} and procedureNode = #{procedureNode} and times=#{times} and uid=#{uid}")
	List<WagesNode> selectWageNode(@Param("uid")long uid,@Param("pid") long pid,@Param("procedureNode") String procedureNode,@Param("price") Long price,@Param("times") long times);
    /**
     * 	把工序插入weges_node表
     * @param uid
     * @param pid
     * @param procedureNode
     * @param price
     * @param number
     * @param times
     * @param money
     * @return
     */
    @Insert("insert into wages_node(pid,number,money,price,procedureNode,times,uid) values(#{pid},#{number},#{money},#{price},#{procedureNode},#{times},#{uid})")
	int putIntoWage(@Param("uid")long uid,@Param("pid") long pid,@Param("procedureNode") String procedureNode,@Param("price") Long price,@Param("number") int number,@Param("times") long times,@Param("money") long money);
    /**
     * 	更新weges_node表中的信息
     * @param wid
     * @param uid
     * @param number
     * @param money
     * @return
     */
    @Update("update wages_node set uid = #{uid} , number = #{number} , money=#{money} where wid = #{wid}")
	int updateWagesNode(@Param("wid")Long wid,@Param("uid") Long uid, @Param("number")Integer number,@Param("money") String money);
    
    /**
     * 	根据wid删除wages_node表中的记录
     * @param wid
     * @return
     */
    @Delete("delete from wages_node where wid = #{wid}")
	int deleteWagesNodeByWid(@Param("wid")Long wid);

}
