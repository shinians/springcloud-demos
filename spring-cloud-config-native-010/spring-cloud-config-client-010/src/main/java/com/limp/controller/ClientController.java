package com.limp.controller;


import com.limp.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2018/1/8
 * @time: 15:47
 * @description : do some thing
 */
@RestController
public class ClientController {

    @Autowired
    private ConfigProperties configProperties;
    @RequestMapping("/hello")
    public String getConfigInfo(){
        return "test-->"+configProperties.getHello()+new Date().getTime()+configProperties.intro+";"+configProperties.mysql;
    }
}
