package com.smartcampus.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.smartcampus.dao.LoginTicketDao;
import com.smartcampus.dao.UserDao;
import com.smartcampus.entity.LoginTicket;
import com.smartcampus.entity.User;
import com.smartcampus.util.SmartCampusUtil;

/**
 * 
 * @title UserService.java
 * @author guohk
 * @version v1.0
 * @date 2018年11月9日 上午1:25:54
 */
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private LoginTicketDao loginTicketDao;

	public User getUser(int userId) {
		return userDao.seletById(userId);
	}

	public User getUserByName(String name) {
		return userDao.seletByName(name);
	}

	public void addUser(User user) {
		userDao.insertUser(user);
	}
	
	//注册
	public Map<String, String> register(String username, String password) {
		Map<String, String> map = new HashMap<>();
		Random random = new Random();
		if (StringUtils.isBlank(username)) {
			map.put("msg", "用户名不能为空");
			return map;
		}

		if (StringUtils.isBlank(password)) {
			map.put("msg", "密码不能为空");
			return map;
		}

		User u = userDao.seletByName(username);
		if (u != null) {
			map.put("msg", "用户名已经被占用");
			return map;
		}

		User user = new User();
		user.setName(username);
		user.setSalt(UUID.randomUUID().toString().substring(0, 5));
		user.setHeadUrl(String.format("https://images.nowcoder.com/head/%dm.png", random.nextInt(1000)));
		user.setPassword(SmartCampusUtil.MD5(password + user.getSalt()));
		user.setRole("user");
		userDao.insertUser(user);

		String ticket = addLoginTicket(user.getId());
		map.put("ticket", ticket);

		return map;
	}
	
	//登录
	public Map<String, String> login(String username, String password) {
		Map<String, String> map = new HashMap<>();
		Random random = new Random();
		if (StringUtils.isBlank(username)) {
			map.put("msg", "用户名不能为空");
			return map;
		}

		if (StringUtils.isBlank(password)) {
			map.put("msg", "密码不能为空");
			return map;
		}

		User u = userDao.seletByName(username);
		if (u == null) {
			map.put("msg", "用户名不存在");
			return map;
		}

		if (!SmartCampusUtil.MD5(password + u.getSalt()).equals(u.getPassword())) {
			map.put("msg", "密码错误");
			return map;
		}

		String ticket = addLoginTicket(u.getId());
		map.put("ticket", ticket);

		return map;
	}
	
	//注销
	public void logout(String ticket) {
		loginTicketDao.updateStatus(ticket, 1);
	}
	
	//免密登录
	public String addLoginTicket(int userId) {
		LoginTicket loginTicket = new LoginTicket();
		loginTicket.setUserId(userId);
		Date date = new Date();
		date.setTime(date.getTime() + 1000 * 3600 * 30);
		loginTicket.setExpired(date);
		loginTicket.setStatus(0);
		loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));

		loginTicketDao.insertLoginTicket(loginTicket);

		return loginTicket.getTicket();
	}

}
