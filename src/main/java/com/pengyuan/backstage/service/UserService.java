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

	/**
	 *       查询所有 员工
	 * @return
	 */
	List<User> getUserList();

	/**
	 *      查询 员工的个人信息
	 * @param uid
	 * @return
	 */
	User getUserInfo(long uid);

	/**
	 *       查询 工厂
	 * @return
	 */
	List<Factory> getFactoryList();

	/**
	 *       添加员工
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 *     更新员工信息
	 * @param user
	 * @return
	 */
	int updateUser(User user);

	/**
	 *       删除员工
	 * @param uid
	 * @return
	 */
	int deleteUser(long uid);

	//List<User> SerachUserByCondition(User user);

	/**
	 *         搜素分页
	 * @param user
	 * @param pageNum
	 * @return
	 */
	//List<PageBean> searchPageBean(User user, int pageNum);

	/**
	 *     搜索查询
	 * @param user
	 * @return
	 */
	List<User> searchUserByCondition(User user);
	/**
	  *  用户的分页查询
	 * @param user
	 * @param pageNum
	 * @return
	 */

	PageBean SerachPageBean(User user, int pageNum);

}
