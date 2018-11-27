package com.limp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/10/27 17:56
 * @website： www.shinians.com
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return  "hello "+name+" spring cloud eureka";
    }
}
