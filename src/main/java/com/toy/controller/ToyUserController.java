package com.toy.controller;

import com.sun.javafx.collections.IntegerArraySyncer;
import com.sun.javafx.sg.prism.NGShape;
import com.toy.dao.ToyUser;
import com.toy.dao.ToyUserExample;
import com.toy.mapper.ToyUserMapper;
import com.toy.service.IUserService;
import com.toy.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by toy on 2016/8/2.
 */
@Controller
@RequestMapping("/user")
public class ToyUserController {

    @Resource
    IUserService userService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, ModelAndView modelAndView,
                             HttpSession session) throws Exception
    {
        if (session.getAttribute("id") == null)
        {
            return new ModelAndView("login");
        }

        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        String _age = request.getParameter("age");
        String userName = request.getParameter("userName");
        String _page = request.getParameter("page");
        int page = 1;
        int pageSize = 2;

        if("".equals(_page) || _page == null)
        {
            _page = "1";
        }
        Integer age = null;
        if("".equals(_age) || _age == null)
        {
        } else
        {
            age = Integer.parseInt(_age);
        }
        page = Integer.parseInt(_page);
        System.out.println("age = "+age);
        hashMap.put("name", userName);
        hashMap.put("age", age);

        int count = userService.count(hashMap);

        int pages = (count + pageSize - 1) / pageSize;

        if(page >= pages)
        {
            page = pages;
        }
        if(page <= 0)
        {
            page = 1;
        }

        hashMap.put("offset", (page-1) * pageSize);
        hashMap.put("pageSize", pageSize);

        modelAndView.addObject("age", age);
        modelAndView.addObject("name", userName);
        modelAndView.addObject("page", page);
        modelAndView.addObject("pages", pages);
        modelAndView.addObject("pageSize", pageSize);

        List<ToyUser> users = userService.findUsers(hashMap);

        modelAndView.addObject("users", users);
        System.out.println(users);
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView)
    {
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView modelAndView, HttpServletRequest request)
    {
        ToyUser user = this.getUser(request);
        int line = userService.add(user);

        return new ModelAndView("redirect:/user/list");
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public ModelAndView update(@Param("id") Integer id, ModelAndView modelAndView)
    {
        ToyUser user = userService.findById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView update(ModelAndView modelAndView, HttpServletRequest request)
    {
        ToyUser user = this.getUser(request);
        int line = userService.update(user);

        return new ModelAndView("common/success");
    }

    private ToyUser getUser(HttpServletRequest request)
    {
        ToyUser user = new ToyUser();

        String _id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int sex = Integer.parseInt(request.getParameter("sex"));
        String email = request.getParameter("email");

        user.setAge(age);
        user.setEmail(email);
        user.setName(name);
        user.setSex(sex);
        Integer id = null;
        if("".equals(_id) || _id == null){}
        else
        {
            id = Integer.parseInt(_id);
        }
        user.setId(id);
        return user;
    }
}
