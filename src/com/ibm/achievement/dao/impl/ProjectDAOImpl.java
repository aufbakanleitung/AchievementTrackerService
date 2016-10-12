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
            throws java.sql.SQLException{return null;}
	
	public java.util.List<Project> findProjectByEmpId(java.lang.String empId)
            throws java.sql.SQLException{return null;}
	
	public int insertEmpProject(java.lang.String projectId,
            java.lang.String employeeId)
     throws java.sql.SQLException{return 0;}
	
	public Project findProjectById(java.lang.String projectId)
            throws java.sql.SQLException{return null;}
}
