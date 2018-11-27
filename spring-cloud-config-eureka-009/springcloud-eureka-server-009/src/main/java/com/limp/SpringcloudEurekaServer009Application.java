package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurekaServer009Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaServer009Application.class, args);
	}
}
