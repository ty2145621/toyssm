package com.toy.test;

import com.toy.interceptor.LogHandlerInterceptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by toy on 2016/8/9.
 */
public class TestInterceptor {

    @Test
    public void testHandlerInterceptor() {
        System.out.println("!!这里是test本体！！");

    }
}
