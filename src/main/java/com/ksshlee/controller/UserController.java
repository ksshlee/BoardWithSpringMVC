package com.ksshlee.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ksshlee.dto.LoginVO;
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
	
	// 로그인 POST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(LoginVO login,RedirectAttributes redirectAttributes,HttpSession session) throws Exception {
		
		UserVO user = uservice.findId(login.getId());

		//비밀번호 확인
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder(10);
		if (!bcryptPasswordEncoder.matches(login.getPwd(), user.getPwd())) {
			redirectAttributes.addFlashAttribute("msg","로그인 실패");
			return "redirect:login";
		}else {
			uservice.login(user, session);
			return "redirect:/";
		}
	}
	
	// 로그아웃 GET
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGet(HttpSession session) throws Exception{
		uservice.logout(session);
		return "redirect:/";
	}
	

	// 회원가입 GET
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() throws Exception {
		return "user/registerForm";
	}

	// 회원가입 POST
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(UserVO user, RedirectAttributes redirectAttributes) throws Exception {
		
		// password hash
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder(10);
		String hashpwd = bcryptPasswordEncoder.encode(user.getPwd());
		user.setPwd(hashpwd);
		
		
		
		
		//insert to db
		uservice.register(user);

		
		redirectAttributes.addFlashAttribute("msg", "회원가입 성공");
		return "redirect:/";
	}
}
