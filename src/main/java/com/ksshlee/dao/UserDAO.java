package com.ksshlee.dao;

import com.ksshlee.dto.UserVO;

public interface UserDAO {
	public void register(UserVO user) throws Exception;
	
}
