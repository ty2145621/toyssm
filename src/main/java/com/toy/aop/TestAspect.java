package com.toy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;

import javax.servlet.http.HttpServletRequest;

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

    /*@Around("execution(* com.toy.controller.ToyAdminController.login(..)")*/
    public Object aroundAspect(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("before advice");
        System.out.println(pjp);
        Class Tclass = pjp.getTarget().getClass();
        Object[] args = pjp.getArgs();
        for (Object arg:args) {
            if(arg instanceof HttpServletRequest)
            {
                System.out.println("Aspect记录password:"+((HttpServletRequest) arg).getParameter("password"));
            }
        }
        Object retVal = pjp.proceed();
        System.out.println("after advice");
        return retVal;
    }

    /*@AfterThrowing(pointcut = "execution(* com.toy.controller.ToyUserController.getUser(..))",
                    throwing = "exception")*/
    public void afterThrowingAspect(Throwable exception) {
        System.out.println("After throwing advice exception " + exception);
    }
}
