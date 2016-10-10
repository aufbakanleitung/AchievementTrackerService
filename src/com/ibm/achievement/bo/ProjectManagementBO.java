package com.ibm.achievement.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.achievement.dao.manager.ProjectManager;
import com.ibm.achievement.dao.model.Project;
import com.ibm.achievement.dao.util.AchievementListeners;
import com.ibm.achievement.entity.ProjectVO;
import com.ibm.achievement.exception.AchievementTrackerException;
import com.ibm.achievement.util.AchievementConstants;

@Service
public class ProjectManagementBO {

	@Autowired
	private AchievementListeners achievementListeners;

	private Logger logger = Logger.getLogger(ProjectManagementBO.class);

	/**
	 * This method is used to retrieve list of project.
	 * 
	 * @return Map
	 * @throws AchievementTrackerException
	 */
	public List<ProjectVO> findProjects() throws AchievementTrackerException {
		
		logger.info("START findProjects");
		List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();
		try {
			ProjectManager projectManager = achievementListeners.getProjectManager();
			List<Project> projList = projectManager.findAllProject();
			projectVOs = copyListObject(projList, projectVOs);
		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		logger.info("END findProjects");
		
		return projectVOs;
	}

	/**
	 * 
	 * @param projList
	 * @param projectVOs
	 * @return
	 */
	private List<ProjectVO> copyListObject(List<Project> projList, List<ProjectVO> projectVOs) {
		
		logger.info("START copyListObject");
		for (Project proj : projList) {
			ProjectVO projVo = new ProjectVO();
			projVo.setProjectID(proj.getProjectID());
			projVo.setProjectName(proj.getProjectName());
			projVo.setManagerID(proj.getManagerID());
			projectVOs.add(projVo);
		}
		logger.info("END copyListObject");
		
		return projectVOs;
	}

	/**
	 * This method is used to retrieve list of project of an Employee.
	 * 
	 * @return List
	 * @throws AchievementTrackerException
	 */
	public List<ProjectVO> findEmployeeProjects(String employeeId) throws AchievementTrackerException {
		
		logger.info("START findEmployeeProjects");
		List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();
		try {
			ProjectManager projectManager = achievementListeners.getProjectManager();
			if (employeeId != null && employeeId.equals("")) {
				throw new AchievementTrackerException(AchievementConstants.EMPLOYEE_ID_IS_BLANK);
			}
			List<Project> projList = projectManager.findProjectByEmpId(employeeId);
			projectVOs = copyListObject(projList, projectVOs);
			
		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		logger.info("END findEmployeeProjects");
		
		return projectVOs;
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 * @throws AchievementTrackerException
	 */
	public ProjectVO findProjectById(String projectId) throws AchievementTrackerException{
		
		logger.info("START findProjects");
		ProjectVO projectVO = new ProjectVO();
		try {
			ProjectManager projectManager = achievementListeners.getProjectManager();
			Project project = projectManager.findProjectById(projectId);
			BeanUtils.copyProperties(projectVO, project);
		} catch (Exception ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		logger.info("END findProjects");
		
		return projectVO;
	}
}