package com.ibm.achievement.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.ProjectDAO;
import com.ibm.achievement.dao.model.Project;

@Component
public class ProjectDAOImpl implements ProjectDAO{

	@Autowired JdbcTemplate template;

	public java.util.List<Project> findAllProject()
			throws java.sql.SQLException{
		return template.query("select * from TA_PROJECTS", new ProjectMapper());
	}

	public java.util.List<Project> findProjectByEmpId(java.lang.String empId)
			throws java.sql.SQLException{
		return template.query("select * from TA_PROJECTS where PROJECT_ID in (select PROJECT_ID from TA_EMPLOYEE_PROJECT where EMPLOYEE_ID = ?)",
				new ProjectMapper(),empId);
	}

	public int insertEmpProject(java.lang.String projectId,
			java.lang.String employeeId)
					throws java.sql.SQLException{return 0;}

	public Project findProjectById(java.lang.String projectId)
			throws java.sql.SQLException{
		return template.queryForObject("select * from TA_PROJECTS where projectId = ?", new ProjectMapper(),projectId)
					;}
	
}
