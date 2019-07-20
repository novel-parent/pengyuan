package com.pengyuan.backstage.service;

import java.util.List;

import com.pengyuan.backstage.bean.Factory;
import com.pengyuan.backstage.bean.PageBean;
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

	List<User> getUserList();

	User getUserInfo(long uid);

	List<Factory> getFactoryList();

	int addUser(User user);

	int updateUser(User user);

	void deleteUser(long uid);

	//List<User> SerachUserByCondition(User user);

	List<PageBean> SerachPageBean(User user, int pageNum);

	List<User> SerachUserByCondition(User user);

}
