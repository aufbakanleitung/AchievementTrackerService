package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.UserDAO;
import com.ibm.achievement.dao.model.User;

@Component
public class UserDAOImpl implements UserDAO{	
	@Autowired 
	JdbcTemplate template;


	public User findUserByMailId(java.lang.String mailId)
			throws java.sql.SQLException{
		return template.queryForObject("select * from TA_USERS where EMAIL_ADDRESS = ?",
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int num) throws SQLException {
						User user = new User();
						user.setActivFlg(rs.getString("ACTIVE_FLAG"));
						user.setEmailId(rs.getString("EMAIL_ADDRESS"));
						user.setPasswd(rs.getString("PASSWORD"));
						user.setRole(rs.getString("USER_ROLE"));
						return user;
					}
			
		},
				mailId);
		}
			

	public java.util.List<User> findUserByActiveFlg(java.lang.String actFlg)
			throws java.sql.SQLException{return null;}

	public java.util.List<User> findAllUser()
			throws java.sql.SQLException{return null;}

	public int updateActiveFlag(java.lang.String mailId,
			java.lang.String activeFlg)
					throws java.sql.SQLException{return 0;}

	public int insertUserData(java.lang.String mailId,
            java.lang.String passwd,
            java.lang.String activeFlg,
            java.lang.String role)
     throws java.sql.SQLException{return 0;}

	@Override
	public int deleteUserData(String mailId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
