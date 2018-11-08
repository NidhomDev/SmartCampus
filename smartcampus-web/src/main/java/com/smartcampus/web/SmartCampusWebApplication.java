package com.smartcampus.web;

import org.springframework.boot.SpringApplication;
import com.smartcampus.controller.SimpleController;

/**
 * Web 程序启动类
 * @author guohk
 *
 */
public class SmartCampusWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleController.class, args);
	}

}
