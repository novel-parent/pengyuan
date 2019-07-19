package com.pengyuan.backstage.interceptor;

import com.pengyuan.backstage.util.JedisUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
