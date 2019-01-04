package com.limp.controller;

import com.limp.service.HelloService;
import com.limp.service.HelloServiceRibbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;
    /**
     * helloServiceRibbon负载
     */
    @Autowired
    HelloServiceRibbon helloServiceRibbon;

    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable("name") String name){
        System.out.println("/***********consumer-FeignClient*****/");
        return  helloService.hello(name);
    }
    @RequestMapping(value = "/hello1/{name}")
    public String helloribbon(@PathVariable("name") String name){
        System.out.println("/***********consumer-helloServiceRibbon*****/");
        return  helloServiceRibbon.hello(name);
    }

}
