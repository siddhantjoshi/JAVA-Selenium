package com.page.object.TestPages;

import org.testng.annotations.Test;

import com.page.object.model.base.BaseTestClass;

public class LoginPageTestClass extends BaseTestClass{

	@Test(priority = 1)
	public void checkUserIsOnOrangeHRM() {
		baseClass.openBrowser();
		loginPage = baseClass.openBaseURL();
		
		softAssert.assertEquals(loginPage.LogInPageTitle(), "OrangeHRM");
	}

	@Test(priority = 2)
	public void checkUserNameInputIsDisplayed() {
		softAssert.assertEquals(loginPage.LogInPageTitle(), "OrangeHRM");
	}
	
	@Test(priority = 3)
	public void checkUserNameInputIsClickable() {
		softAssert.assertEquals(loginPage.userNameInputClicked(), true);
	}
	
	@Test(priority = 4)
	public void checkUserNameInputIsWritable() {
		softAssert.assertEquals(loginPage.userNameInputWrite("Admin"), true);
	}
	
	@Test (priority = 5)
	public void checkUserPasswordInputIsDisplayed() {
		softAssert.assertTrue(loginPage.userPasswordInputDisply());
	}
	
	@Test(priority = 6)
	public void checkUserPasswordInputIsClickable() {
		softAssert.assertEquals(loginPage.userPasswordInputClicked(), true);
	}
	
	@Test(priority = 7)
	public void checkUserPasswordInputIsWritable() {
		softAssert.assertEquals(loginPage.userPasswordInputWrite("admin123"), true);
	}
	
	@Test(priority = 8)
	public void checkLoginBtnIsDisplayed() {
		softAssert.assertTrue(loginPage.loginBtnDisplay());		
	}
	
	@Test(priority = 9)
	public void checkLoginBtnIsClickable() {
		homePageClass = loginPage.loginBtnClick();
	}

}
