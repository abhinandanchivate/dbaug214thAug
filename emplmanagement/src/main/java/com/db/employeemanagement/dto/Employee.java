package com.db.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private String empId;
	private String empFirstName;
	private String empLastName;
	private float empSalary;
}
