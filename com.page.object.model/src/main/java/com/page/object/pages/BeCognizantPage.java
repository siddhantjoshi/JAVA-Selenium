package com.page.object.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.object.base.BaseClass;

public class BeCognizantPage extends BaseClass {

	// getElemnt - Search Box
	@FindBy(id = "searchbox")
	WebElement searchBox;

	// getElemnt - Search button
	@FindBy(id = "search-button")
	WebElement searchBtn;

	// getElemnt - truTimeButton
	@FindBy(xpath = "//div[@class='slick-slide slick-active']//div//app-carousel-item[@id='appSlide-1']//a[@class='media']")
	WebElement truTimeButon;

	// getElemnt - User Name
	@FindBy(id = "user-name")
	WebElement userName;

	// constructor
	public BeCognizantPage(WebDriver driver) {
		this.driver = driver;
	}

	// Display user name
	public Boolean usernNameDisply() {
		return userName.isDisplayed();
	}

	// Display searchBox Input Field
	public Boolean searchBoxFieldDisply() {
		return searchBox.isDisplayed();
	}

	// Clcik on searchBox Input Field
	public boolean searchBoxFieldClicked() {
		try {
			searchBox.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Write on searchBox Input Field
	public boolean searchBoxFieldtWrite(String userName) {
		try {
			searchBox.sendKeys(userName);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Display searchbtn
	public Boolean searchBtnDisplay() {
		return searchBtn.isDisplayed();
	}

	// Clcik on searchbtn
	public boolean searchBtnClicked() {
		try {
			searchBtn.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	// Display TurTime Button
	public Boolean truTimeButtonDisply() {
		return truTimeButon.isDisplayed();
	}
}
