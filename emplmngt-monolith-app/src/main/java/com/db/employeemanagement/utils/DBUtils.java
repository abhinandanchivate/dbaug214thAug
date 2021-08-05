package com.db.employeemanagement.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


			
		
public class DBUtils {
	
	public static void main(String[] args) {
		Connection connection  =getConnection();
		System.out.println(connection!=null);
	}
	
	// will help us to get JDBC Connection.
	public static Connection getConnection() {
		System.out.println(loadProperties());
		Properties properties = loadProperties();
		Connection connection = null;
		
		try {
			Class.forName(properties.getProperty("db.className"));
			
			connection = DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.userName"), 
					properties.getProperty("db.password"));
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	// to close the connection.
	public static void closeConnection(Connection connection) {
		
	}
	
	private static Properties loadProperties() {
		
		Properties properties = new Properties();
		// read file 
		// handle the exceptions
		
		try(InputStream inputStream =DBUtils.class.getClassLoader().getResourceAsStream("application.properties")) // try with resource is introduced in jdk 1.7
		{
			properties.load(inputStream);
			return properties;
		}
		catch(IOException e) {
			
			return null;
		}
		// we need close the file 
		
		
		
	}

}
