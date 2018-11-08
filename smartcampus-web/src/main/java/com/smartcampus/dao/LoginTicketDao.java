package com.smartcampus.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smartcampus.entity.LoginTicket;

/**
 * 
 * @title LoginTicketDao.java
 * @author guohk
 * @version v1.0
 * @date 2018年11月9日 上午1:26:40
 */
@Mapper
public interface LoginTicketDao {
	String TABLE_NAME = "login_ticket";
	String INSERT_FIELDS = "user_id, ticket, expired, status";
	String SELECT_FIELDS = "id," + INSERT_FIELDS;

	@Insert({ "insert into", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userId},#{ticket},#{expired},#{status})" })
	void insertLoginTicket(LoginTicket loginTicket);

	@Select({ "select", SELECT_FIELDS, "from", TABLE_NAME, "where id=#{id}" })
	LoginTicket seletById(int id);

	@Select({ "select", SELECT_FIELDS, "from", TABLE_NAME, "where ticket=#{ticket}" })
	LoginTicket seletByTicket(String ticket);

	@Update({ "update", TABLE_NAME, "set status = #{status} where ticket = #{ticket}" })
	void updateStatus(@Param("ticket") String ticket, @Param("status") int status);

	@Delete({ "delete from", TABLE_NAME, "where id=#{id}" })
	void deleteById(int id);

}
