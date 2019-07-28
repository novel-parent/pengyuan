package com.pengyuan.backstage.mapper;

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
	 *      根据用户名查询  对应的工资
	 * @param username
	 * @return
	 */
	@Select("SELECT * FROM user WHERE userName = #{username} ")
	User selUserByName(@Param("username") String username);

	/**
	 *      根据uid 查询
	 * @param uid
	 * @return
	 */
	@Select("SELECT * FROM user WHERE uid = #{uid}")
	User selUserByUid(@Param("uid") long uid);

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
	/**
	 * 	用户的分页查询
	 * @param user ：查询条件
	 * @param pageNum ：查询的页数
	 * @return
	 */

	List<User> serachUserPage(@Param("user")User user,@Param("pageNum") int pageNum);
	
	/**
	 * 	获取带条件查询的总记录数
	 * @param user
	 * @return
	 */

	int getTotalPage(@Param("user")User user);

}
