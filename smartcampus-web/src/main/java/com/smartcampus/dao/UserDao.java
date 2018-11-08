package com.smartcampus.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.smartcampus.entity.User;

/**
 * 
 * @title UserDao.java
 * @author guohk
 * @version v1.0
 * @date 2018年11月9日 上午1:26:27
 */
@Mapper
public interface UserDao {
	String TABLE_NAME = "user";
	String INSERT_FIELDS = "name, password, salt, head_url, role";
	String SELECT_FIELDS = "id," + INSERT_FIELDS;

	@Insert({ "insert into", TABLE_NAME, "(", INSERT_FIELDS,
			") values (#{name},#{password},#{salt},#{headUrl},#{role})" })
	public void insertUser(User user);

	@Select({ "select", SELECT_FIELDS, "from", TABLE_NAME, "where id=#{id}" })
	public User seletById(int id);

	@Select({ "select", SELECT_FIELDS, "from", TABLE_NAME, "where name=#{name}" })
	public User seletByName(@Param("name") String name);

	@Delete({ "delete from", TABLE_NAME, "where id=#{id}" })
	public void deleteById(int id);

}
