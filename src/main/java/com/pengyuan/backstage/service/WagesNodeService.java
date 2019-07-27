package com.pengyuan.backstage.service;

import java.util.List;

import com.pengyuan.backstage.bean.UserInfoWagesNodes;
import com.pengyuan.backstage.bean.WagesNode;

/**
 * @author LX
 * @date 2019/7/25 - 0:11
 */
public interface WagesNodeService {

    /**
     *      查询  员工 工资 节点
     * @param page
     * @param pageSize
     * @param startTime
     * @param endTime
     * @param pid
     * @param username
     * @return
     */
    UserInfoWagesNodes getWagesNode( int page,  int pageSize,  Long startTime, Long endTime,  String procedureNode, String username);
    
    /**
         *  把WageNode对象里的数据插入数据库，并返回WageNode在数据库里的wid  
     * @param wn
     * @param price 
     * @return
     */
	WagesNode putIntoWage(WagesNode wn, Long price);

	int updateWagesNode(Long wid, Long uid, Integer number,Long price);

	int deleteFromWagesNode(Long wid);

    UserInfoWagesNodes getWagesNode( int page,  int pageSize,  Long startTime, Long endTime, Long pid, String username);
}
