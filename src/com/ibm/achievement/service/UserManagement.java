package com.ibm.achievement.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ibm.achievement.bo.UserManagementBO;
import com.ibm.achievement.entity.EmployeeVO;
import com.ibm.achievement.exception.AchievementTrackerException;

/**
 * The UserManagement class provide services like user validation,
 * user registration , retrieve user data. All methods are exposed as web services 
 * 
 * @author use@in.ibm.com
 * @version 1.0
 * @since   2015-03-31 
 */
@WebService(name = "UserManagement", targetNamespace = "http://service.achievement.ibm.com/")
public class UserManagement extends SpringBeanAutowiringSupport {

	@Autowired
	private UserManagementBO userManagementBO;

	private Logger logger = Logger.getLogger(UserManagement.class);

	/**
	 * This method is used to validate user for login and return the user
	 * roll. If user roll is null that means user in not valid.
	 * 
	 * @param emailAddress (required) user email address 
	 * @param password (required) user password, length must have to be between 8 to 12
	 * @return String if user registered return user role
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public EmployeeVO isValidUser(@WebParam(name = "emailId") String emailId,
			@WebParam(name = "password") String password)
			throws AchievementTrackerException {
		logger.info("START isValidUser");
		EmployeeVO employeeVO = new EmployeeVO();
		try {
			employeeVO = userManagementBO.isValidUser(emailId, password);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END isValidUser");
		return employeeVO;
	}

	/**
	 * This method is called to register new user, if registration operation successful
	 * return true or return false
	 * 
	 * @param employeeVO details information of user, project etc 
	 * @param password user password
	 * @return after successful registration return true else false
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public boolean registerUser(
			@WebParam(name = "employeeVO") EmployeeVO employeeVO,
			@WebParam(name = "password") String password)
			throws AchievementTrackerException {
		logger.info("START registerUser");

		boolean status = false;
		try {
			status = userManagementBO.registerUser(employeeVO, password);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END registerUser");
		return status;
	}

	/**
	 * This method is used to find user having active flag Y and return the list
	 * 
	 * @param activeFlag active flag Y or inactive flag N
	 * @return list of EmployeeVO List of active user
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public List<EmployeeVO> findUserByActiveFlag(
			@WebParam(name = "activeFlag") String activeFlag)
			throws AchievementTrackerException {
		logger.info("START findUserByActiveFlag");
		List<EmployeeVO> employeeVOs = new ArrayList<EmployeeVO>();
		try {
			employeeVOs = userManagementBO.findUserByActiveFlag(activeFlag);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findUserByActiveFlag");
		return employeeVOs;
	}

	/**
	 * Return true if user active flag update successful or return false
	 * 
	 * @param activeFlag if approved Y or N
	 * @param emailId user mail address
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public boolean updateUserActiveFlag(
			@WebParam(name = "activeFlag") String activeFlag,
			@WebParam(name = "emailId") String emailId)
			throws AchievementTrackerException {
		logger.info("START updateUserActiveFlag");
		boolean status = false;
		try {
			status = userManagementBO.updateUserActiveFlag(activeFlag, emailId);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END updateUserActiveFlag");
		return status;
	}

}
