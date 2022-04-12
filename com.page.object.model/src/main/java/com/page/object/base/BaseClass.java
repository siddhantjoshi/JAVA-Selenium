package com.page.object.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.page.object.config.ConfigFile;
import com.page.object.pages.LoginPageClass;
import com.page.object.pages.LoginUserPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;
	protected ConfigFile file;
	SoftAssert softAssert = new SoftAssert();

	public BaseClass() {
		file = new ConfigFile();
	}
	
	@BeforeSuite
	public void openBrowser() {
		
		// select browser
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

//			// maximize window
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR : try again");
			System.exit(0);
		}
	}

	// Open URL
	public LoginUserPage openBaseURL() {
		try {
			driver.get(file.getBaseURL());
			return PageFactory.initElements(driver, LoginUserPage.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	// Close Browsesr
	protected void closeBrowser() {

		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
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

}
