package com.page.object.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.object.base.BaseClass;

public class LoginPageClass extends BaseClass {

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "txtUsername")
	WebElement userNameInput;

	@FindBy(id = "txtPassword")
	WebElement userPasswordInput;

	@FindBy(id = "btnLogin")
	WebElement userLoginBtn;

	public String LogInPageTitle() {
		return driver.getTitle();
	}

	// Display Username Input Field
	public Boolean userNameInputDisply() {
		return userNameInput.isDisplayed();
	}

	// Clcik on Username Input Field
	public boolean userNameInputClicked() {
		try {
			userNameInput.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Write on Username Input Field
	public boolean userNameInputWrite(String userName) {
		try {
			userNameInput.sendKeys(userName);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Display Password Input Field
	public Boolean userPasswordInputDisply() {
		return userPasswordInput.isDisplayed();
	}

	// Clcik on Password Input Field
	public boolean userPasswordInputClicked() {
		try {
			userPasswordInput.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Write on Password Input Field
	public boolean userPasswordInputWrite(String userPassword) {
		try {
			userPasswordInput.sendKeys(userPassword);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Display Login Button
	public Boolean loginBtnDisplay() {
		return userLoginBtn.isDisplayed();
	}

	// Click onLogin Button
	public HomePageClass loginBtnClick() {
		userLoginBtn.click();
		return PageFactory.initElements(driver, HomePageClass.class);
	}

}
