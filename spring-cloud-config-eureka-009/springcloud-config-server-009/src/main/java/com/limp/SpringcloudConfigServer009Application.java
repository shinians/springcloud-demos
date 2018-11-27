package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcloudConfigServer009Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigServer009Application.class, args);
	}
}
