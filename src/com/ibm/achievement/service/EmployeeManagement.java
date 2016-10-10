package com.ibm.achievement.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ibm.achievement.bo.EmployeeManagementBO;
import com.ibm.achievement.entity.EmployeeVO;
import com.ibm.achievement.exception.AchievementTrackerException;

/**
 * EmployeeManagement class provide operations like find employee by employee id,
 * find employee by manager id or find employee by email address. 
 * All methods are exposed as web services
 * 
 * @author use@in.ibm.com
 * @version 1.0
 * @since   2015-03-31 
 */
@WebService(name = "EmployeeManagement", targetNamespace = "http://service.achievement.ibm.com/")
public class EmployeeManagement extends SpringBeanAutowiringSupport{

	@Autowired
	private EmployeeManagementBO employeeManagementBO;
	private Logger logger = Logger.getLogger(EmployeeManagement.class);

	/**
	 * Return list of employee having manager flag Y i.e who is a manager as well
	 * 
	 * @return List of EmployeeVO
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public List<EmployeeVO> findEmployeesByManagerFlag()
			throws AchievementTrackerException {
		logger.info("START findEmployeesByManagerFlag");
		List<EmployeeVO> employeeVOs = new ArrayList<EmployeeVO>();
		try {
			employeeVOs = employeeManagementBO.findEmployeesByManagerFlag();
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findEmployeesByManagerFlag");
		return employeeVOs;
	}

	/**
	 * Return employee for a employee matching with employee email address
	 * 
	 * @param emailID employee email address
	 * @return EmployeeVO employee details value object
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public EmployeeVO findEmployeesByEmailID(
			@WebParam(name = "emailID") String emailID)
			throws AchievementTrackerException {
		logger.info("START findEmployeesByEmailID");
		EmployeeVO employeeVO = new EmployeeVO();
		try {
			employeeVO = employeeManagementBO.findEmployeesByEmailID(emailID);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findEmployeesByEmailID");
		return employeeVO;
	}

	/**
	 * Return employee matching with employee id.
	 * 
	 * @param emailID employee id
	 * @return EmployeeVO employee details value object
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public EmployeeVO findEmployeesByID(@WebParam(name = "empID") String empID)
			throws AchievementTrackerException {
		logger.info("START findEmployeesByID");
		EmployeeVO employeeVO = new EmployeeVO();
		try {
			employeeVO = employeeManagementBO.findEmployeesByID(empID);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findEmployeesByEmailID");
		return employeeVO;
	}

	/**
	 * Return list of employee matching with employee id or first name or 
	 * last name or manager flag
	 * 
	 * @param emailID employee id
	 * @param firstName first name
	 * @param lastName last name
	 * @param managerFlag manager flag
	 * @return List of EmployeeVO employee value object
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public List<EmployeeVO> findEmployees(
			@WebParam(name = "emailID") String emailID,
			@WebParam(name = "firstName") String firstName,
			@WebParam(name = "lastName") String lastName,
			@WebParam(name = "managerFlag") String managerFlag)
			throws AchievementTrackerException {
		logger.info("START findEmployees");
		List<EmployeeVO> employeeVOs = new ArrayList<EmployeeVO>();
		try {
			employeeVOs = employeeManagementBO.findEmployees(emailID,
					firstName, lastName, managerFlag);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findEmployees");
		return employeeVOs;
	}
}
