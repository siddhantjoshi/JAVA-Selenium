package com.page.object.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.object.base.BaseClass;

public class HomePageClass extends BaseClass{
	
	@FindBy(id="welcome")
	WebElement userName;
	
	public HomePageClass(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getuserName() {
		return userName.getText();
	}
	
}
