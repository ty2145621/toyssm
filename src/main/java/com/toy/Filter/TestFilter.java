package com.toy.Filter;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.toy.wrapper.GetHttpRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by toy on 2016/8/8.
 */
public class TestFilter implements Filter{

    FilterConfig config;
    public void init(FilterConfig config) throws ServletException {
        System.out.println("begin do test filter");
        this.config = config;
    }
    public void destroy() {
        this.config = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        ServletContext context = this.config.getServletContext();

        HttpServletRequest hreq = (HttpServletRequest) req;
        String password = hreq.getParameter("password");
        System.out.println("filter : " + password);

        ServletRequest new_req = new GetHttpRequestWrapper((HttpServletRequest) req);

        password = new_req.getParameter("password");
        System.out.println("filter : " + password);

        /*继续运行下一个filter*/
        chain.doFilter(new_req, resp);

    }


}
