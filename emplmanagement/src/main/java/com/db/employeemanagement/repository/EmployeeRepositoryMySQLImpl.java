package com.db.employeemanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.employeemanagement.dto.Employee;
import com.db.employeemanagement.utils.DBUtils;

import lombok.Synchronized;

public class EmployeeRepositoryMySQLImpl implements EmployeeRepository {
	
	private EmployeeRepositoryMySQLImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static EmployeeRepositoryMySQLImpl employeeRepositoryMySQLImpl;
	public static EmployeeRepositoryMySQLImpl getInstance() {
		System.out.println("inside the getinstance ");
		
		if(employeeRepositoryMySQLImpl==null) {
			
			synchronized(EmployeeRepositoryMySQLImpl.class){
				if(employeeRepositoryMySQLImpl==null) {
			System.out.println("inside the if condition");
			employeeRepositoryMySQLImpl = new EmployeeRepositoryMySQLImpl();
			//return employeeRepositoryMySQLImpl;
				}
				else {
					return employeeRepositoryMySQLImpl;
				}
		}
		}
		return employeeRepositoryMySQLImpl;
	}

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		String insertStatement = "insert into employee (empid, firstname, lastname, salary) values(?,?,?,?)";
		
		Connection connection = DBUtils.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpFirstName());
			preparedStatement.setString(3, employee.getEmpLastName());
			preparedStatement.setFloat(4, employee.getEmpSalary());
			
			int result =preparedStatement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				return "success";
			}
			else {
				return "notfound";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		catch (NullPointerException e) {
			// TODO: handle exception
			
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return "fail";
		
		
		
	}

	@Override
	public String updateEmployee(String empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(String empId) {
		String query = "select * from employee where empid=?";
		Connection  connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =  null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, empId);
		
			resultSet = preparedStatement.executeQuery();
			Employee employee = null;
			if(resultSet.next()) {
				 employee  = new Employee();
				employee.setEmpSalary(resultSet.getFloat("salary"));
				employee.setEmpId(resultSet.getString("empid")); // column name : 
				employee.setEmpFirstName(resultSet.getString("firstname"));
				employee.setEmpLastName(resultSet.getString("lastname"));
				
			}
			return employee;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		List<Employee> employees = new ArrayList<>();
		
		String query = "select * from employee";
		Connection  connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =  null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement= connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Employee employee  = new Employee();
				employee.setEmpSalary(resultSet.getFloat("salary"));
				employee.setEmpId(resultSet.getString("empid")); // column name : 
				employee.setEmpFirstName(resultSet.getString("firstname"));
				employee.setEmpLastName(resultSet.getString("lastname"));
				employees.add(employee);
			}
			return employees;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		return null;
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
