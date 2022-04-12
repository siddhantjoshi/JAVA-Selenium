package com.main.project.trutime.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.main.project.trutime.util.BaseUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	protected static WebDriver driver;
	protected static Properties properties;
	
	public Base() {
		// TODO Auto-generated constructor stub
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(BaseUtilities.getPropertyFilePath()));
			properties = new Properties();
			try {
				properties.load(bufferedReader);
				bufferedReader.close();
			} catch (Exception e) {
				System.out.println("ERROR:\n" + e);
			}
		} catch (Exception e) {
			System.out.println("ERROR:\n" + e);
			throw new RuntimeException("Property file is not present at location: " + BaseUtilities.getPropertyFilePath());
		}
	}

	protected void openBrowser(String Browser) {
		// select browser
		try {
			if (Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("Mozilla")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (Browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

			// maximize window
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(BaseUtilities.getIMPLICIT_WAIT(), TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(BaseUtilities.getPAGE_LOAD_TIMEOUT(), TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR : try again");
			System.exit(0);
		}
	}

	// Open URL
	protected void openBaseURL(String URL) {
		driver.get(properties.getProperty(URL));
	}

	// Close Browsesr
	protected void closeBrowser() {
		driver.close();
	}

	// Quit Browser
	protected void quitBrowser() {
		driver.quit();
	}

	// Enter Text
	protected void enterTextInElement(String locator, String textToEnter) {
		elementLocator(locator).sendKeys(textToEnter);
	}

	// Click On Element
	protected void ClickOnElement(String locator) {
		elementLocator(locator).click();
	}

	// get Element Locator
	protected WebElement elementLocator(String locator) {
		WebElement element = null;
		String key = null;
		try {
			if (locator.endsWith("xpath")) {
			
				key = checkPropertyKey(properties.getProperty(locator));
				element = driver.findElement(By.xpath(key));
			} else if (locator.endsWith("cssSelector")) {
				
				key = checkPropertyKey(properties.getProperty(locator));
				element = driver.findElement(By.cssSelector(properties.getProperty(locator)));
			} else if (locator.endsWith("id")) {
				
				key = checkPropertyKey(properties.getProperty(locator));
				element = driver.findElement(By.id(properties.getProperty(locator)));
			} else if (locator.endsWith("name")) {
				
				key = checkPropertyKey(properties.getProperty(locator));
				element = driver.findElement(By.name(properties.getProperty(locator)));
			} else if (locator.endsWith("className")) {
				
				key = checkPropertyKey(properties.getProperty(locator));
				element = driver.findElement(By.className(properties.getProperty(locator)));
			} else if (locator.endsWith("partialLinkText")) {
				
				key = checkPropertyKey(properties.getProperty(locator));
				element = driver.findElement(By.partialLinkText(properties.getProperty(locator)));
			} else if (locator.endsWith("linkText")) {
				
				key = checkPropertyKey(properties.getProperty(locator));
				element = driver.findElement(By.linkText(properties.getProperty(locator)));
			} else if (locator.endsWith("tagName")) {
				
				key = checkPropertyKey(properties.getProperty(locator));
				element = driver.findElement(By.tagName(properties.getProperty(locator)));
			} else {
				
				System.out.println("ERROR: Invalid Locator " + locator);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	//check if locator is null
	protected String checkPropertyKey(String key) {
		if (properties.getProperty(key)!= null) {
			return key;
		}
		else {
			throw new RuntimeException("Key name is not specified in properties file");
		}
	}

}
