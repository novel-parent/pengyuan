package com.pengyuan.backstage.controller;

import com.pengyuan.backstage.bean.UserInfoWagesNodes;
import com.pengyuan.backstage.service.WagesNodeService;
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
    public UserInfoWagesNodes getWagesNode(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "1") int pageSize, Long startTime,
                                        Long endTime, @RequestParam(required = false) Long pid,@RequestParam(required = false) String username){

        UserInfoWagesNodes wagesNode = wagesNodeService.getWagesNode(page, pageSize, startTime, endTime, pid, username);

        System.out.println(wagesNode);
        return wagesNode;
    }

}
