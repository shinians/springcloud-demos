package com.limp.controller;

import com.limp.intercepter.UserContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		if(UserContextHolder.currentUser()==null){
			return "user  is null";
		}
		System.out.println("auth success, the user is : " + UserContextHolder.currentUser().getUserName());
		System.out.println("----------------success access provider service----------------");
		return "success access "+UserContextHolder.currentUser().getUserName();
	}
}
