package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;
import com.ibm.achievement.dao.model.User;

public class EmployeeUserProjectMapper implements RowMapper<EmployeeUserProject> {


	@Override
	public EmployeeUserProject mapRow(ResultSet rs, int num) throws SQLException {
		User user = new UserMapper().mapRow(rs, num);
		Employee employee = new EmployeeMapper().mapRow(rs, num);
		EmployeeUserProject employeeUserProject = new EmployeeUserProject();
		employeeUserProject.setActiveFlag(user.getActivFlg());
		employeeUserProject.setEmailID(user.getEmailId());
		employeeUserProject.setUserRoll(user.getRole());
		employeeUserProject.setEmployeeId(employee.getEmployeeId());
		employeeUserProject.setFirstName(employee.getFirstName());
		employeeUserProject.setLastName(employee.getLastName());
		employeeUserProject.setManagerFlag(employee.getManagerFlag());
		employeeUserProject.setManagerId(employee.getManagerId());
				
		return employeeUserProject;
	}

}
