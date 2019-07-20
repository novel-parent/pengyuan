package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.Factory;
import com.pengyuan.backstage.bean.PageBean;
import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.mapper.FactoryMapper;
import com.pengyuan.backstage.mapper.UserMapper;
import com.pengyuan.backstage.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author LX
 * @date 2019/7/7 - 15:50
 */
@Service
public class UserServiceImpl implements UserService {

	private final String prefix = "user:";

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

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

		int i = userMapper.addUser(user);

		System.out.println(888);
		if( i > 0 ){
			setRedisUserKey(user.getUserName());
		}

		return i;
	}

	@Override
	public int updateUser(User user) {

		User userInfo = getUserInfo(user.getUid());

		int i = userMapper.updateUser(user);

		if(i>0){
			updRedisUserKey(userInfo.getUserName(),user.getUserName() );
		}

		return i;
	}

	@Override
	public int deleteUser(long uid) {

		User userInfo = userMapper.getUserInfo(uid);
		int i = userMapper.deleteUser(uid);

		if( i > 0 ){
			updRedisUserKey(userInfo.getUserName(), null);
		}
		return i;
	}

	@Override
	public List<User> searchUserByCondition(User user) {
		
		User u=new User();
		
		if(user.getUserName()!=null ) {
			u.setUserName(user.getUserName());
		}
		if(user.getFid() != -1 && user.getFid() != 0) {
			u.setFid(user.getFid());
		}
		if(user.getTel() != null) {
			u.setTel(user.getTel());
		}
		if(user.getFlag() == 1) {
			u.setFlag(1);
		}else if(user.getFlag() == 0){
			u.setFlag(0);
		}
		
		return userMapper.selectUserByCondition(u);
	}

	

	@Override
	public List<PageBean> searchPageBean(User user, int pageNum) {
		
		User u=new User();
		
		if(user.getUserName()!=null ) {
			u.setUserName(user.getUserName());
		}
		if(user.getFid() != -1 && user.getFid() != 0) {
			u.setFid(user.getFid());
		}
		if(user.getTel() != null) {
			u.setTel(user.getTel());
		}
		if(user.getFlag() == 1) {
			u.setFlag(1);
		}else if(user.getFlag() == 0){
			u.setFlag(0);
		}
		
		//List<User> pageBean=userMapper.serachPage(u,pageNum);
		return null;
	}

	public void updRedisUserKey(String oldUsername , String newUsername){

    	if( oldUsername != null ){
    		stringRedisTemplate.delete(prefix+oldUsername);
		}
    	setRedisUserKey(newUsername);
	}

	public void setRedisUserKey(String username){

    	if(username != null){
			stringRedisTemplate.opsForValue().set(prefix + username, "1");
		}

	}
}
