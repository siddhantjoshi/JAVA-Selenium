package com.orange.hrm.test.Pages;

import org.testng.annotations.Test;

import com.orange.hrm.test.Base.TestBase;

public class UserLandingPageTest extends TestBase{
	
	@Test(priority = 1)
	public void checktitleIsDisplayed() {
		softAssert.assertEquals(landingPage.landingPageTitle(), "OrangeHRM");
	}
	
	@Test(priority = 2)
	public void checkUserNameIsDisplayed() {
		softAssert.assertEquals(landingPage.getuserName(), "Welcome Paul");
	}

	@Test(priority = 3)
	public void checkadminMenuDisplayed() {
		softAssert.assertTrue(landingPage.adminMenuDisply());
	}
	
	@Test(priority = 4)
	public void checkpimMenuDisplyed() {
		softAssert.assertTrue(landingPage.pimMenuDisply());
	}
	
	@Test(priority = 5)
	public void checkTimeMenuIsDisplayed() {
		softAssert.assertTrue(landingPage.TimeMenuDisply());
	}
	
	@Test(priority = 6)
	public void checkrecrutmentMenuIsDisplayed() {
		softAssert.assertTrue(landingPage.recrutmentMenuDisply());
	}

	@Test(priority = 7)
	public void checkmyInfoMenuDisplyed() {
		softAssert.assertTrue(landingPage.myInfoMenuDisply());
	}
	
	@Test(priority = 8)
	public void checkperformanceMenuIsDisplayed() {
		softAssert.assertTrue(landingPage.performanceMenuDisply());
	}
	
	@Test(priority = 9)
	public void checkdirectoryMenuIsDisplayed() {
		softAssert.assertTrue(landingPage.directoryMenuDisply());
	}
	
	@Test(priority = 10)
	public void checkmaintanceMenuIsDisplayed() {
		softAssert.assertTrue(landingPage.maintanceMenuDisply());
	}
	

	@Test(priority = 11)
	public void checkbuzzMenuIsDisplayed() {
		softAssert.assertTrue(landingPage.buzzMenuDisply());
	}
	
}
