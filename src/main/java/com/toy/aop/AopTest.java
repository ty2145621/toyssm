package com.toy.aop;

import com.toy.service.impl.AdminServiceImpl;
import org.junit.Test;



/**
 * Created by toy on 2016/8/6.
 */
public class AopTest {

    @Test
    public void testInstanceof()
    {
        AdminServiceImpl admin = new AdminServiceImpl();
        assert(admin instanceof AdminServiceImpl);

    }
}
