package com.pengyuan.backstage.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author LX
 * @date 2019/7/23 - 13:59
 */
public class UserFilter implements Filter {

    private final String regex = "^.{0,30}(.b|login.html|js|css)$";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;

        Object pengyuan = servletRequest.getSession().getAttribute("pengyuan");

        if( pengyuan != null ){
            chain.doFilter(request,response );
        }
        return;
    }

    @Override
    public void destroy() {

    }
}
