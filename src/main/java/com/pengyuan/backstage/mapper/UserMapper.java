package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.Orders;
import com.pengyuan.backstage.bean.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author LX
 * @date 2019/7/7 - 15:24
 */
public interface UserMapper {

    /**
     *
     *  根据用户名和密码
     *
     * @param userName
     * @param password
     * @return
     */
    @Select("SELECT * FROM USER WHERE userName=#{userName} AND password=#{password}")
    User selByLogin(@Param("userName") String userName, @Param("password") String password);

	/**
	 *       得到用户的列表
	 * @return
	 */
	List<User> getUserList();

	/**
	 *       查询用户 信息
	 * @param uid
	 * @return
	 */
	User getUserInfo(long uid);

	/**
	 *      添加员工
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 *     修改员工信息
	 * @param user
	 * @return
	 */
	int updateUser(User user);

	/**
	 *   删除员工
	 * @param uid
	 * @return
	 */
	int deleteUser(long uid);

	/**
	 *       通过条件 查询 员工
	 * @param u
	 * @return
	 */
	List<User> selectUserByCondition(User u);

}
