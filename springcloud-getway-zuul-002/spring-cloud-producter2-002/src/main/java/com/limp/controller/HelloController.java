package com.limp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/10/27 14:02
 * @website： www.shinians.com
 */
@RestController
public class HelloController {
    private Logger logger= LoggerFactory.getLogger(HelloController.class);
    @RequestMapping( "/hello")
    public String hello(@RequestParam String  name){
        logger.info("/**************** producter2 name  is "+name+"***********/");
        try{
            //休眠
            Thread.sleep(1000000);
        }catch ( Exception e){
            logger.error(" producter2 hello controller error",e);
        }
        return "hello "+name+",welcome build spring-cloud producter2 second ";
    }
}
