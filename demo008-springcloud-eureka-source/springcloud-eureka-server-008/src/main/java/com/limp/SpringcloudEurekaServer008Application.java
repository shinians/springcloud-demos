package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurekaServer008Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaServer008Application.class, args);
		System.err.println("/***server 7001 running**********/");
	}
}
