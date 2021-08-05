package com.db.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.db.employeemanagement.dto.Employee;
import com.db.employeemanagement.service.EmployeeService;

@SpringBootApplication
public class EmplmngtMonolithAppApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext applicationContext =  
			SpringApplication.run(EmplmngtMonolithAppApplication.class, args);
		
		EmployeeService employeeService = 
				applicationContext.getBean(EmployeeService.class);
		employeeService.addEmployee
	(new Employee("ab001", "abhi", "chivate", 100.0f, "pune"));
		employeeService.addEmployee
		(new Employee("ab002", "abhi", "chivate", 100.0f, "pune"));
		
		System.out.println(employeeService.getEmployeeById("ab001"));
		
	}

}
