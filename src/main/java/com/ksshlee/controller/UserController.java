package com.ksshlee.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ksshlee.dto.UserVO;
import com.ksshlee.service.UserService;

@Controller
public class UserController {

	@Inject
	private UserService uservice;

	// 로그인 GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() throws Exception {
		return "user/loginForm";
	}

	// 회원가입 GET
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() throws Exception {
		return "user/registerForm";
	}

	// 회원가입 POST
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String loginPost(UserVO user) throws Exception {
		uservice.register(user);

		return "redirect:/";
	}
}
