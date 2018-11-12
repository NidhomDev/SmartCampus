package com.smartcampus.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Admin 程序启动类
 * @title SmartCampusAdminApplication.java
 * @author guohk
 * @version v1.0
 * @date 2018年11月10日 上午1:23:07
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.smartcampus.admin")
@MapperScan("com.smartcampus.admin.mapper")
public class SmartCampusAdminApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SmartCampusAdminApplication.class, args);
	}
}
