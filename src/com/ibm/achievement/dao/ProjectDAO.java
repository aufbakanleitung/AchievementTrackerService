package com.ibm.achievement.dao;

import java.util.List;

public interface ProjectDAO{

	List<Project> findAllProject()
            throws java.sql.SQLException;
	
	List<Project> findProjectByEmpId(java.lang.String empId)
            throws java.sql.SQLException;
	
	int insertEmpProject(java.lang.String projectId, java.lang.String employeeId)
            throws java.sql.SQLException;
	
	Project findProjectById(java.lang.String projectId)
            throws java.sql.SQLException;

}
