package com.ibm.achievement.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

import com.ibm.achievement.dao.ProjectDAO;
import com.ibm.achievement.dao.model.Project;

@Component
public class ProjectManager {
	
	@Autowired
	private ProjectDAO projectDAO;
	
	public ProjectManager(){
		
	}

	public List<Project> findAllProject() throws java.sql.SQLException{
		
		return null;
	}
	
	public List<Project> findProjectByEmpId (String empId) throws java.sql.SQLException {
		
		return null;
	}
	
	public int insertEmpProject (String projectId, String employeeId) throws java.sql.SQLException {
		
		return 0;
	}
	
	public Project findProjectById (String projectId) throws java.sql.SQLException {
		
		return null;
	}
	
}
