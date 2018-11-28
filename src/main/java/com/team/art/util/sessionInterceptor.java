package com.team.art.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team.art.entity.user.User;

public class sessionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String url = request.getRequestURI();

        //登陆的时候，会把用户信息存在session中，直接获取，

        User user = (User) request.getSession().getAttribute("user");

        //要是获得用户信息为空，就进入拦截器重定向的位置

        //添加一些不进入拦截器的例外（登陆，注册，以及注册页面需要的一些数据请求等）
        if (null == user && url.indexOf("login") == -1) {

            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        } else {
            return true;
        }

    }
}
