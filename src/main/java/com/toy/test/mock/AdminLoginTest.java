package com.toy.test.mock;

import com.toy.controller.ToyAdminController;
import com.toy.service.IAdminService;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by toy on 2016/8/17.
 */
public class AdminLoginTest {

    private ToyAdminController toyAdminController;
    @Test
    public void testLogin() throws Exception {
        toyAdminController = new ToyAdminController();
        MockHttpServletRequest req = new MockHttpServletRequest();
        MockHttpSession session = new MockHttpSession();
        MockHttpServletResponse resp = new MockHttpServletResponse();

        req.setParameter("userName", "toy");
        req.setParameter("password", "tytyty");

        ModelAndView modelAndView;

        modelAndView = toyAdminController.login(req, resp, session);


    }


}
