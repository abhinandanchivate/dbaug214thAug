package com.db.employeemanagement.repository;

import java.util.ArrayList;
import java.util.List;

import com.db.employeemanagement.dto.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	List<Employee>employees = new ArrayList<>();
	Employee res = null;
	boolean flag = false;
	// 10 object of employee type.
	// it will hold duplicate objects
	// self growable 
	// 

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		boolean result =employees.add(employee);
		
		if(result) 
		return "success";
		else {
			return "fail";
		}
	}

	@Override
	public String updateEmployee(String empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(String empId) {
		// TODO Auto-generated method stub
		// lambda expressions are used to reduce complexity of writing the functions
		// 
	
//		for (Employee employee : employees) {
//			System.out.println(employee);
//			if(empId.equals(employee.getEmpId())) {
//				return employee;
//			}
//		}
		
		employees.forEach(e->{System.out.println(e);
		if(empId.equals(e.getEmpId()) ) {
			this.res = e;
		}}
		);// to traverse the collection// iterate the collection
		
		
		return this.res;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		
		Employee employee = this.getEmployeeById(id);
		
		if(employee!=null) {
			// can i proceed for deletion?
			employees.remove(employee);
			return "success";
		}
		else {
			return "id not found";
			
		}
		
	}

	@Override
	public String deleteAllEmployees() {
		// TODO Auto-generated method stub
		
		employees.clear();
		return "success";
	}

}
