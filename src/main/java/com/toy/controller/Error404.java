package com.toy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by toy on 2016/8/26.
 */

@Controller
public class Error404 {
    @RequestMapping("/404")
    public ModelAndView Error404(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/common/404");
    }
}
