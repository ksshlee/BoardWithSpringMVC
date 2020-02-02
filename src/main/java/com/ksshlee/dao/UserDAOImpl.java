package com.ksshlee.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ksshlee.dto.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.ksshlee.study.mappers.userMapper";
	
	
	//회원가입
	@Override
	public void register(UserVO user) throws Exception{
		sqlSession.insert(Namespace+".register",user);
	}
	
	

}
