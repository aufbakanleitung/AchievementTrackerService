package com.ibm.achievement.dao.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.achievement.dao.UserDAO;
import com.ibm.achievement.dao.model.User;

@Component
public class UserManager {

	@Autowired
	private UserDAO userDAO; 


	public UserManager(){

	}

	@Transactional
	public int deleteUserData(String mailId) throws java.sql.SQLException {
		return 0;
	}

	@Transactional
	public int insertUserData (String mailId, String passwd, String activeFlg, String role)
			throws java.sql.SQLException {

		return userDAO.insertUserData(mailId, passwd, activeFlg, role);

	}

	@Transactional
	public int updateActiveFlag (String mailId, String activeFlg)
			throws java.sql.SQLException {

		return userDAO.updateActiveFlag(mailId, activeFlg);
	}

	public List<User> findAllUser() throws java.sql.SQLException {

		return userDAO.findAllUser();
	}

	public List<User> findUserByActiveFlg (String actFlg) throws java.sql.SQLException {

		return userDAO.findUserByActiveFlg(actFlg);
	}

	public User findUserByMailId (String mailId) throws java.sql.SQLException {
		
		return userDAO.findUserByMailId(mailId);
}

}
