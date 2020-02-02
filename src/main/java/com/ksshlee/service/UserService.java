package com.ksshlee.service;

import javax.servlet.http.HttpSession;

import com.ksshlee.dto.UserVO;

public interface UserService {
	public void register(UserVO user) throws Exception;
	public UserVO findId(String id) throws Exception;
	public void login(UserVO user,HttpSession session) throws Exception;
	public void logout(HttpSession session) throws Exception;
}
