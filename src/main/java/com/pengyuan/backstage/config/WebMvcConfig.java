package com.pengyuan.backstage.config;

import com.pengyuan.backstage.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author LX
 * @date 2019/7/19 - 19:36
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new TokenInterceptor());

        interceptorRegistration.addPathPatterns("/newOrder").addPathPatterns("/updateUser");


    }
}
