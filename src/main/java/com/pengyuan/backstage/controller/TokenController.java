package com.pengyuan.backstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author LX
 * @date 2019/7/11 - 23:21
 */
@Controller
public class TokenController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final int time = 180;

    @ResponseBody
    @RequestMapping("/getToken.b")
    public String getToken(){

        String token = UUID.randomUUID().toString();

        stringRedisTemplate.opsForValue().set("token:"+token, "1",time , TimeUnit.SECONDS );

        return token;
    }
    									
}
