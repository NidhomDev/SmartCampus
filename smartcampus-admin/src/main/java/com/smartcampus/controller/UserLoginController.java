package com.smartcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smartcampus.entity.User;
import com.smartcampus.service.UserLoginService;

@Controller
@RequestMapping(value = { "/admin" })
public class UserLoginController {

	/**
	 * 注入service
	 */
	@Autowired
	private UserLoginService userLoginService;
	
	
	private static final String list = "/smartcampus-admin/src/main/resources/templates/login.html";

	/**
	 * 跳转到用户登录页面
	 * 
	 * @return 登录页面
	 */
	@RequestMapping(value = { "/login" })
	public String login() {
		return list;
	}

	/**
	 * 跳转到用户注册页面
	 * 
	 * @return 注册页面
	 */
	@RequestMapping(value = { "/register" })
	public String register() {
		return "register";
	}

	/**
	 * 获取用户名与密码，用户登录
	 * 
	 * @return 登录成功页面
	 */
	@RequestMapping(value = { "/userLogin" })
	public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request) {

		User user = userLoginService.userLogin(username, password);

		if (user != null) { // 登录成功
			request.getSession().setAttribute("session_user", user); // 将用户信息放入session
			return "index";
		}
		return "page_404";
	}

	/**
	 * 注册新用户
	 * 
	 * @return 注册结果
	 */
	@ResponseBody
	@RequestMapping(value = { "/uregister" })
	public String addUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("password2") String password2, @RequestParam("role") String role) {

		if (!password.equals(password2)) {

			return "两次密码不相同，注册失败！！";
		} else {
			int res = userLoginService.adduser(username, password, role);
			if (res == 0) {
				return "注册失败！";
			} else {
				return "注册成功！";
			}
		}

	}

}
