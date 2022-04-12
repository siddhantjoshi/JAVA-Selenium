package com.orange.hrm.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.orange.hrm.config.ConfigFile;
import com.orange.hrm.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;
	protected ConfigFile file;

	SoftAssert softAssert = new SoftAssert();

	// Constrcutor
	public BaseClass() {
		file = new ConfigFile();
	}

	@BeforeSuite
	public void openBrowser() {

		try {
			if (file.getbrowser().equalsIgnoreCase("Chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (file.getbrowser().equalsIgnoreCase("Mozilla")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (file.getbrowser().equalsIgnoreCase("Edge")) {

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR : try again");
			System.exit(0);
		}
	}

	// Quit Browser
	@AfterSuite
	protected void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// Open URL
	public LoginPage openBaseURL() {
		try {
			driver.get(file.getBaseURL());
			return PageFactory.initElements(driver, LoginPage.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
