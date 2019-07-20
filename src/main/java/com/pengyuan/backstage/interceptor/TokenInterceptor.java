package com.pengyuan.backstage.interceptor;

import com.pengyuan.backstage.util.JedisUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LX
 * @date 2019/7/19 - 19:33
 */
public class TokenInterceptor implements HandlerInterceptor {

    private JedisUtil jedisUtil;

    public TokenInterceptor() {
        jedisUtil = new JedisUtil();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getParameter("token");
        
        String uid = request.getParameter("uid");
        //uid为空表示此次操作为更新用户信息，不做处理
        if(uid==null || "".equals(uid)) {
        	System.out.println("此次为更新操作");
        	
        	Map<String,String[]> map = request.getParameterMap();
        	
        	for(String s:map.keySet()) {
        		System.out.println("Map   Key    :"+map.get(s));
        	}
        	
        	
        	return true;
        }
        

        if(jedisUtil.del(token)>0){
            return true;
        }
        response.getWriter().write("-1");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
