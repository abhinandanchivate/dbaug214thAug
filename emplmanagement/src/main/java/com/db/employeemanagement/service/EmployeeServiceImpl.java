package com.db.employeemanagement.service;

import java.util.List;

import com.db.employeemanagement.dto.Employee;
import com.db.employeemanagement.repository.EmployeeRepository;
import com.db.employeemanagement.repository.EmployeeRepositoryImpl;
import com.db.employeemanagement.repository.EmployeeRepositoryMySQLImpl;


public class EmployeeServiceImpl implements EmployeeService {

private 	EmployeeRepository employeeRepository = EmployeeRepositoryMySQLImpl.getInstance();
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.addEmployee(employee);
	}

	@Override
	public String updateEmployee(String empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(String empId) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeById(empId);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepository.getEmployees();
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		return this.deleteEmployeeById(id);
	}

	@Override
	public String deleteAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepository.deleteAllEmployees();
	}

}
