package com.hackathon.project;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TetNG {

	@Test(dataProvider = "dataProviderMethod", dataProviderClass = DataProviderClass.class)
	public void oarnageHCMTest(String adminname, String adminPass) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.id("txtUsername")).sendKeys(adminname);
		driver.findElement(By.id("txtPassword")).sendKeys(adminPass);
		driver.findElement(By.id("btnLogin")).click();

		assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.quit();
	}

}
