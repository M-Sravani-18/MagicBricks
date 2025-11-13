package com.stepdefinitiontestng;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps{
	
	WebDriver driver = BaseSteps.driver;
	ExtentTest test = Hooks.test;
	UserPage userpage;
	Properties prop =PropertyReader.readProperty();

	@Given("the user opens the configured browser")
	public void the_user_opens_the_configured_browser() {
		//BaseSteps.launchBrowser();  
		// Launch browser using BaseSteps	    
	}

	@When("the user navigate to the configured application URL")
	public void the_user_navigate_to_the_configured_application_url() {

		 // Already handled in launchBrowser() because driver.get(url) is called there
		   System.out.println("Navigated to application URL");
	}

	@And("the homepage should be displayed")
	public void the_homepage_should_be_displayed() {
		 String currentUrl = BaseSteps.driver.getCurrentUrl();
		        System.out.println("Current URL: " + currentUrl);
		        Assert.assertTrue(currentUrl.contains("magicbricks.com"));
	}

	@Then("the page title should be verified")
	public void the_page_title_should_be_verified() {

		String title = BaseSteps.driver.getTitle();
		System.out.println("Page Title: " + title);
		Assert.assertTrue(title.toLowerCase().contains("magicbricks"));
	}
	
	// Clicking on Buy Module and selecting filters
	
	@Given("I am on the MagicBricks homepage")
	public void i_am_on_the_magic_bricks_homepage() {
		 userpage = new UserPage(BaseSteps.driver, Hooks.test);
		    Assert.assertTrue(userpage.verifyHomePage(), "Homepage is not displayed");

	   
	}

	@When("I click on the Buy module")
	public void i_click_on_the_buy_module() {
		Assert.assertTrue(userpage.clickBuyModule(), "Failed to click Buy module");
		
		
	    
	}

	@And("I click on Villa in Bangalore")
	public void i_click_on_villa_in_bangalore() {
		Assert.assertTrue(userpage.selectPropertyType("Villa in Bangalore"), "Failed to click Villa in Bangalore");
	    
	}

	@Then("I should be redirected to the Villas in Bangalore listings page.")
	public void i_should_be_redirected_to_the_villas_in_bangalore_listings_page() {
		 String currentUrl = BaseSteps.driver.getCurrentUrl();
		    System.out.println("Current URL: " + currentUrl);
		    Assert.assertTrue(currentUrl.toLowerCase().contains("villa") || currentUrl.toLowerCase().contains("bangalore"),
		        "Not redirected to Villas in Bangalore page. Current URL: " + currentUrl);		    
 
	}
	
// Third Scenario
	
	
	
	@Given("user is on cityPage")
	public void user_is_on_city_page() {
		String url = prop.getProperty("cityPage");
		userpage = new UserPage(driver, Hooks.test);
		driver.get(url);
		
	    
	}

	@And("user enters city name from sheet {int} and row {int}")
	public void user_enters_city_name_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) throws InterruptedException {
		String excelPathSO = prop.getProperty("excelpath").trim();
		 
		// Fetch locality from specific sheet and row
		String nameOfCity = ExcelReader.getLocalityByRow(excelPathSO, sheetIndex, rowIndex);
		Assert.assertNotNull(nameOfCity, "Locality not found at sheet " + sheetIndex + ", row " + rowIndex);
		System.out.println("City from Excel:" + nameOfCity);
		//Assert.assertNotNull(userpage, "UserPage object is not initialized");
		
		userpage.enteringCityname(nameOfCity);
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		userpage.clickSearch();
		
	   
	}

	@Then("it should display list of properties available")
	public void it_should_display_list_of_properties_available() {
	    
	}

	
	
}
	
	




