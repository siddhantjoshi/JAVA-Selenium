package com.orange.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orange.hrm.base.BaseClass;

public class UserLandingPage extends BaseClass {

	public UserLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "welcome")
	WebElement userName;

	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement adminMenu;

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement pimMenu;

	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leaveMenu;

	@FindBy(id = "menu_time_viewTimeModule")
	WebElement TimeMenu;

	@FindBy(id = "menu_recruitment_viewRecruitmentModule")
	WebElement recrutmentMenu;

	@FindBy(id = "menu_pim_viewMyDetails")
	WebElement myInfoMenu;

	@FindBy(id = "menu__Performance")
	WebElement performanceMenu;

	@FindBy(id = "menu_dashboard_index")
	WebElement dashBoardMenu;

	@FindBy(id = "menu_directory_viewDirectory")
	WebElement directoryMenu;

	@FindBy(id = "menu_maintenance_purgeEmployee")
	WebElement maintanceMenu;

	@FindBy(id = "menu_buzz_viewBuzz")
	WebElement buzzMenu;

	// get Page title
	public String landingPageTitle() {
		return driver.getTitle();
	}

	// get User Name
	public String getuserName() {
		return userName.getText();
	}

	// Display adminMenu
	public Boolean adminMenuDisply() {
		return adminMenu.isDisplayed();
	}

	// Display pimMenu
	public Boolean pimMenuDisply() {
		return pimMenu.isDisplayed();
	}

	// Display TimeMenu
	public Boolean TimeMenuDisply() {
		return TimeMenu.isDisplayed();
	}

	// Display recrutmentMenu
	public Boolean recrutmentMenuDisply() {
		return recrutmentMenu.isDisplayed();
	}

	// Display myInfoMenu
	public Boolean myInfoMenuDisply() {
		return myInfoMenu.isDisplayed();
	}

	// Display performanceMenu
	public Boolean performanceMenuDisply() {
		return performanceMenu.isDisplayed();
	}

	// Display dashBoardMenu
	public Boolean dashBoardMenuDisply() {
		return dashBoardMenu.isDisplayed();
	}

	// Display directoryMenu
	public Boolean directoryMenuDisply() {
		return directoryMenu.isDisplayed();
	}

	// Display maintanceMenu
	public Boolean maintanceMenuDisply() {
		return maintanceMenu.isDisplayed();
	}

	// Display buzzMenu
	public Boolean buzzMenuDisply() {
		return buzzMenu.isDisplayed();
	}

	

}
