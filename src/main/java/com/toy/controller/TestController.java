package com.toy.controller;

import com.google.gson.Gson;
import com.sun.javafx.sg.prism.NGShape;
import com.toy.dao.ToyAdmin;
import org.apache.log4j.lf5.viewer.categoryexplorer.TreeModelAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by toy on 2016/9/7.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/testJson")
    public ModelAndView testJson(HttpServletRequest request, HttpServletResponse response,
                                 @RequestBody ToyAdmin toyAdmin) {
        System.out.println("toyAdmin:"+toyAdmin);
        System.out.println("toyAdmin id:"+toyAdmin.getId());
        System.out.println("toyAdmin username:"+toyAdmin.getUsername());
        System.out.println("toyAdmin password:"+toyAdmin.getPassword());

        return new ModelAndView("common/success");
    }

    @RequestMapping("/testRespondJson")
    public ModelAndView testRespondJson(HttpServletRequest request, HttpServletResponse response,
                                 @RequestBody ToyAdmin toyAdmin) {

        toyAdmin.setId(987);
        toyAdmin.setUsername("tianye");
        toyAdmin.setPassword("miao");

        Gson gson = new Gson();
        String obj = gson.toJson(toyAdmin);
        Map map = new HashMap<>();
        map.put("result", obj);
        return new ModelAndView("/common/success", map);
    }

    @RequestMapping("/testRespondJson2")
    @ResponseBody
    public String testRespondJson2(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody ToyAdmin toyAdmin) throws IOException {

        toyAdmin.setId(456);
        toyAdmin.setUsername("tianye");
        toyAdmin.setPassword("miao");

        Gson gson = new Gson();
        String obj = gson.toJson(toyAdmin);

        response.sendRedirect("/common/success");
        return obj;
    }

    //对比testRespondJson2，没有@ResponseBody的话return返回视为视图名
    @RequestMapping("/testRespondJson3")
    public String testRespondJson3(HttpServletRequest request, HttpServletResponse response,
                                   @RequestBody ToyAdmin toyAdmin) throws IOException {

        toyAdmin.setId(456);
        toyAdmin.setUsername("tianye");
        toyAdmin.setPassword("miao");

        Gson gson = new Gson();
        String obj = gson.toJson(toyAdmin);

        response.sendRedirect("/common/success");
        return "/admin/login";
    }
}
