package com.ibm.achievement.dao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.manager.AchievementManager;
import com.ibm.achievement.dao.manager.EmployeeManager;
import com.ibm.achievement.dao.manager.ProjectManager;
import com.ibm.achievement.dao.manager.UserManager;

public class AchievementListeners {

	@Autowired
	private AchievementManager achievementManager;
	@Autowired
	private EmployeeManager employeeManager;
	@Autowired
	private ProjectManager projectManager;
	@Autowired
	private UserManager userManager;
	
	
	public AchievementManager getAchievementManager() {
		return achievementManager;
	}
	
	public EmployeeManager getEmployeeManager() {
		return employeeManager;
	}
	
	public ProjectManager getProjectManager() {
		return projectManager;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
	
	
	
	

	

}
