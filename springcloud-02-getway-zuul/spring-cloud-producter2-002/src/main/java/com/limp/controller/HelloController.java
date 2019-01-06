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
            //通过使用Thread.sleep(100000)达到Zuul转发超时情况(Zuul默认连接超时未2s、read超时时间为5s)，从而触发Zuul的重试功能。这时候在此访问
            //休眠
            Thread.sleep(1000000);
        }catch ( Exception e){
            logger.error(" producter2 hello controller error",e);
        }
        return "hello "+name+",welcome build spring-cloud producter2 second ";
    }
}
