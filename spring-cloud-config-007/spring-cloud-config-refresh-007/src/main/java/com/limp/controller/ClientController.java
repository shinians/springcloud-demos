package com.limp.controller;


import com.limp.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @time: 15:47
 * @description : do some thing
 */
@RestController
@RefreshScope
public class ClientController {

    @Autowired
    private ConfigProperties configProperties;



    @RequestMapping("/hello")
    public String getConfigInfo(){
        return "test-->"+configProperties.getHello()+new Date().getTime()+configProperties.intro;
    }
}
