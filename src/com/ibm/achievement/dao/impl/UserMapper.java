package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.User;

public class UserMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		User user = new User();
		user.setActivFlg(rs.getString("ACTIVE_FLAG"));
		user.setEmailId(rs.getString("EMAIL_ADDRESS"));
		user.setPasswd(rs.getString("PASSWORD"));
		user.setRole(rs.getString("USER_ROLE"));
		return user;
	}

}
