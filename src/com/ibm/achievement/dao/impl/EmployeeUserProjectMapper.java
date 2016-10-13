package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.User;

public class EmployeeUserProjectMapper implements RowMapper<EmployeeUserProject> {


	@Override
	public EmployeeUserProject mapRow(ResultSet rs, int num) throws SQLException {
		User user = new UserMapper().mapRow(rs, num);
		Employee employee = new EmployeeMapper().mapRow(rs, num);
		EmployeeUserProject employeeUserProject = new EmployeeUserProject();
		employeeUserProject.setActiveFlag(user.getActivFlg());
		return employeeUserProject;
	}

}
