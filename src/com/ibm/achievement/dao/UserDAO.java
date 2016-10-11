package com.ibm.achievement.dao;

import java.util.List;

public interface UserDAO {

	User findUserByMailId(java.lang.String mailId)
			throws java.sql.SQLException;

	List<User> findUserByActiveFlg(java.lang.String actFlg)
			throws java.sql.SQLException;

	List<User> findAllUser()
			throws java.sql.SQLException;

	int updateActiveFlag(java.lang.String mailId, java.lang.String activeFlg)
			throws java.sql.SQLException;
	
	int insertUserData(java.lang.String mailId, java.lang.String passwd, java.lang.String activeFlg, java.lang.String role)
            throws java.sql.SQLException;
	
	int deleteUserData(java.lang.String mailId)
            throws java.sql.SQLException;
	
}
