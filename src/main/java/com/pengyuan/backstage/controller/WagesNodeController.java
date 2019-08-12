package com.pengyuan.backstage.controller;

import com.pengyuan.backstage.bean.JsonModel;
import com.pengyuan.backstage.bean.UserInfoWagesNodes;
import com.pengyuan.backstage.bean.WagesNode;
import com.pengyuan.backstage.service.WagesNodeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LX
 * @date 2019/7/24 - 23:46
 */
@Controller
public class WagesNodeController {

    @Autowired
    private WagesNodeService wagesNodeService;

    @ResponseBody
    @RequestMapping("/getWagesNode.b")
    public UserInfoWagesNodes getWagesNode(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int pageSize, Long startTime,
                                        Long endTime, @RequestParam(required = false) Long pid,@RequestParam(required = false) Long uid){

        UserInfoWagesNodes wagesNode = wagesNodeService.getWagesNode(page, pageSize, startTime, endTime, pid, uid);

        return wagesNode;
    }
    
    @ResponseBody
    @RequestMapping("putIntoWage.b")
    public Object putIntoWage(WagesNode wn,Long price) {
    	JsonModel jm=new JsonModel();
    	
    	System.out.println(wn);
    	
    	try {
	    	WagesNode wm = wagesNodeService.putIntoWage(wn,price);
	    	
	    	if(wm != null) {
	    		jm.setObj(wm);
	    		jm.setCode(1);
	    	}else {
	    		jm.setCode(-1);
	    		jm.setMsg("请求失败");
	    	}
    	}catch(Exception e) {
    		jm.setCode(-1);
    		jm.setMsg(e.getMessage());
    	}
    	
    	
    	return jm;
    }
    
    @ResponseBody
    @RequestMapping("saveEditProcedure.b")
    public Object saveEditProcedure(Integer number ,Long wid,Long uid,Long price) {
    	
    	JsonModel jm = new JsonModel();
    	
    	int i = wagesNodeService.updateWagesNode(wid , uid , number,price);
    	
    	if(i>0) {
    		jm.setCode(1);
    		jm.setMsg("修改成功");
    	}else {
    		jm.setCode(1);
    		jm.setMsg("请求失败");
    	}
    	
    	return jm;
    }
    
    @RequestMapping("deleteFromWageNode.b")
    @ResponseBody
    public Object deleteFromWageNode(Long wid) {
    	JsonModel jm = new JsonModel();
    	
    	int i = wagesNodeService.deleteFromWagesNode(wid);
    	
    	if(i>0) {
    		jm.setCode(1);
    		jm.setMsg("删除成功");
    	}else {
    		jm.setCode(-1);
    		jm.setMsg("请求失败");
    	}
    	
    	return jm;
    }


}
