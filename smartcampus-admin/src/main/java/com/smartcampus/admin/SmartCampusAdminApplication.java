package com.smartcampus.admin;

import org.springframework.boot.SpringApplication;
import com.smartcampus.controller.SampleController;

/**
 * Admin 程序启动类
 * @author guohk
 *
 */

public class SmartCampusAdminApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}
