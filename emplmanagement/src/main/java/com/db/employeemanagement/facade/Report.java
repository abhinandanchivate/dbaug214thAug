package com.db.employeemanagement.facade;

public class Report {
	
	private ReportHeader header;
	private ReportFooter footer;
	private ReportData data;
	public ReportHeader getHeader() {
		return header;
	}
	public void setHeader(ReportHeader header) {
		System.out.println("setting Header");
		this.header = header;
	}
	public ReportFooter getFooter() {
		return footer;
	}
	public void setFooter(ReportFooter footer) {
		System.out.println("setting footer");
		this.footer = footer;
	}
	public ReportData getData() {
		return data;
	}
	public void setData(ReportData data) {
		System.out.println("setting data");
		this.data = data;
	}
	
	

}
