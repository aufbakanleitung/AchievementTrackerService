package com.ibm.achievement.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ibm.achievement.bo.ProjectManagementBO;
import com.ibm.achievement.entity.ProjectVO;
import com.ibm.achievement.exception.AchievementTrackerException;

/**
 * ProjectManagement class provide operations like find project by project id,
 * find all projects of a employee or find all project available. All methods are exposed as web services
 * 
 * @author use@in.ibm.com
 * @version 1.0
 * @since   2015-03-31 
 */
@WebService(name = "ProjectManagement", targetNamespace = "http://service.achievement.ibm.com/")
public class ProjectManagement extends SpringBeanAutowiringSupport{

	@Autowired
	private ProjectManagementBO projectManagementBO;
	private Logger logger = Logger.getLogger(ProjectManagement.class);

	/**
	 * Return list of project available in database
	 * 
	 * @return List of project
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public List<ProjectVO> findProjects() throws AchievementTrackerException{
		logger.info("START findProjects");
		List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();
		try {
			projectVOs = projectManagementBO.findProjects();
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findProjects");
		return projectVOs;
	}
	
	/**
	 * Return list of project a employee involved
	 * 
	 * @param employeeId employee id
	 * @return list of project
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public List<ProjectVO> findEmployeeProjects(@WebParam(name = "employeeId") String employeeId) throws AchievementTrackerException{
		logger.info("START findEmployeeProjects");
		List<ProjectVO> projects = new ArrayList<ProjectVO>();
		try {
			projects = projectManagementBO.findEmployeeProjects(employeeId);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findEmployeeProjects");
		return projects;
	}
	
	/**
	 * Return project for a project id
	 * 
	 * @param projectId project id
	 * @return project for the id
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public ProjectVO findProjectById(@WebParam(name = "projectId") String projectId) throws AchievementTrackerException{
		logger.info("START findEmployeeProjects");
		ProjectVO project = new ProjectVO();
		try {
			project = projectManagementBO.findProjectById(projectId);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findEmployeeProjects");
		return project;
	}
}
