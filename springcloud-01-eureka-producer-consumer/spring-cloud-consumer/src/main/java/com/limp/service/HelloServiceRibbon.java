package com.limp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceRibbon {

    @Autowired
    RestTemplate restTemplate;

    public String hello( String name){
        return restTemplate.getForObject("http://spring-cloud-provider/hello?name="+name,String.class);
    };
}
