package com.db.employeemanagement.facade;

public class Main {
	
	public static void main(String[] args) {
		
		ReportGeneratorFacade reportGeneratorFacade = new ReportGeneratorFacade();
		
		reportGeneratorFacade.generateReport(ReportType.HTML, null, null);
		reportGeneratorFacade.generateReport(ReportType.PDF, null, null);
	}

}
