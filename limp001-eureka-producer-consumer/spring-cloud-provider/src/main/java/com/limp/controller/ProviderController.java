package com.limp.controller;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping("/hello")
    public  String hello(@RequestParam String name){
        System.out.println("/*************provider hello controller*************/");
        return  "hello spring-cloud "+name;
    }
}
