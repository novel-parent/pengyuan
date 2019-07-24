package com.pengyuan.backstage.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LX
 * @date 2019/6/8 - 21:57
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){

        return new  DruidDataSource();
    }

    //配置 Druid的监控
    // 1: 配置一个管理后台的 Servlet
    // 2: 配置一个监控的 filter

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "a");
        initParams.put("allow", "");
        initParams.put("resetEnable", "false");
        registrationBean.setInitParameters(initParams);
        return  registrationBean;
    }
}
