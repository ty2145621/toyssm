package com.toy.test.example;

import org.apache.tools.ant.taskdefs.Sleep;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by toy on 2016/8/28.
 */
public class Test1 {
    @Test
    public void test1() throws Exception  {
        Miao miao = new Miao(15,"toy");
        System.out.println(miao.toString());

        Class<Miao> mclazz = Miao.class;

        Field ageField = mclazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(miao, 10);

        Field nameField = mclazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(miao, "ty");

        System.out.println(miao.toString());

        float f = 3.4f;

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println(f3 == f4);

    }

    @Test
    public void runTest() throws InterruptedException {
        Runnable myThread = new MyThread();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
        System.out.println("运行结束!");
        Thread.currentThread().sleep(1000);
    }
}

class MyThread implements Runnable {

    private int tickets=1000;
    @Override
    public void run() {
        int i = 0;
        while(tickets>0){
            System.out.println(Thread.currentThread().getName() + "i: " + i++);
            System.out.println(Thread.currentThread().getName()+"卖出第【"+tickets--+"】张火车票");
        }
    }
}