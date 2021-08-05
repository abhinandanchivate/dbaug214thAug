package com.db.employeemanagement.facade;

import java.nio.channels.WritableByteChannel;

import javax.sql.DataSource;

public class ReportGeneratorFacade {

	public static void generateReport(ReportType reportType, DataSource dataSource, String location) {

		if (reportType == null || dataSource == null) {
			//throw new NullPointerException("NullPointerException");
		}

		// create report
		Report report = new Report();
		report.setHeader(new ReportHeader());
		report.setFooter(new ReportFooter());
		report.setData(new ReportData());

		// writer report

		ReportWriter reportWriter = new ReportWriter();

		switch (reportType) {
		case PDF:
			reportWriter.writePDFReport();
			break;
		case HTML:
			reportWriter.writeHtmlReport();

		}
	}
}
