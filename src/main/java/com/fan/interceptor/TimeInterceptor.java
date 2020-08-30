package com.fan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeInterceptor implements HandlerInterceptor {
    private  ThreadLocal<Long> threadLocal =  new ThreadLocal<>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandle");
        long beginTime = System.currentTimeMillis();
        threadLocal.set(beginTime);
        //Thread.sleep(5000);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("posthandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        long endTime = System.currentTimeMillis();
        Long beginTime = threadLocal.get();
        long v = endTime - beginTime;
        System.out.println(v);
    }
}
