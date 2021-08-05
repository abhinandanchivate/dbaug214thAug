package com.db.employeemanagement.proxy;

public class RealObjectProxy extends RealObjectImpl {
	
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		
		System.out.println("delegating work on realtime object");
		super.doSomething();
	}

}
