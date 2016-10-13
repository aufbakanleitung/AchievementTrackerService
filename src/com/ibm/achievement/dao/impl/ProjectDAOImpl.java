package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.ProjectDAO;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;
import com.ibm.achievement.dao.model.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import jdk.nashorn.internal.ir.WhileNode;

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


	public int insertEmpProject(java.lang.String projectId,
			java.lang.String employeeId)
					throws java.sql.SQLException{return 0;}

	public Project findProjectById(java.lang.String projectId)
			throws java.sql.SQLException{return null;}
}
