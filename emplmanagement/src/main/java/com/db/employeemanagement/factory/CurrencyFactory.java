package com.db.employeemanagement.factory;

public class CurrencyFactory {

	
	public static Currency createCurrency(String country) {
		
		if(country.equalsIgnoreCase("india"))	{
			return new Rupee();
		}
		
		else if (country.equalsIgnoreCase("USA")) {
			return new USDollar();
		}
		else if (country.equalsIgnoreCase("Canada")) {
			return new CADDollar();
		}
		
		throw new IllegalArgumentException();
	}
}
