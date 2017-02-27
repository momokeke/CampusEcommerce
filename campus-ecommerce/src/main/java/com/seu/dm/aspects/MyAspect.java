package com.seu.dm.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;


/**
 * Created by Greeting on 2017/2/27.
 */

@Aspect
@Service
public class MyAspect {
    @Before("execution(* com.seu.dm.services.DemoService.testAspect(..))")
    public void beforeTest(){
        Math.abs(-10);
        System.out.println("beforeTest()");
    }
}



