package com.limp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    EurekaClientConfigBean eurekaClientConfigBean;

    @GetMapping("/eureka")
    public Object getEurekaServerUrl(){
        return eurekaClientConfigBean.getServiceUrl();
    }
}
