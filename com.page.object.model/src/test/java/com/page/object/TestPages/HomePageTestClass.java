package com.page.object.TestPages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.page.object.model.base.BaseTestClass;

public class HomePageTestClass extends BaseTestClass{
	
	@Test(priority = 1)
	void checkUserLogin() {
		assertEquals(homePageClass.getuserName(), "Welcome Paul");
	}
	
//	@Test(priority = 2)
//	void checkUserLogin() {
//		assertEquals(homePageClass.getuserName(), "Welcome Paul");
//	}
//	@Test(priority = 3)
//	void checkUserLogin() {
//		assertEquals(homePageClass.getuserName(), "Welcome Paul");
//	}
//	@Test(priority = 4)
//	void checkUserLogin() {
//		assertEquals(homePageClass.getuserName(), "Welcome Paul");
//	}
//	@Test(priority = 5)
//	void checkUserLogin() {
//		assertEquals(homePageClass.getuserName(), "Welcome Paul");
//	}
//	@Test(priority = 6)
//	void checkUserLogin() {
//		assertEquals(homePageClass.getuserName(), "Welcome Paul");
//	}

}
