package com.limp;

import com.limp.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuul002Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuul002Application.class, args);
		System.out.println("/***************success  zuul 6001 启动成功******************/");

	}
	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter();
	}

}
