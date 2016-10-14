package com.ibm.achievement.dao.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.EmployeeDAO;
import com.ibm.achievement.dao.impl.EmployeeMapper;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;
import com.ibm.achievement.dao.model.User;

@Component
public class EmployeeManager {
	
	@Autowired EmployeeDAO employeeDAO;
	String mailId;
	String actFlg;
	String empId;
    String firstNm;
    String lastNm;
    String managerId;
    String managerFlg;	
	
	public List<Employee> findByManagerFlag() throws SQLException{
		return null;
	}
	public Employee findEmployeeByMailId(String mailId)
			throws java.sql.SQLException{
		return employeeDAO.findEmployeeByMailId(mailId);
	}
				
	public List<Employee> findAllEmployee() throws SQLException{
		return employeeDAO.findAllEmployee();
	}
	public List<EmployeeUserProject> findEmployeeByActiveFlg(String actFlg)

		throws java.sql.SQLException{
		return employeeDAO.findEmployeeByActiveFlg(actFlg);
	}

	public Employee findEmployeeById(String empId) throws SQLException{
		return employeeDAO.findEmployeeById(empId);
	}
	public int updateEmployeeData(String empId, String mailId, String firstNm, String lastNm, String managerId, String managerFlg) throws SQLException{
		return employeeDAO.updateEmployeeData(empId, mailId, firstNm, lastNm, managerId, managerFlg);
	}
	public int insertEmployeeData(String empId, String mailId, String firstNm, String lastNm, String managerId, String managerFlg) throws SQLException{
		return employeeDAO.insertEmployeeData(empId, mailId, firstNm, lastNm, managerId, managerFlg);
	}
	public int deleteEmployeeData(String empId) throws SQLException{
		return employeeDAO.deleteEmployeeData(empId);
	}
	public List<Employee> findEmployees(String emailID,
            String firstName,
            String lastName,
            String managerFlag)
     throws SQLException{
		return employeeDAO.findEmployees(emailID, firstName, lastName, managerFlag);
	}
	
}
