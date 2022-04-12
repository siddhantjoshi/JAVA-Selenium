package com.orange.hrm.test.Base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orange.hrm.base.BaseClass;
import com.orange.hrm.pages.LoginPage;
import com.orange.hrm.pages.UserLandingPage;

public class TestBase extends BaseClass{

	protected SoftAssert softAssert = new SoftAssert();
	protected static ExtentReports extentReports = ReportGeneration.reportInstance();
	protected ExtentTest logger;


	protected BaseClass baseClass = new BaseClass();
	protected static LoginPage loginPage;
	protected static UserLandingPage landingPage;

	// get time stamp
	protected static String getTimeStamp() {
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}

	// take screenshot
	public void takeScreenShot() {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("test-output\\screnshot-" + getTimeStamp() + ".png"));
			logger.addScreenCaptureFromPath(getTimeStamp() + ".png");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// Report Fail
	public void reportFail(String message) {
		logger.log(Status.FAIL, message);
		takeScreenShot();
		softAssert.fail();
	}

	// Report Pass
	public void reportPass(String message) {
		logger.log(Status.PASS, message);
	}

}
