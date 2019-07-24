package com.pengyuan.backstage.controller;

import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LX
 * @date 2019/7/23 - 8:56
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @PostMapping("/login.u")
    public String login(@RequestParam(value = "username") String username , @RequestParam(value = "password") String password, HttpServletRequest request){

        String msg = "-1";

        User user = loginService.login(username, password);

        if (user != null && user.getDirector() != null ){

            msg = "uid="+user.getUid();

            request.getSession().setAttribute("pengyuan",user );
        }

        return msg;
    }
}
