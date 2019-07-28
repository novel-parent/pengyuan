package com.pengyuan.backstage.controller;

import com.pengyuan.backstage.bean.Factory;
import com.pengyuan.backstage.bean.JsonModel;
import com.pengyuan.backstage.bean.UserModel;
import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

	/**
	 *     用户 退出登陆
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/exit.b")
	public String exitLogin(HttpServletRequest request){

		request.getSession().removeAttribute("pengyuan");
		return "/login.html";
	}


   /**
    * 	修改用户信息时给模态框赋值
    * @param uid ：员工id
    * @return
    */
    @ResponseBody
    @RequestMapping("/getUserInfo.b")
    public User getUserInfo(long uid) {
    	
     return userService.getUserInfo(uid);
    }
    
    /**
         *   获取所有工厂列表，用于给下拉框加载工厂列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getFactoryList.b")
    public List<Factory> getFactoryList(){
    	
    	return userService.getFactoryList();
    }
    
    /**
         *  更新或者添加用户。如果uid不为空则为修改员工信息，否则为新增员工
     * @param user ：前台传入的员工信息
     * @return
     */
    @ResponseBody
    @RequestMapping("updateUser.b/{currentPage}")
    public JsonModel updateUser(User user,@PathVariable("currentPage") String currentPage) {
    	
    	
    	JsonModel jm = new JsonModel();
    	
    	
    	//判断用户是的uid是否为空，为空为新增员工，不为空为更新员工信息
    	try {
    		
	    	if(user.getUid() == null) {
	    		 if(userService.addUser(user)>0) {
	    			 jm.setCode(1);
	    			 jm.setMsg("添加成功！员工初始密码统一为：123456789");
	    		 }else {
	    			 jm.setCode(-1);
	    			 jm.setMsg("系统繁忙！");
	    		 }
	    	}else {
	    		if(userService.updateUser(user)>0){
	    			jm.setCode(Integer.valueOf(currentPage));
	   			 	jm.setMsg("修改成功！");
	    		}else {
	    			 jm.setCode(-1);
	    			 jm.setMsg("系统繁忙！");
	    		}
	    	}	
	    	
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    		jm.setCode(-1);
			jm.setMsg("系统繁忙！");
			
    	}
    	return jm;
    }
    
    /**
         *  删除员工
     * @param uid
     * @param currentPage ：在做删除员工操作时，用户浏览的时第几页
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteUser.b/{currentPage}")
    public Object deleteUser(long uid,@PathVariable("currentPage") int currentPage ) {
				    	
    	JsonModel jm=new JsonModel();
    	
    	//将页码回传
		jm.setCode(currentPage);
    	
    	try {
			int i = userService.deleteUser(uid);
	
			if(i>0) {
				
				//设置回传数据
				jm.setCode(currentPage);
				
		    	jm.setMsg("删除成功！");
			}else {
				jm.setCode(-1);
				jm.setMsg("请求失败");
			}
    	}catch (Exception e) {
    		e.printStackTrace();
    		jm.setCode(-1);
        	jm.setMsg("请求失败");
    	}
    	
    	return jm;
    }
    
    /**
         *  用户信息的查询
     * @param user ：前台输入的用户信息
     * @param pageNum ：当前查询第几页
     * @return
     */
    @ResponseBody
    @RequestMapping("/searchUser.b")
    public Object searchUser(User user,int pageNum) {
    	
    	
    	UserModel userList= userService.SerachPageBean(user,pageNum);
    	
    	
    	if(userList.getObj().isEmpty()) {
    		userList.setCode(-1);
    		userList.setMsg("没有查找到匹配条件的员工信息");
    	}else {
    		userList.setCode(1);
    		userList.setObj(userList.getObj());
    	}
    	
    	
		return userList;
    	
    }
    
    /**
         *    通过uid获取 userName
     * @param uname
     * @return
     */
    
    
    @ResponseBody
    @RequestMapping("/getUidByUname.b")
    public Object getUidByUname(String uname) {
    	JsonModel jm = new JsonModel();
    	
    	System.out.println(uname);
    	
    	User user= userService.SerachUserByUserName(uname);
    	
    	
    	if(user == null) {
    		jm.setCode(-1);
    		jm.setMsg("该用户不存在");
    	}else {
    		jm.setCode(1);
    		jm.setObj(user);
    	}
    	
    	
		return jm;
    	
    }

}
