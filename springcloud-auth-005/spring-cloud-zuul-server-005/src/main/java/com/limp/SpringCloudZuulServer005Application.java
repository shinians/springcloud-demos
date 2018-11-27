package com.limp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableOAuth2Sso
public class SpringCloudZuulServer005Application  extends WebSecurityConfigurerAdapter {
	Logger logger= LoggerFactory.getLogger(SpringCloudZuulServer005Application.class);

	public static void main(String[] args) {
		Logger logger= LoggerFactory.getLogger(SpringCloudZuulServer005Application.class);

		SpringApplication.run(SpringCloudZuulServer005Application.class, args);
		System.out.println("success zuul server");
		logger.info("启动成功");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/login", "/spring-cloud-provider-005/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.csrf()
				.disable();
	}
}
