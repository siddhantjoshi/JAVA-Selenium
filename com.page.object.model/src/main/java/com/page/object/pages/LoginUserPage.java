package com.page.object.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.object.base.BaseClass;

public class LoginUserPage extends BaseClass{


	@FindBy(xpath="//input[@id='i0116']")
	WebElement signInTextbox;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement nextButton;
	
	@FindBy(xpath="//input[@id='i0118']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement signInButton;
	
	
	public LoginUserPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmail() {
		signInTextbox.sendKeys("2108053@cogniznat.com");
	}
}
