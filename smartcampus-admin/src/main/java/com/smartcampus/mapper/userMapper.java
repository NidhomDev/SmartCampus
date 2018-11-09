package com.smartcampus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.smartcampus.entity.User;

@Mapper
@Component
public interface  userMapper {
	
	//用户登录
    User userlogin(@Param("username") String username,@Param("password") String password);
 
    //注册新用户(方式1)
    int adduser(@Param("username") String username, @Param("password") String password, @Param("role") String role);
 
    //注册新用户（方式2）
    int adduser1(@Param("username") String username, @Param("password") String password, @Param("role") String role);

}
