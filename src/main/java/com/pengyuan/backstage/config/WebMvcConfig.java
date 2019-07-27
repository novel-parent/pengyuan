package com.pengyuan.backstage.config;

import com.pengyuan.backstage.filter.UserFilter;
import com.pengyuan.backstage.interceptor.TokenInterceptor;
import com.pengyuan.backstage.interceptor.UserInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author LX
 * @date 2019/7/19 - 19:36
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new UserFilter());

        filterRegistrationBean.addUrlPatterns("/index.html","/list.html",
                "/staff.html","/productEdit.html","/procedureInfo.html","/procedureList.html");

        return filterRegistrationBean;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new TokenInterceptor());

        interceptorRegistration.addPathPatterns("/newOrder.b","/updOrder.b").addPathPatterns("/updateUser.b").addPathPatterns("SaveProcedureData.b").addPathPatterns("putIntoWage.b");

        InterceptorRegistration interceptorRegistration1 = registry.addInterceptor(new UserInterceptor());

        interceptorRegistration1.addPathPatterns("/*").order(1).excludePathPatterns("/login.b","/druid/*");

    }
}
