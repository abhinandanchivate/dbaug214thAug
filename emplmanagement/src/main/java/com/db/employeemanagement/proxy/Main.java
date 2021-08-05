package com.db.employeemanagement.proxy;

public class Main {

	public static void main(String[] args) {
		RealObject object = new RealObjectProxy();
		object.doSomething();
	}
}
