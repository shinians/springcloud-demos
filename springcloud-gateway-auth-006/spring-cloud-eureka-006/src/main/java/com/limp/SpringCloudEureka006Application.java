package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEureka006Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEureka006Application.class, args);
	}
}
