package com.ibm.achievement.dao;

public interface EmployeeDAO {

	List<Employee> findByManagerFlag()
            throws java.sql.SQLException;
	
	Employee findEmployeeByMailId(java.lang.String mailId)
            throws java.sql.SQLException;
	
	Employee findEmployeeById(java.lang.String empId)
            throws java.sql.SQLException;
	
	List<Employee> findAllEmployee()
            throws java.sql.SQLException;
	
	int updateEmployeeData(java.lang.String empId,
            java.lang.String mailId,
            java.lang.String firstNm,
            java.lang.String lastNm,
            java.lang.String managerId,
            java.lang.String managerFlg)
            throws java.sql.SQLException;
	
	int insertEmployeeData(java.lang.String empId,
            java.lang.String mailId,
            java.lang.String firstNm,
            java.lang.String lastNm,
            java.lang.String managerId,
            java.lang.String managerFlg)
            throws java.sql.SQLException;
	
	int deleteEmployeeData(java.lang.String empId)
            throws java.sql.SQLException;
	
	List<EmployeeUserProject> findEmployeeByActiveFlg(java.lang.String actFlg)
            throws java.sql.SQLException;
	
	List<Project> findProjectByEmpId(java.lang.String empId)
            throws java.sql.SQLException;
	
	List<Employee> findEmployees(java.lang.String emailID,
            java.lang.String firstName,
            java.lang.String lastName,
            java.lang.String managerFlag)
            throws java.sql.SQLException
}
