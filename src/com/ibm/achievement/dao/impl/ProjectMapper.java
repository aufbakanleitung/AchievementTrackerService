package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.Project;

public class ProjectMapper implements RowMapper<Project> {
	
	@Override
	public Project mapRow(ResultSet rs, int num) throws SQLException {
		Project project = new Project();
		project.setManagerID(rs.getString("MANAGER_ID"));
		project.setProjectID(rs.getString("PROJECT_ID"));
		project.setProjectName(rs.getString("PROJECT_NAME"));

		return project;
	}

}
