package com.toy.aop;

/**
 * Created by toy on 2016/8/6.
 */
public class TestAspect {
    public void beforeAspect()
    {
        System.out.println("++++before advice");
    }
    public void afterFinalAspect()
    {
        System.out.println("++++afterFinal advice");
    }
}
