package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEureka010Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEureka010Application.class, args);
		System.out.println("success");
	}
}
