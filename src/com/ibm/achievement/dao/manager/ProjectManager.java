package com.ibm.achievement.dao.manager;

import org.springframework.stereotype.Component;
import java.util.List;
import com.ibm.achievement.dao.model.Project;

@Component
public class ProjectManager {
	
	public ProjectManager(){
		
	}

	public List<Project> findAllProjects() throws java.sql.SQLException{
		
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
