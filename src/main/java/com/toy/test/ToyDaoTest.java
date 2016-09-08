package com.toy.test;

import com.toy.controller.ToyAdminController;
import com.toy.dao.ToyAdmin;
import com.toy.dao.ToyAdminExample;
import com.toy.service.IAdminService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static sun.plugin2.util.PojoUtil.toJson;


/**
 * Created by toy on 2016/8/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "target/toyssm")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:spring.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:spring-init.xml")
})
public class ToyDaoTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private IAdminService adminService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetLoginSuccess() throws Exception {
        ToyAdminExample toyAdminExample = new ToyAdminExample();
        toyAdminExample.or().andUsernameEqualTo("toy")
                            .andPasswordEqualTo("tytyty");
        List<ToyAdmin> result = adminService.login(toyAdminExample);
        Assert.assertTrue(result.size() == 1);
    }
    @Test
    public void testGetLoginFail() throws Exception {
        ToyAdminExample toyAdminExample = new ToyAdminExample();
        toyAdminExample.or().andUsernameEqualTo("ty")
                            .andPasswordEqualTo("tytyty");
        List<ToyAdmin> result = adminService.login(toyAdminExample);
        Assert.assertTrue(result.size() == 0);
    }

    @Test
    public void testLoginSuccess() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/admin/login").sessionAttr("id","123").param("userName", "toy").param("password", "tytyty")) //执行传递参数的POST请求(也可以post("/user?name=zhang"))
                .andDo(print())
                .andExpect(handler().handlerType(ToyAdminController.class)) //验证执行的控制器类型
                .andExpect(handler().methodName("login")) //验证执行的控制器方法名
                .andExpect(model().hasNoErrors()) //验证页面没有错误
                /*.andExpect(flash().attributeExists())*/ //验证存在flash属性
                .andExpect(view().name("redirect:/user/list")); //验证视图

        MvcResult mvcResult = resultActions.andReturn();
    }

    @Test
    public void testLoginFail() throws Exception {

        ResultActions resultActions = mockMvc.perform(post("/admin/login").param("userName", "ty").param("password", "tytyty")) //执行传递参数的POST请求(也可以post("/user?name=zhang"))
                .andDo(print())
                .andExpect(handler().handlerType(ToyAdminController.class)) //验证执行的控制器类型
                .andExpect(handler().methodName("login")) //验证执行的控制器方法名
                .andExpect(model().hasNoErrors()) //验证页面没有错误
                /*.andExpect(flash().attributeExists())*/ //验证存在flash属性
                .andExpect(view().name("login")); //验证视图

        MvcResult mvcResult = resultActions.andReturn();
    }

    @Test
    public void test404Fail() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user/login", 1))
                .andDo(print())
                .andExpect(status().isNotFound()) //验证控制器不存在
                .andReturn();
        Assert.assertNull(mvcResult.getModelAndView());
    }

    @Test
    public void testUserListSuccess() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user/list").sessionAttr("id",123))
                .andDo(print())
                .andExpect(view().name("user/list1"))
                .andReturn();
    }

    @Test
    public void testUserListFail() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user/list"))
                .andDo(print())
                .andExpect(redirectedUrl("/admin/loginView"))
                .andReturn();
    }

    @Test
    public void testAdd() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/user/add").param("age", "1")
                                .param("sex", "1").sessionAttr("id", 1) )
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testProperties() throws Exception {
    }

    @Test
    public void testReceiveJson() throws  Exception {
        MvcResult mvcResult = mockMvc.perform(post("/test/testJson")
                    .contentType(APPLICATION_JSON_UTF8)
                    .content(toJson(new ToyAdmin(123,"toy","tytyty")))
                )
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testRespondJson() throws  Exception {
        MvcResult mvcResult = mockMvc.perform(post("/test/testRespondJson")
                .contentType(APPLICATION_JSON_UTF8)
                .content(toJson(new ToyAdmin(123,"toy","tytyty")))
                )
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testRespondJson2() throws  Exception {
        MvcResult mvcResult = mockMvc.perform(post("/test/testRespondJson2")
                .contentType(APPLICATION_JSON_UTF8)
                .content(toJson(new ToyAdmin(123,"toy","tytyty")))
        )
                .andDo(print())
                .andReturn();
    }

    @Test
    public void testRespondJson3() throws  Exception {
        MvcResult mvcResult = mockMvc.perform(post("/test/testRespondJson3")
                .contentType(APPLICATION_JSON_UTF8)
                .content(toJson(new ToyAdmin(123,"toy","tytyty")))
        )
                .andDo(print())
                .andReturn();
    }
}
