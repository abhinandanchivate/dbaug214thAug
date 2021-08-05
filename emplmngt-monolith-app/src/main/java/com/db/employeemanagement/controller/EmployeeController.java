package com.db.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.employeemanagement.dto.Employee;
import com.db.employeemanagement.service.EmployeeService;

@RestController // it is dedicated to rest api
// @responsebody + @Controller
// is used to share the response with client/consumer
// @controller will be used for mvc.
@RequestMapping("/api/employee")
public class EmployeeController {

	// i want to retrieve all empl records
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{id}")

	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String empId) {

		Optional<Employee> optional = employeeService.getEmployeeById(empId);

		if (optional.isPresent()) {
			return ResponseEntity.of(optional);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<?> getAllEmployees() {

		List<Employee> employees = employeeService.getEmployees();

		return ResponseEntity.status(HttpStatus.OK).body(employees);
		// spring boot rest will transfrom ur objects into JSON objects.
		// if we are sending only one object then it will send the single json object
		// if we sending collection/array then it will send it in terms of json array.

	}

	@PostMapping("/create")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee
			) {
		
		employeeService.addEmployee(employee);
		// save ===> insert and update.
		// if record exists then it will check any changes are there or not
		// if any changes are there then it will update it 
		// if not
		// if record doesn't exists then it will add a new record.
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmpById(@PathVariable("id") String id) {
		
		employeeService.deleteEmployeeById(id);
		return ResponseEntity.ok().build();
	}

}
