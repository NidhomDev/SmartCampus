package com.smartcampus.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SimpleController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}
}
