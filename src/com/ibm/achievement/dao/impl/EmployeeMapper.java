package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int num) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(rs.getString("EMPLOYEE_ID"));
		employee.setEmailID(rs.getString("EMAIL_ADDRESS"));
		employee.setFirstName(rs.getString("FIRST_NAME"));
		employee.setLastName(rs.getString("LAST_NAME"));
		employee.setManagerId(rs.getString("MANAGER_ID"));
		employee.setManagerFlag(rs.getString("MANAGER_FLAG"));
		return employee;
	}

}
