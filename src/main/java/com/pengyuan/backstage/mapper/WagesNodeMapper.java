package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.WagesNode;
import org.apache.ibatis.annotations.Param;

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
     * @param procedureNode
     * @param uid
     * @return
     */
    int selWagesNodeNumber( @Param("startTime") Long startTime, @Param("endTime") Long endTime,
                           @Param("procedureNode") String procedureNode,@Param("uid") Long uid);

    /**
     *       查询  员工 工资节点
     * @param index
     * @param pageSize
     * @param startTime
     * @param endTime
     * @param procedureNode
     * @param uid
     * @return
     */
    List<WagesNode> selWagesNode(@Param("index") int index, @Param("pageSize") int pageSize,
                                 @Param("startTime") Long startTime, @Param("endTime") Long endTime,
                                 @Param("procedureNode") String procedureNode,@Param("uid") Long uid);
}
