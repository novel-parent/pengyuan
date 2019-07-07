package com.pengyuan.backstage.service;

import com.pengyuan.backstage.bean.User;

/**
 * @author LX
 * @date 2019/7/7 - 15:50
 */
public interface UserService {

    /**
     *    用户进行 登录功能
     * @param userName
     * @param password
     * @return
     */
    User login(String userName,String password);
}
