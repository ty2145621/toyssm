package com.toy.test.mock;

import com.toy.aop.PointCut;

/**
 * Created by toy on 2016/8/16.
 */
public class Publisher {
    public Publisher() {
        System.out.println("无参构造");
    }

    public int dothings(String message) {
        PointCut p = new PointCut();

        p.main(message);

        return 1;
    }

}
