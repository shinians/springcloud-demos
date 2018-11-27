package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaTwo003Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaTwo003Application.class, args);
		System.out.println("/*************spring cloud eureka 7002********************/");

	}
}
