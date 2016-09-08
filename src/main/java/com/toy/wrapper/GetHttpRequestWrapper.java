package com.toy.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by toy on 2016/8/8.
 */
public class GetHttpRequestWrapper extends HttpServletRequestWrapper {
    public GetHttpRequestWrapper(HttpServletRequest request)
    {
        super(request);
    }

    @Override
    public String getParameter(String name)
    {
        String value = super.getParameter(name);
        /*if (name.equals("password"))
        {
            value = "tytyty";
        }*/
        System.out.println("wrapper : " + value);
        return value;
    }

}
