package com.ksshlee.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.ksshlee.dao.UserDAO;
import com.ksshlee.dto.UserVO;

@Repository
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDAO dao;
	
	
	//회원가입
	@Override
	public void register(UserVO user) throws Exception{
		dao.register(user);
	}
	
	
	//아이디 찾기
	@Override
	public UserVO findId(String id) throws Exception{
		return dao.findId(id);
	}
	
	
	//로그인 세션 등록
	@Override
	public void login(UserVO user,HttpSession session) throws Exception{
		session.setAttribute("sessionUserId", user.getId());
		session.setAttribute("sessionUserName", user.getUser_name());
	}
	
	//로그아웃
	@Override
	public void logout(HttpSession session) throws Exception{
		session.invalidate();
	}
}
