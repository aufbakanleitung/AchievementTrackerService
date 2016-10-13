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
		
		return null;
	}
	
	public List<Project> findProjectByEmpId (String empId)
			throws java.sql.SQLException{
		return template.query("select * from TA_PROJECTS where PROJECT_ID in (select PROJECT_ID from TA_EMPLOYEE_PROJECT where EMPLOYEE_ID = ?)",
				new RowMapper<Project>() {
			@Override
			public Project mapRow(ResultSet rs, int num) throws SQLException {
				Project project = new Project();
				project.setManagerID(rs.getString("MANAGER_ID"));
				project.setProjectID(rs.getString("PROJECT_ID"));
				project.setProjectName(rs.getString("PROJECT_NAME"));

				return project;
			}

		},
				empId);
	}
	
	public int insertEmpProject (String projectId, String employeeId) throws java.sql.SQLException {
		
		return 0;
	}
	
	public Project findProjectById (String projectId) throws java.sql.SQLException {
		
		return null;
	}
	
}
