package com.toy.test.mock;

import com.toy.aop.PointCut;
import com.toy.aop.TestAspect;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by toy on 2016/8/16.
 */
public class PublisherTest {
    /*Mockery context = new JUnit4Mockery();

    @Test
    public void oneSubscriberReceivesAMessage() {
        final PointCut pointcut = context.mock(PointCut.class);

        Publisher publisher = new Publisher();

        final String message = "message";

        context.checking(new Expectations() {{
            oneOf (pointcut).main(message);
        }});
        Assert.assertEquals((publisher.dothings(message)) ,1);
    }*/
}
