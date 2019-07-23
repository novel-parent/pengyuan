package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author LX
 * @date 2019/7/23 - 9:12
 */
public interface LoginMapper {

    /**
     *        根据用户账号和密码查询
     *
     * @param username
     * @param password
     * @return
     */
    User selByUsernamePwd(@Param("username") String username,@Param("password") String password);
}
