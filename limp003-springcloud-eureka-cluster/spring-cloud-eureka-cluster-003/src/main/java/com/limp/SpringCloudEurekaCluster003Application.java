package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaCluster003Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaCluster003Application.class, args);
		System.out.println("sucess 7003 eureka");
	}
}
