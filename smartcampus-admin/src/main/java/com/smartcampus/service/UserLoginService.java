package com.smartcampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcampus.entity.User;
import com.smartcampus.mapper.userMapper;

@Service
public class UserLoginService {

	/**
	 * 注入dao
	 */
	
	@Autowired
	private userMapper usermapper;

	// 用户登录
	public User userLogin(String username, String password) {
		User user = usermapper.userlogin(username, password);
		return user;
	}

	// 注册新用户
	public int adduser(String username, String password, String role) {

		return usermapper.adduser(username, password, role);
		
	}
}
