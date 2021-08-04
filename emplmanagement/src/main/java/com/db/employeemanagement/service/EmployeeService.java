package com.db.employeemanagement.service;

import java.util.List;

import com.db.employeemanagement.dto.Employee;

public interface EmployeeService {

	public String addEmployee(Employee employee); // adding a new Employee
	public String updateEmployee(String empId, Employee employee); 
	// to update emp info based on empid
	
	public Employee getEmployeeById(String empId);
	// should provide the employee details based on empId
	public List<Employee> getEmployees();
	// should return all Employee Details. in terms of List.
	public String deleteEmployeeById(String id);
	public String deleteAllEmployees();
	
}
