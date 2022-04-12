package com.hackathon.project;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Image;

import net.sourceforge.tess4j.Tesseract;

public class TestCases {

	// initialize Variables
	private static WebDriver driver;
	private static PropertyFile file;
	private static Scanner scan;
	private static DriverSetUp driverSetUp;
	private static SaveData data;

	// constructor
	public TestCases() {
		file = new PropertyFile();
		scan = new Scanner(System.in);
		driverSetUp = new DriverSetUp();
		data = new SaveData();
	}

	// open browser
	public void openBrowser() {
		System.out.println("Select Browser from following options\n1: Chrome\n2: Mozilla\n3: Edge");
		int var = scan.nextInt();
		try {

			DriverSetUp.setBrowser(2);
			driver = driverSetUp.getWebDriver();

		} catch (Exception e) {
			System.out.println("ERROR: You enter wrong data");
			System.exit(0);
		}
	}

	// Open URL
	public void openURL() {
		driver.manage().window().maximize();
		driver.get(file.getBaseURL());
	}

	// search for city
	public void setCity() {
		WebElement cityInput = driver.findElement(By.cssSelector("input[id='city']"));
		cityInput.clear();
		cityInput.sendKeys(file.getLocation());

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//ul[@id='cuto']/li"))));
		List<WebElement> autoSuggest = driver.findElements(By.xpath("//ul[@id='cuto']/li"));
		autoSuggest.get(0).click();

	}

	// Search service
	public void searchService() {
		WebElement searchService = driver.findElement(By.cssSelector("input[id='srchbx']"));
		searchService.clear();
		searchService.sendKeys(file.getSearchService());
	}

	// click on search button
	public void clickOnSearchButton() {

		WebElement searchButton = driver.findElement(By.cssSelector("span button[class='search-button']"));
		searchButton.click();
	}

	// sort by rating
	public void SortByRating() {

		WebElement sortOption = driver.findElement(By.cssSelector("li a[id='distdrop_rat']"));
		sortOption.click();
	}

	// disable popup
	public void getData() {
		DriverSetUp.setBrowser(1);
		driver = driverSetUp.getWebDriver();
		driver.manage().window().maximize();
		driver.get("https://www.justdial.com/Pune/Car-Washing-Services/nct-10079017");
		WebElement sortByRatings = driver.findElement(By.xpath("//a[@id='distdrop_rat']"));
		sortByRatings.click();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("dsdasda");
		String str =  scanner.nextLine();

		WebElement bestDealPopUp = driver.findElement(By.cssSelector("section[id ='best_deal_div']"));
		if (bestDealPopUp.isDisplayed()) {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(bestDealPopUp));
			WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"best_deal_div\"]/section/span"));
			closeButton.click();
		} else if (driver.findElement(By.className("store-details")).isDisplayed()) {
			
			List<WebElement> storeDetails = driver.findElements(By.className("store-details"));
			
			String[] title= new String[5];
			String[] address = new String[5];
			String[] ratings= new String[5];
			String[] votes= new String[5];
			File imag =null;
			
			for (int i = 0, j = 0; i < storeDetails.size(); i++) {

				Actions actions = new Actions(driver);

				String rating = storeDetails.get(i).findElement(By.cssSelector("p a span[class='green-box']"))
						.getText();
				String vote = storeDetails.get(i).findElement(By.cssSelector("p a span[class='rt_count lng_vote']"))
						.getText().replaceAll("[^0-9]", "");
				String titles = storeDetails.get(i).findElement(By.cssSelector("h2 span a")).getAttribute("title");
				

				
				Tesseract instance = new Tesseract();
				instance.setDatapath("Tess4J\\tessdata");
				String result = "";
				
				if (Float.valueOf(rating).floatValue() > Float.valueOf(file.getMinRatings())
						&& Integer.valueOf(vote) > Integer.valueOf(file.getMinVotes()) && j < 5) {
					actions.moveToElement(
							storeDetails.get(i).findElement(By.xpath("//a[@id='morehvr_add" + i + "']/span")))
							.perform();
					WebElement addres = storeDetails.get(i).findElement(By.className("mrehover"));
					WebDriverWait wait = new WebDriverWait(driver, 40);
					wait.until(ExpectedConditions.visibilityOf(addres));
					
					if (addres.isDisplayed()) {
						try {
							imag = storeDetails.get(i).findElement(By.cssSelector("p[class='contact-info ']")).getScreenshotAs(OutputType.FILE);
							Thread.sleep(3000);
							FileHandler.copy(imag, new File("output.png"));
							result = instance.doOCR(new File("output.png")).replaceAll("[^0-9]", "");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("Store " + j + " Details");
						System.out.println("Store Title:\n" + titles);
						System.out.println("Store Address:\n" + addres.getText());
						System.out.println("Store Ratings:\n" + rating);
						System.out.println("Store Votes:\n" + vote);
						System.out.println("Store Phone:\n" + result);
						System.out.println("------------------------------");
						title[j] = titles;
						address[j] = addres.getText();
						ratings[j] = rating;
						votes[j] = vote;
					}
					j++;
				}

			}
//			imag = null; 
			
			data.sendDataToExccelSheet(title,address, ratings, votes,str);
		}
	}

	public void clickOnfreeListing() {

		WebElement freelisting = driver.findElement(By.cssSelector("div[class='rightfixed'] [class$='frilst ']"));
		freelisting.click();
	}

	public void fillForm() {
		driver.findElement(By.cssSelector("input[id='fcom']")).sendKeys("ABC Company");
		WebElement cityName = driver.findElement(By.xpath("//input[@id='flcity']"));
		cityName.clear();
		cityName.sendKeys("Pune");

		driver.findElement(By.cssSelector("#ttlbl")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Mr']")).click();
		driver.findElement(By.cssSelector("input[id ='fname']")).sendKeys("ABC Company");
		driver.findElement(By.cssSelector("input[id='lname']")).sendKeys("ABC Company");
		driver.findElement(By.cssSelector("input[id='fmb0']")).sendKeys("qwertyu");
		driver.findElement(By.cssSelector("button[type = 'button']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement errorMessage = driver.findElement(By.xpath("//span[@class='almsg flmierr']"));
		if (errorMessage.isDisplayed()) {
			String error = errorMessage.getText();
			System.out.println("ERROR Message: " + error);
			System.out.println("------------------------------");

		}
	}

	public void fitnessPage() {

		driver.findElement(By.cssSelector("span[class='lgnjdhdr']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript(
				"document.querySelector('#ContextualHotkey_27').scrollIntoView({ behavior: 'smooth' });");
		WebElement fitnessOption = driver.findElement(By.id("ContextualHotkey_27"));
		fitnessOption.click();

	}

	public void gymPage() {
		driver.findElement(By.xpath("//a[@onclick=\"_ct('psc_Gym','fltrpg');\"]")).click();
		List<WebElement> gymType = driver.findElements(By.xpath("//ul[@class='mm-listview']//li"));
		System.out.println("GYM TYPE");

		for (WebElement webElement : gymType) {
			System.out.println(webElement.getText());
		}

	}

	// close Browser
	public void closeBrowser() {
		scan.close();
		driver.close();
	}

	public static void main(String[] args) {
		TestCases test = new TestCases();
//		test.openBrowser();
//		test.openURL();
//		test.setCity();
//		test.searchService();
//		test.clickOnSearchButton();
		test.getData();
//		test.getData();
		
//		test.clickOnfreeListing();
//		test.fillForm();
//		test.fitnessPage();
//		test.gymPage();
//		test.closeBrowser();
	}
}
