package com.pengyuan.backstage.service;

import com.pengyuan.backstage.bean.User;

/**
 * @author LX
 * @date 2019/7/23 - 9:00
 */
public interface LoginService {

    User login(String username,String password);
}
