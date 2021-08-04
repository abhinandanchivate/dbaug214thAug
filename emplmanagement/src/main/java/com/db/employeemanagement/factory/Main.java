package com.db.employeemanagement.factory;

public class Main {

	public static void main(String[] args) {
		
		
		Currency indiaCurrency= CurrencyFactory.createCurrency("SriLanka");
		
		System.out.println(indiaCurrency.getSymbol());
	}
}
