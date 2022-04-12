package com.orange.hrm.test.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportGeneration extends TestBase {

	protected static ExtentReports extentReports;

	protected static ExtentReports reportInstance() {
		if (extentReports == null) {
			ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("test-output\\report-" + getTimeStamp() + ".html");

			extentReports = new ExtentReports();
			extentReports.attachReporter(htmlReport);

			extentReports.setSystemInfo("Operating System", "Windows");
			extentReports.setSystemInfo("Build No", "0.0.0.1");
			extentReports.setSystemInfo("Browser", "Chrome");
			
			htmlReport.config().setDocumentTitle("OrangeHRM Automation Testing");
			htmlReport.config().setReportName("OrangeHRM Automation Testing - Smoke Testing");
			htmlReport.config().setTimeStampFormat("MMM dd yyyy HH:mm:ss");
		}
		return extentReports;
	}

}
