package com.db.employeemanagement;

import com.db.employeemanagement.dto.Employee;
import com.db.employeemanagement.repository.EmployeeRepository;
import com.db.employeemanagement.repository.EmployeeRepositoryMySQLImpl;
import com.db.employeemanagement.service.EmployeeService;
import com.db.employeemanagement.service.EmployeeServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		EmployeeRepository employeeRepository = EmployeeRepositoryMySQLImpl.getInstance();
		Thread thread = new Thread(()->{
			EmployeeRepository employeeRepository2 = EmployeeRepositoryMySQLImpl.getInstance();
		});
		Thread thread2 = new Thread(()->{
			EmployeeRepository employeeRepository3 = EmployeeRepositoryMySQLImpl.getInstance();
		});
		
		thread.start();
		thread2.start();
		
		// Menu Driven 
//		System.out.println("hello from abhi");
//		// CTRL + F11 
//		Employee employee = new Employee();
//		Employee employee2 = new Employee("ab001", "abhi", "chivate", 123.0f);
//		System.out.println(employee);
//		System.out.println(employee2.getEmpFirstName());
//		
//		//System.out.println(employee2);
//		
//		EmployeeService employeeService = new EmployeeServiceImpl();
//		String result =employeeService.addEmployee(employee2);
//		
//		//System.out.println(result);
//		
////		Employee employee3 = employeeService.getEmployeeById("ab001");
////		
////		System.out.println("Empl details by id"+employee3);
//		System.out.println("method ref demo");
//		employeeService.getEmployees().forEach(System.out::println);
//		// static methods e->System.out.println(e);
//		// constructor creations we can use it with method ref.
		
	}

}
