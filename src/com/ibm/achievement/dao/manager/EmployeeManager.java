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
	
	@Autowired 
	JdbcTemplate template;
	
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
		try {
			
		
			return template.queryForObject("select * from TA_EMPLOYEE_DETAIL where EMAIL_ADDRESS = ?",
					new RowMapper<Employee>() {
	
				@Override
				public Employee mapRow(ResultSet rs, int num) throws SQLException {
					Employee employee = new Employee();
					employee.setEmailID(rs.getString("EMAIL_ADDRESS"));
					employee.setEmployeeId(rs.getString("EMPLOYEE_ID"));
					employee.setFirstName(rs.getString("FIRST_NAME"));
					employee.setLastName(rs.getString("LAST_NAME"));
					employee.setManagerFlag(rs.getString("MANAGER_FLAG"));
					employee.setManagerId(rs.getString("MANAGER_ID"));
					return employee;
				}
	
			},
					mailId);
		}catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
				
	public List<Employee> findAllEmployee() throws SQLException{
		return null;
	}
	public List<EmployeeUserProject> findEmployeeByActiveFlg(String actFlg)
			throws java.sql.SQLException{
		try {

			return template.queryForObject("select * from TA_EMPLOYEE_PROJECT where EMPLOYEE_ID in (select EMPLOYEE_ID from TA_EMPLOYEE_DETAIL where EMAIL_ADDRESS in (select EMAIL_ADDRESS from TA_USERS where ACTIVE_FLAG = ?))", new EmployeeMapper(), actFlg);

		}catch (IncorrectResultSizeDataAccessException e) {

		}
	}

	public List<Project> findProjectByEmpId(String empId) throws SQLException{
		return null;
	}
	public Employee findEmployeeById(String empId) throws SQLException{
		return null;
	}
	public int updateEmployeeData(String empId, String mailId, String firstNm, String lastNm, String managerId, String managerFlg) throws SQLException{
		return 0;
	}
	public int insertEmployeeData(String empId, String mailId, String firstNm, String lastNm, String managerId, String managerFlg) throws SQLException{
		return 0;
	}
	public int deleteEmployeeData(String empId){
		return 0;
	}
	public List<Employee> findEmployees(String emailID,
            String firstName,
            String lastName,
            String managerFlag)
     throws SQLException{
		return null;
	}
	
}
