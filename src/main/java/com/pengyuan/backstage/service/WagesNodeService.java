package com.pengyuan.backstage.service;

import com.pengyuan.backstage.bean.UserInfoWagesNodes;

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
    UserInfoWagesNodes getWagesNode( int page,  int pageSize,  Long startTime, Long endTime, Long pid, String username);
}
