package com.ranck.study.controller;

import com.ranck.study.config.LimitConfig;
import com.ranck.study.aspect.HttpAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        logger.error("ranck");
        return "hello ranck";
    }

    @Value("${maxMoney}")
    private BigDecimal maxMoney;

    @PostMapping("/hello")
    @ResponseBody
    public String hello() {
        return "H:" + maxMoney;
    }

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/limit")
    @ResponseBody
    public String hi() {
        return "中文：" + limitConfig.getShow();
    }

}
