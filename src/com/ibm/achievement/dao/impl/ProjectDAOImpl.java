package com.ibm.achievement.dao.impl;

import com.ibm.achievement.dao.model.Project;

public class ProjectDAOImpl {
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
