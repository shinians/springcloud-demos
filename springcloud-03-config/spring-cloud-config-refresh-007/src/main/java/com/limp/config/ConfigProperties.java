package com.limp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/3 17:58
 * @website： www.shinians.com
 */
@Component
@ConfigurationProperties(prefix = "limp")
@RefreshScope
public class ConfigProperties {

    private String hello;

   //@Value("${limp.hello}")
    public String intro;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
