package com.smartcampus.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcampus.service.UserService;

/**
 * 登录、注册、注销
 * @title LoginController.java
 * @author guohk
 * @version v1.0
 * @date 2018年11月9日 上午1:23:03
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String register(Model model, HttpServletResponse httpResponse, @RequestParam String username,
			@RequestParam String password, @RequestParam(value = "next", required = false) String next) {
		Map<String, String> map = userService.register(username, password);
		if (map.containsKey("ticket")) {
			Cookie cookie = new Cookie("ticket", map.get("ticket"));
			cookie.setPath("/");
			httpResponse.addCookie(cookie);

			if (StringUtils.isNotBlank(next))
				return "redirect:" + next;
			else
				return "redirect:/";
		} else {
			model.addAttribute("msg", map.get("msg"));
			return "login";
		}
	}

	@RequestMapping("/login")
	public String login(Model model, HttpServletResponse httpResponse, @RequestParam String username,
			@RequestParam String password, @RequestParam(value = "next", required = false) String next) {
		Map<String, String> map = userService.login(username, password);
		if (map.containsKey("ticket")) {
			Cookie cookie = new Cookie("ticket", map.get("ticket"));
			cookie.setPath("/");
			httpResponse.addCookie(cookie);

			if (StringUtils.isNotBlank(next)) {
				return "redirect:" + next;
			}

			return "redirect:/";
		} else {
			model.addAttribute("msg", map.get("msg"));
			return "login";
		}
	}

	@RequestMapping("/logout")
	public String logout(@CookieValue("ticket") String ticket) {
		userService.logout(ticket);
		return "redirect:/";
	}

}
