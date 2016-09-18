package com.toy.controller;

import com.toy.dao.ToyAdmin;
import com.toy.dao.ToyAdminExample;
import com.toy.interceptor.LogHandlerInterceptor;
import com.toy.service.IAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Security;
import java.util.Iterator;
import java.util.List;

/**
 * Created by toy on 2016/8/2.
 */
@Controller
@RequestMapping("/admin")
public class ToyAdminController {
    @Resource
    IAdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login()
    {
        return new ModelAndView("login");
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                              HttpSession session) throws Exception
    {
        /*if (session.getAttribute("id") != null) {
            return new ModelAndView("redirect:/user/list");
        }*/

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        ModelAndView modelAndView = new ModelAndView("login");

        String msg = "";
        if ("".equals(userName) || userName == null)
        {
            msg = "User Name ";
        }

        if ("".equals(password) || password == null)
        {
            modelAndView.addObject("userName", userName);
            msg += "Password ";
        }

        if (!msg.equals(""))
        {
            modelAndView.addObject("error", msg + "can't be null!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        /*
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if(userName.equals("") || password.equals("") || userName == null || password == null)
        {
            return "redirect:/admin/loginView";
        }

        attributes.addAttribute("userName", userName);
        attributes.addAttribute("password", password);
*/
        /*ToyAdminExample toyAdminExample = new ToyAdminExample();
        ToyAdminExample.Criteria criteria = toyAdminExample.createCriteria();

        criteria.andUsernameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        *//*推荐使用这种方法 添加where语句
        toyAdminExample.or().andUsernameEqualTo(userName)
                            .andPasswordEqualTo(password);
        *//*

        List<ToyAdmin> result = adminService.login(toyAdminExample);

        if(!result.isEmpty())
        {
            Iterator iterator = result.iterator();

            while(iterator.hasNext())
            {
                ToyAdmin toyAdmin = (ToyAdmin) iterator.next();
                session.setAttribute("id", toyAdmin.getId());
            }

            return  new ModelAndView("redirect:/user/list");
        } else
        {
            modelAndView.addObject("userName", userName);
            modelAndView.addObject("password", password);
            modelAndView.addObject("error", "User Name or Password error!");

            modelAndView.setViewName("login");
            return  modelAndView;
        }*/

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        /*记住我*/
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                return new ModelAndView("redirect:/user/list");
            } else {
                modelAndView.setViewName("login");
                return  modelAndView;
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            modelAndView.addObject("error", msg);
            System.out.println(msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            modelAndView.addObject("error", msg);
            System.out.println(msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            modelAndView.addObject("error", msg);
            System.out.println(msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            modelAndView.addObject("error", msg);
            System.out.println(msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            modelAndView.addObject("error", msg);
            System.out.println(msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            modelAndView.addObject("error", msg);
            System.out.println(msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            modelAndView.addObject("error", msg);
            System.out.println(msg);
        }
        modelAndView.setViewName("login");
        return  modelAndView;
    }

    @RequestMapping(value = "/loginView")
    public ModelAndView loginView(HttpServletRequest request,
                                  HttpSession session) throws Exception
    {
        return new ModelAndView("login");
    }
}
