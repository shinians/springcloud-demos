package com.limp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/8 16:08
 * @website： www.shinians.com
 */
@RestController
public class HelloController {
    @Autowired
    EurekaClientConfigBean eurekaClientConfigBean;


    @RequestMapping("hello")
    public String hello(){
        return  "hello 1";
    }
    @GetMapping("/eureka-server")
    public Object getEurekaServerUrl(){
        return eurekaClientConfigBean.getServiceUrl();
    }
}

