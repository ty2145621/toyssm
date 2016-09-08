package com.toy.test.example;

import org.apache.tools.ant.taskdefs.Sleep;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by toy on 2016/9/1.
 */
public class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("运行啦，时间为" + new Date());
    }
    @Test
    public void testTimer() throws InterruptedException {
        Timer timer = new Timer(true);
        try{
            MyTask myTask = new MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2016-9-1 16:25:00";
            Date date = sdf.parse(dateString);
            System.out.println("预计:" + date.toString() + " now:" + new Date().toString());
            timer.schedule(myTask, date);
        } catch (ParseException e) {
            System.out.println(e);
        }
        Thread.currentThread().sleep(1000);
    }
}
