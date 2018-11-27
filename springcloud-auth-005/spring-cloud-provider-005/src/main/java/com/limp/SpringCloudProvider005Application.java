package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@RestController
public class SpringCloudProvider005Application extends ResourceServerConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProvider005Application.class, args);
		System.out.println("provider 启动成功");
	}
	@RequestMapping("/test")
	public String test(HttpServletRequest request) {
		System.out.println("----------------header----------------");
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			System.out.println(key + ": " + request.getHeader(key));
		}
		System.out.println("----------------header----------------");
		return "hellooooooooooooooo!";
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
	/*	http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/**").authenticated()
				.antMatchers(HttpMethod.GET, "/test")
				.hasAuthority("WRIGTH_READ");*/
		http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources
				.resourceId("WRIGTH")
				.tokenStore(jwtTokenStore());
	}

	@Bean
	protected JwtAccessTokenConverter jwtTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("springcloud123");
		return converter;
	}

	@Bean
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtTokenConverter());
	}
}
