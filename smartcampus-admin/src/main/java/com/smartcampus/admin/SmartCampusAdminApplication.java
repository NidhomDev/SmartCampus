package com.smartcampus.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Admin 程序启动类
 * @title SmartCampusAdminApplication.java
 * @author guohk
 * @version v1.0
 * @date 2018年11月10日 上午1:23:07
 */
@SpringBootApplication
@ServletComponentScan
public class SmartCampusAdminApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SmartCampusAdminApplication.class, args);
	}
}
