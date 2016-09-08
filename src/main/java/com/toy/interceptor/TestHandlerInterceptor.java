package com.toy.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by toy on 2016/8/9.
 */
public class TestHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
                             Object handler) throws Exception {
        System.out.println("test interceptor preHandle");
        Integer id = (Integer) req.getSession().getAttribute("id");
        if("".equals(id) || id == null)
        {
            resp.sendRedirect("/admin/loginView");
            return false;
        } else
        {

        }
        return true;
    }

    @Override
    public void postHandle (HttpServletRequest req, HttpServletResponse resp,
                               Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("test interceptor postHandle");
    }

    @Override
    public void afterCompletion (HttpServletRequest req, HttpServletResponse resp,
                                 Object handler, Exception ex) throws Exception {
        System.out.println("test interceptor afterCompletion");
    }
}
