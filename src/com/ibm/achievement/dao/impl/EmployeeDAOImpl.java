package com.ibm.achievement.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ibm.achievement.bo.UserManagementBO;
import com.ibm.achievement.dao.EmployeeDAO;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;

@Component
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired JdbcTemplate template;
	
	private Logger logger = Logger.getLogger(EmployeeDAOImpl.class);
	
	public List<Employee> findByManagerFlag() throws SQLException{
		return template.query("select * from TA_EMPLOYEE_DETAIL where MANAGER_FLAG = Y", new EmployeeMapper());
		}
	
	public Employee findEmployeeByMailId(String mailId)
			throws SQLException{
		try{
		return template.queryForObject("select * from TA_EMPLOYEE_DETAIL where EMAIL_ADDRESS = ?",
				new EmployeeMapper(),
				mailId);
	}catch(IncorrectResultSizeDataAccessException e) {
		logger.error("the  findEmployeeByMailId IncorrectResultSizeDataAccessException");
		return null;
	}
		
	}
	
	public List<Employee> findAllEmployee()
            throws SQLException{
		return template.query("select * from TA_EMPLOYEE_DETAIL", new EmployeeMapper());
	}
	
	public List<EmployeeUserProject> findEmployeeByActiveFlg(String actFlg) throws SQLException{
			return template.query("select * from TA_USERS tu JOIN TA_EMPLOYEE_DETAIL te on tu.EMAIL_ADDRESS = te.EMAIL_ADDRESS where tu.ACTIVE_FLAG = ?", new EmployeeUserProjectMapper(), actFlg);
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
            throws SQLException{
		try {
		return template.queryForObject("select * from TA_EMPLOYEE_DETAIL where EMPLOYEE_ID = ?",
				new EmployeeMapper(),
				empId);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
//	TODO: Check if this SQL statement makes any sense. -Herman
	public List<Employee> findEmployees(String emailID,
            String firstName,
            String lastName,
            String managerFlag)
     throws SQLException{
		logger.info("emailId:"+emailID + "|first:"+ firstName + "|last:"+ lastName + "|manager:"+managerFlag);
		return template.query("select * from TA_EMPLOYEE_DETAIL where (EMAIL_ADDRESS = ? OR FIRST_NAME = ? OR LAST_NAME = ?) AND MANAGER_FLAG =?",
				new EmployeeMapper(),
				emailID, firstName, lastName, managerFlag);
		}
	
	
}
