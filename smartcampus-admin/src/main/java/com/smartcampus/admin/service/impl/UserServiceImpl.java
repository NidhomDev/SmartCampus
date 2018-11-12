package com.smartcampus.admin.service.impl;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcampus.admin.entity.User;
import com.smartcampus.admin.mapper.UserMapper;
import com.smartcampus.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean checkLogin(String userName, String password) {
		// TODO Auto-generated method stub
		// 根据登陆的用户名和密码进行验证 1.查询后台数据 返回类型为User
		User user = null;
		try {
			user = userMapper.selectByName(userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("selectByName sql error!!");
		}
		// 2、判断用户状态

		if (userName == null) {
			System.out.println("用户不存在：\n");
			// throw new Exception("该用户不存在!");
			return false;
		} else {
			// 3.判断密码
			if (password == null) {
				// throw new Exception("密码为空!");
				System.out.println("密码为空！\n");
				return false;
			} else {
				// 4、验证密码是否正确
				if (!(user.getPassword()).equals(password)) {
					// throw new Exception("密码错误!");
					System.out.println("密码错误！");
					return false;
				} else {
					System.out.println("密码匹配成功！\n");
					return true;
				}
			}
		}

	}

}
