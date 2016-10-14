package com.ibm.achievement.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ibm.achievement.dao.ProjectDAO;
import com.ibm.achievement.dao.model.Project;

@Component
public class ProjectManager {
	
	@Autowired
	JdbcTemplate template;
	
	@Autowired
	private ProjectDAO projectDAO;
	
	public ProjectManager(){
		
	}

	public List<Project> findAllProject() throws java.sql.SQLException{
		
		return projectDAO.findAllProject();
	}
	
	public List<Project> findProjectByEmpId (String empId)
			throws java.sql.SQLException{
		return projectDAO.findProjectByEmpId(empId);
	}
	
	public int insertEmpProject (String projectId, String employeeId) throws java.sql.SQLException {
		
		return projectDAO.insertEmpProject(projectId, employeeId);
	}
	
	public Project findProjectById (String projectId) throws java.sql.SQLException {
		
		return projectDAO.findProjectById(projectId);
	}
	
}
