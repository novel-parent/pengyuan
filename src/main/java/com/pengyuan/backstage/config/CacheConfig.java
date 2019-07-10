package com.pengyuan.backstage.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


/**
 * @author LX
 * @date 2019/6/11 - 13:32
 */
@Configuration
public class CacheConfig {

    /**
     * 自己生成的  keyGenerator    可以直接在里面指定 自己生成的
     * @return
     */
    @Bean(name = "myKeyGenerator")
    public KeyGenerator keyGenerator(){

        return ( target, method, params) ->
                method.getName();
    }
}
