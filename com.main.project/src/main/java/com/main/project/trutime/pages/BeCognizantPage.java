package com.main.project.trutime.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.project.trutime.base.Base;

public class BeCognizantPage extends Base{

	@FindBy(id="searchbox")
	WebElement searchBox ;
	
	private BeCognizantPage(){
		PageFactory.initElements(driver,this);
	}
	
	//Page Title
	protected String pageTitle() {
		return driver.getTitle();
	}
	
	//Search Box Present
	protected boolean searchBox() {
		return searchBox.isDisplayed();
	}
	
	//Insert Value
	protected SearchResultPage SearchBox(String searchValue) {
		searchBox.click();
		searchBox.sendKeys(searchValue);
		
		return new SearchResultPage();
	}
}
