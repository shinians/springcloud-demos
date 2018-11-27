package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableZipkinServer

public class SpringCloudZipkinServer004Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinServer004Application.class, args);
		System.out.println("/*******************success***********/");
	}
}
