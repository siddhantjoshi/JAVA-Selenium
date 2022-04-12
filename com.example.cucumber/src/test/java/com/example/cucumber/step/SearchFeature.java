package com.example.cucumber.step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SearchFeature {
	
	static WebDriver driver;
	
	@Given("^User is on home page$")
	public void user_is_on_home_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		
	}

	@Then("^User can see search bar$")
	public void user_can_see_search_bar() {
		Assert.assertTrue(driver.findElement(By.id("search_query_top")).isDisplayed());
	}

	@When("^User click on search bar$")
	public void user_click_on_search_bar() {
		driver.findElement(By.id("search_query_top")).click();
	}

	@Then("^User can see search bar is highlighted$")
	public void user_can_see_search_bar_is_highlighted() {
		driver.findElement(By.id("search_query_top")).getCssValue("border-color");
	}

	@Given("^User has clicked on search bar AND search basr is highlighted$")
	public void user_has_clicked_on_search_bar_AND_search_basr_is_highlighted() {
		driver.findElement(By.id("search_query_top")).click();
		driver.findElement(By.id("search_query_top")).getCssValue("border-color");
	}

	@When("^User start to write \"([^\"]*)\" into search bar input field$")
	public void user_start_to_write_into_search_bar_input_field(String searchKeyword) {
		driver.findElement(By.id("search_query_top")).sendKeys(searchKeyword);
		driver.findElement(By.id("search_query_top"));
	}

	@Given("^User has written \"([^\"]*)\" keyword in search box$")
	public void user_has_written_keyword_in_search_box(String searchKeyword) {
		driver.findElement(By.id("search_query_top")).clear();
		driver.findElement(By.id("search_query_top")).sendKeys(searchKeyword);
		driver.findElement(By.id("search_query_top")).sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^User can see drop down suggestion list$")
	public void user_can_see_drop_down_suggestion_list() {
		
		driver.findElement(By.className("ac_results")).isDisplayed();
		driver.close();
	}

}
