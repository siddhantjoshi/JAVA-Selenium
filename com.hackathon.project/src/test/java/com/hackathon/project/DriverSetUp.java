package com.hackathon.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUp {
	// initialize variables
	private static int browser;
	private static WebDriver driver;

	// getter and setters
	public static int getBrowser() {
		return browser;
	}

	public static void setBrowser(int browser) {
		DriverSetUp.browser = browser;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		DriverSetUp.driver = driver;
	}

	// method to initialize driver
	public WebDriver getWebDriver() {

		// Chrome Browser
		if (getBrowser() == 1) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--disable-geolocation");
			chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
			chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			setDriver(new ChromeDriver(chromeOptions));
		}

		// mozilla firefox Browser
		else if (getBrowser() == 2) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable-geolocation");
			firefoxOptions.addArguments("--disable-blink-features=AutomationControlled");

			setDriver(new FirefoxDriver(firefoxOptions));

		}
		// Edge Browser
		else if (getBrowser() == 3) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		} else {
			System.out.println("ERROR:\nPlease enter valid entry...");
			System.exit(0);
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
