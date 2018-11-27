package com.limp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/10/27 13:38
 * @website： www.shinians.com
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);
    //todo 带修正
//    private final Logger logger = LoggerFactory.getLogger(FallbackProvider.class);


    @RequestMapping("/hello")
    public  String hello(@RequestParam String name){
        return "hello "+name+",welcome build spring-cloud producter first";
    }
}
