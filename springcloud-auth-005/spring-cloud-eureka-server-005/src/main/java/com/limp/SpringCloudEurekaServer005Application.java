package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServer005Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServer005Application.class, args);
		System.out.println("/*************eureka启动成功***********/");
	}
}
