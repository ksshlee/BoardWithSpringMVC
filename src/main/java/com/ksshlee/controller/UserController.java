package com.ksshlee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	
	// 로그인 GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return "user/loginForm";
	}
	
	
	
	// 회원가입 GET
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {
		return "user/registerForm";
	}
}
