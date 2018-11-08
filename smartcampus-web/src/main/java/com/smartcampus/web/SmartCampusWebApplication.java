package com.smartcampus.web;

import org.springframework.boot.SpringApplication;
import com.smartcampus.controller.SimpleController;

/**
 * Web 程序启动类
 * @title SmartCampusWebApplication.java
 * @author guohk
 * @version v1.0
 * @date 2018年11月9日 上午1:23:34
 */
public class SmartCampusWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleController.class, args);
	}

}
