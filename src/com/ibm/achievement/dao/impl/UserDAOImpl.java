package com.ibm.achievement.dao.impl;

import com.ibm.achievement.dao.model.User;

public class UserDAOImpl {
	
	public User findUserByMailId(java.lang.String mailId)
            throws java.sql.SQLException{return null;}
	
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
}
