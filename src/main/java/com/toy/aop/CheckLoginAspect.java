package com.toy.aop;


import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by toy on 2016/8/5.
 */

public class CheckLoginAspect {
    public ModelAndView checkLogin(HttpSession session)
    {
        String _id = (String) session.getAttribute("id");

        if(_id != null)
        {
            return new ModelAndView("login");
        } else
        {
            return new ModelAndView("login");
        }
    }
}
