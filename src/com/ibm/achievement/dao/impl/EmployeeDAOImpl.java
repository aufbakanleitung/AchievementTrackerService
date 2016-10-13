package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	
	public List<Employee> findByManagerFlag() throws SQLException{
		return template.query("select * from TA_EMPLOYEE_DETAIL where MANAGER_FLAG = Y", new EmployeeMapper());
		}
	
	public Employee findEmployeeByMailId(String mailId)
			throws SQLException{
		return template.queryForObject("select * from TA_EMPLOYEE_DETAIL where EMAIL_ADDRESS = ?",
				new EmployeeMapper(),
				mailId);
	}
	
	public List<Employee> findAllEmployee()
            throws SQLException{
		
		return template.query("select * from TA_EMPLOYEE_DETAIL", new EmployeeMapper());
	}
	
	public List<EmployeeUserProject> findEmployeeByActiveFlg(String actFlg) throws SQLException{
			return template.query("select * from TA_USERS tu JOIN TA_EMPLOYEE_DETAIL te on tu.EMAIL_ADDRESS = te.EMAIL_ADDRESS where tu.ACTIVE_FLAG = ?", new EmployeeUserProjectMapper(), actFlg);
		}
	
	public List<Project> findProjectByEmpId(String empId)
            throws SQLException{
		return template.query("select * from TA_PROJECTS where PROJECT_ID in (select PROJECT_ID from TA_EMPLOYEE_PROJECT where EMPLOYEE_ID = ?)",
				new ProjectMapper(), empId);	
	}
	
	public int updateEmployeeData(java.lang.String empId,
            java.lang.String mailId,
            java.lang.String firstNm,
            java.lang.String lastNm,
            java.lang.String managerId,
            java.lang.String managerFlg)
     throws java.sql.SQLException{
		return template.update("UPDATE TA_EMPLOYEE_DETAIL "
				+ "(`EMPLOYEE_ID`, `EMAIL_ADDRESS`, `FIRST_NAME`, `LAST_NAME`, `MANAGER_ID`, `MANAGER_FLAG`) "
				+ "VALUES (?,?,?,?,?,?)",
				empId, mailId, firstNm,lastNm, managerId, managerFlg);
		}
	
	public int insertEmployeeData(java.lang.String empId,
            java.lang.String mailId,
            java.lang.String firstNm,
            java.lang.String lastNm,
            java.lang.String managerId,
            java.lang.String managerFlg)
     throws java.sql.SQLException{
		return template.update("INSERT INTO TA_EMPLOYEE_DETAIL "
				+ "(`EMPLOYEE_ID`, `EMAIL_ADDRESS`, `FIRST_NAME`, `LAST_NAME`, `MANAGER_ID`, `MANAGER_FLAG`) "
				+ "VALUES (?,?,?,?,?,?)",
				empId, mailId, firstNm,lastNm, managerId, managerFlg);
		}
	
	public int deleteEmployeeData(String empId)
            throws SQLException{return template.update("DELETE FROM EMPLOYEE_ID where EMPLOYEE_ID = ?", empId);}
	
	public Employee findEmployeeById(String empId)
            throws SQLException{return null;}
	
	public java.util.List<Employee> findEmployees(java.lang.String emailID,
            java.lang.String firstName,
            java.lang.String lastName,
            java.lang.String managerFlag)
     throws java.sql.SQLException{return null;}
	
	
}
