package com.pages;

import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	ExtentReports extent;
	ExtentTest test;

	public ExtentReport() {
		this.extent = new ExtentReports();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		ExtentSparkReporter spark = 
				new ExtentSparkReporter("test-output/extent_reports/report_"+timeStamp+".html");
		extent.attachReporter(spark);
		test=extent.createTest("Product Store Test");
		
	}

	public void logPass(String message) {
		test.log(Status.PASS, message);
	}

	public void logFail(String message) {
		test.log(Status.FAIL, message);
	}

	public void generateReport() {
		extent.flush();
	}
}