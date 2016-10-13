package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.EmployeeDAO;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;
import com.ibm.achievement.dao.model.User;

@Component
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired JdbcTemplate template;
	
	public java.util.List<Employee> findByManagerFlag()
            throws java.sql.SQLException{return null;}
	
	public Employee findEmployeeByMailId(java.lang.String mailId)
			throws java.sql.SQLException{
		return template.queryForObject("select * from TA_EMPLOYEE_DETAIL where EMAIL_ADDRESS = ?",
				new EmployeeMapper(),
				mailId);
	}
	
	public java.util.List<Employee> findAllEmployee()
            throws java.sql.SQLException{
		
		return template.query("select * from TA_EMPLOYEE_DETAIL", new EmployeeMapper());
		
	
	}
	
	public java.util.List<EmployeeUserProject> findEmployeeByActiveFlg(java.lang.String actFlg){return null;}
	
	public java.util.List<Project> findProjectByEmpId(java.lang.String empId)
            throws java.sql.SQLException{return null;}
	
	public int updateEmployeeData(java.lang.String empId,
            java.lang.String mailId,
            java.lang.String firstNm,
            java.lang.String lastNm,
            java.lang.String managerId,
            java.lang.String managerFlg)
     throws java.sql.SQLException{return 0;}
	
	public int insertEmployeeData(java.lang.String empId,
            java.lang.String mailId,
            java.lang.String firstNm,
            java.lang.String lastNm,
            java.lang.String managerId,
            java.lang.String managerFlg)
     throws java.sql.SQLException{return 0;}
	
	public int deleteEmployeeData(java.lang.String empId)
            throws java.sql.SQLException{return 0;}
	
	public Employee findEmployeeById(java.lang.String empId)
            throws java.sql.SQLException{return null;}
	
	public java.util.List<Employee> findEmployees(java.lang.String emailID,
            java.lang.String firstName,
            java.lang.String lastName,
            java.lang.String managerFlag)
     throws java.sql.SQLException{return null;}
	
	
}
