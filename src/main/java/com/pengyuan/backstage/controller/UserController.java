package com.pengyuan.backstage.controller;

import com.pengyuan.backstage.bean.Factory;
import com.pengyuan.backstage.bean.JsonModel;
import com.pengyuan.backstage.bean.PageBean;
import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LX
 * @date 2019/7/7 - 15:34
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    

    @ResponseBody
    @RequestMapping("/login/{userName}/{password}")
    public User login(@PathVariable("userName") String userName, @PathVariable("password") String password, HttpServletRequest req){

        User user = userService.login(userName, password);

        return user;
    }
    
    @ResponseBody
    @RequestMapping("/getUserList")
    public List<User> getUserList(){
    	
    	List<User> userList=userService.getUserList();
    	
    	
    	return userList;
    }
    
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public User getUserInfo(long uid) {
    	
     return userService.getUserInfo(uid);
    }
    
    @ResponseBody
    @RequestMapping("/getFactoryList")
    public List<Factory> getFactoryList(){
    	
    	return userService.getFactoryList();
    }
    
    @ResponseBody
    @RequestMapping("updateUser")
    public JsonModel updateUser(User user) {
    	
    	System.out.println(user);
    	
    	JsonModel jm = new JsonModel();
    	//判断用户是的uid是否为空，如果为空则说明该用户在数据库里没有记录
    	if(user.getUid() <= 0 || "".equals(user.getUid()+"")) {
    		 if(userService.addUser(user)>0) {
    			 jm.setCode(1);
    			 jm.setMsg("添加成功！员工初始密码统一为：123456789");
    		 }else {
    			 jm.setCode(-1);
    			 jm.setMsg("系统繁忙！");
    		 }
    	}else {
    		if(userService.updateUser(user)>0){
    			jm.setCode(1);
   			 	jm.setMsg("修改成功！");
    		}else {
    			 jm.setCode(-1);
    			 jm.setMsg("系统繁忙！");
    		}
    	}
    	return jm;
    }
    
    @ResponseBody
    @RequestMapping("deleteUser")
    public Object deleteUser(long uid) {
    	JsonModel jm=new JsonModel();
    	userService.deleteUser(uid);
    	
    	jm.setCode(1);
    	jm.setMsg("删除成功！");
    	
    	return jm;
    }
    
    @ResponseBody
    @RequestMapping("serachUser")
    public Object serachUser(User user,int pageNum) {
    	JsonModel jm=new JsonModel();

    	List<User> userList=userService.SerachUserByCondition(user);
    	
    	//List<PageBean> pageList= userService.SerachPageBean(user,pageNum);
    	
    	if(userList.isEmpty()) {
    		jm.setCode(-1);
    		jm.setMsg("没有查找到匹配条件的员工信息");
    	}else {
    		jm.setCode(1);
    		jm.setObj(userList);
    	}
    	
		return jm;
    	
    }

}
