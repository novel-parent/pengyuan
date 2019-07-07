package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.mapper.UserMapper;
import com.pengyuan.backstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LX
 * @date 2019/7/7 - 15:50
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName, String password) {
        return userMapper.selByLogin(userName, password);
    }
}
