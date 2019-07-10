package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.Factory;
import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.mapper.FactoryMapper;
import com.pengyuan.backstage.mapper.UserMapper;
import com.pengyuan.backstage.service.UserService;

import java.util.List;

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
    
    @Autowired
    private FactoryMapper fm;

    @Override
    public User login(String userName, String password) {
        return userMapper.selByLogin(userName, password);
    }

	@Override
	public List<User> getUserList() {
		
		return userMapper.getUserList();
	}

	@Override
	public User getUserInfo(long uid) {
		
		return userMapper.getUserInfo(uid);
	}

	@Override
	public List<Factory> getFactoryList() {
		
		return fm.getAllFactory();
	}

	@Override
	public int addUser(User user) {
		
		return userMapper.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}
}
