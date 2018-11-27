package com.limp.controller;

import com.limp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.println("/***********consumer*****/");
        return  helloService.hello();
    }

}
