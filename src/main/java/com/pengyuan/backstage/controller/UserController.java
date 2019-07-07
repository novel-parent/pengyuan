package com.pengyuan.backstage.controller;

import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
