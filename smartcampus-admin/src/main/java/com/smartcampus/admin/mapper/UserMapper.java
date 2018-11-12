package com.smartcampus.admin.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;

import com.smartcampus.admin.entity.User;

public interface UserMapper {

	int insert(User user) throws SQLException;

	User selectByName(@Param("userName") String userName) throws SQLException;

}
