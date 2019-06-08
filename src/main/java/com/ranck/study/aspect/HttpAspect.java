package com.ranck.study.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


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

    @Pointcut("execution(public  * com.ranck.study.controller.StudentController.*(..))")
    public void all() {

    }

    @Before("all()")
    public void doBefore() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}", request.getRequestURL());
        logger.info("method={}", request.getMethod());
        logger.info("ip={}", request.getRemoteAddr());
        logger.info("url={}", request.getRequestURL());
    }

    @AfterReturning(returning = "object" ,pointcut = "all()")
    public void doAfter (Object object) {
        System.out.println(object);
        logger.error(object.toString());
    }


}
