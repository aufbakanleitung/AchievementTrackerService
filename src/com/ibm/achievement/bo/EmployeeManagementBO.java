package com.ibm.achievement.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.achievement.dao.manager.EmployeeManager;
import com.ibm.achievement.dao.manager.ProjectManager;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.Project;
import com.ibm.achievement.dao.util.AchievementListeners;
import com.ibm.achievement.entity.EmployeeVO;
import com.ibm.achievement.entity.ProjectVO;
import com.ibm.achievement.exception.AchievementTrackerException;
import com.ibm.achievement.util.AchievementConstants;

@Service
public class EmployeeManagementBO {

	@Autowired
	private AchievementListeners achievementListeners;

	private Logger logger = Logger.getLogger(EmployeeManagementBO.class);

	/**
	 * This method is used to retrieve list of manager.
	 * 
	 * @return List of EmployeeVO
	 */
	public List<EmployeeVO> findEmployeesByManagerFlag() throws AchievementTrackerException {
		
		logger.info("START findEmployeesByManagerFlag");
		List<Employee> employeeList = new ArrayList<Employee>();
		List<EmployeeVO> employeeVOs = new ArrayList<EmployeeVO>();
		try {
			EmployeeManager employeeManager = achievementListeners.getEmployeeManager();
			employeeList = employeeManager.findByManagerFlag();

			for (Employee employee : employeeList) {
				EmployeeVO employeeVO = new EmployeeVO();
				CopyObject(employeeVO, employee);
				employeeVOs.add(employeeVO);
			}

		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		logger.info("END findEmployeesByManagerFlag");
		
		return employeeVOs;
	}

	/**
	 * This method is used to retrieve employee by emailId.
	 * 
	 * @param emailID
	 * @return EmployeeVO
	 */
	public EmployeeVO findEmployeesByEmailID(String emailId) throws AchievementTrackerException {
		
		logger.info("START findEmployeesByEmailID");
		if (emailId == null || emailId.equals("")) {
			throw new AchievementTrackerException(AchievementConstants.EMAIL_ID_IS_BLANK);
		}
		EmployeeVO employeeVO = new EmployeeVO();
		try {
			EmployeeManager employeeManager = achievementListeners.getEmployeeManager();
			Employee employee = employeeManager.findEmployeeByMailId(emailId);
			CopyObject(employeeVO, employee);
			
		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		logger.info("END findEmployeesByEmailID");
		
		return employeeVO;
	}

	/**
	 * This method is used to retrieve employee by emailId.
	 * 
	 * @param emailID
	 * @return EmployeeVO
	 */
	public EmployeeVO findEmployeesByID(String empId) throws AchievementTrackerException {
		
		logger.info("START findEmployeesByID");
		if (empId == null || empId.equals("")) {
			throw new AchievementTrackerException(AchievementConstants.EMPLOYEE_ID_IS_BLANK);
		}
		EmployeeVO employeeVO = new EmployeeVO();
		try {
			EmployeeManager employeeManager = achievementListeners.getEmployeeManager();
			Employee employee = employeeManager.findEmployeeById(empId);
			CopyObject(employeeVO, employee);
			
		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		logger.info("END findEmployeesByID");
		
		return employeeVO;
	}

	/**
	 * Copy data from Employee to EmployeeVO
	 * 
	 * @param employeeVO
	 * @param employee
	 * @throws SQLException
	 */
	private void CopyObject(EmployeeVO employeeVO, Employee employee) throws SQLException {
		
		logger.info("START CopyObject");
		employeeVO.setEmployeeId(employee.getEmployeeId());
		employeeVO.setEmailID(employee.getEmailID());
		employeeVO.setFirstName(employee.getFirstName());
		employeeVO.setLastName(employee.getLastName());
		employeeVO.setManagerId(employee.getManagerId());
		employeeVO.setManagerFlag(employee.getManagerFlag());

		ProjectManager projectManager = achievementListeners.getProjectManager();
		List<Project> projList = projectManager.findProjectByEmpId(employee.getEmployeeId());
		List<ProjectVO> projects = new ArrayList<ProjectVO>();
		for (Project project : projList) {
			ProjectVO projectVO = new ProjectVO();
			BeanUtils.copyProperties(project, projectVO);
			projects.add(projectVO);
		}

		employeeVO.setProjects(projects);
		logger.info("END CopyObject");
	}

	/**
	 * Retrieve Active employee for the find criteria
	 * 
	 * @param emailID
	 * @param firstName
	 * @param lastName
	 * @param managerFlag
	 * @return List of EmployeeVO
	 * @throws AchievementTrackerException
	 */
	public List<EmployeeVO> findEmployees(String emailID, String firstName, String lastName, String managerFlag) throws AchievementTrackerException {
		
		logger.info("START findEmployees");
		List<Employee> employeeList = new ArrayList<Employee>();
		List<EmployeeVO> employeeVOs = new ArrayList<EmployeeVO>();
		try {
			EmployeeManager employeeManager = achievementListeners.getEmployeeManager();
			employeeList = employeeManager.findEmployees(emailID, firstName, lastName, managerFlag);

			for (Employee employee : employeeList) {
				EmployeeVO employeeVO = new EmployeeVO();
				CopyObject(employeeVO, employee);
				employeeVOs.add(employeeVO);
			}

		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		logger.info("END findEmployees");
		
		return employeeVOs;
	}
}
