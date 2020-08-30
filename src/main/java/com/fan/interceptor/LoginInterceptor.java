package com.fan.interceptor;

import com.fan.pojo.Login;
import com.fan.uitls.StrUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        Login login = (Login)request.getSession().getAttribute(StrUtils.LOGIN_USER);
        if (login == null) {
            //证明没有登录需要跳转到登录页面
            //1.在jquery中使用了ajax 会有特殊的请求头  带有  .do
            String header = request.getHeader("X-Requested-With");
            if (header != null && header.equals("XMLHttpRequest")) {
                response.getWriter().write("{\"code\":0, \"info\":\"未登录\"}");
            } else {
                response.sendRedirect(request.getContextPath()+"/html/login.html");
            }
            return false;

            //2.非ajax请求的   index.html   transform.html
        } else {
            return true;
        }

    }
}
