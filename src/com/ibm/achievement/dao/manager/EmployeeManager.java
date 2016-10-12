package com.ibm.achievement.dao.manager;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.EmployeeDAO;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.EmployeeUserProject;
import com.ibm.achievement.dao.model.Project;

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
	public Employee findEmployeeByMailId(String mailId) throws SQLException{
		return null;
	}
	public List<Employee> findAllEmployee() throws SQLException{
		return null;
	}
	public List<EmployeeUserProject> findEmployeeByActiveFlg(String actFlg){
		return null;
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
