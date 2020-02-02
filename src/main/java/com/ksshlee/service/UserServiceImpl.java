package com.ksshlee.service;

import javax.inject.Inject;

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
}
