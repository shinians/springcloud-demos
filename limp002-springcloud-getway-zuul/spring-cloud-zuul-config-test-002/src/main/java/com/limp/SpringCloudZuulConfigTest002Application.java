package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuulConfigTest002Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulConfigTest002Application.class, args);
		System.out.println("/***************success  zuul 6002 启动成功******************/");

	}
}
