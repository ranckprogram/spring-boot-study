package com.ranck.study.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class HttpAspect {

    private static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @After("execution(public * com.ranck.study.controller.StudentController.user(..))")
    public void justUser() {
        System.out.println("这是专属于user的");
    }

    @Pointcut("execution(public * com.ranck.study.controller.StudentController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void beforeTips() {
        System.out.println("在访问控制器之前的切面");
        logger.info("试试呗");
    }

    @After("log()")
    public void afterTips() {
        System.out.println("在访问控制器之后的切面");
    }
}
