package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.mapper.LoginMapper;
import com.pengyuan.backstage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LX
 * @date 2019/7/23 - 9:02
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User login(String username, String password) {

        User user = loginMapper.selByUsernamePwd(username, password);

        return user;
    }
}
