package com.stepdefinitiontestng;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	//========================= second  Clicking on Buy Module and selecting filters===================================//
	
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
		Assert.assertTrue(userpage.selectPropertyType("propertyType"), "Failed to click Villa in Bangalore");
	    
	}
	@Then("I should be redirected to the Villas in Bangalore listings page.")
	public void i_should_be_redirected_to_the_villas_in_bangalore_listings_page() {
		 String currentUrl = BaseSteps.driver.getCurrentUrl();
		    System.out.println("Current URL: " + currentUrl);
		    Assert.assertTrue(currentUrl.toLowerCase().contains("villa") || currentUrl.toLowerCase().contains("bangalore"),
		        "Not redirected to Villas in Bangalore page. Current URL: " + currentUrl);		    
 
	}
	
//============================ Third Scenario=========================================================
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
	
//================================FourthScenario====================================================================
	
@Given("the user is on  the homepage")
public void the_user_is_on_the_homepage() {
	String url = prop.getProperty("homepage");
	userpage = new UserPage(driver, Hooks.test);
	driver.get(url);  
}

@When("the user clicks on the Buy option")
public void the_user_clicks_on_the_buy_option() {
	boolean isClicked= userpage.clickBuyModule1();
	if(!isClicked) {
		throw new AssertionError("Failed to click on Buy option");
	}    
}

@And("the user clicks on the Ready to Move")
public void the_user_clicks_on_the_ready_to_move() {
	boolean isClicked = userpage.selectReadytoMove("readytoMove");
//	if(!isClicked) {
//		throw new AssertionError("Failed to click on Ready to Move option");		
//	} 
}

@Then("the user should be navigated to Ready to move flats page")
public void the_user_should_be_navigated_to_ready_to_move_flats_page() {
	boolean isCorrect= userpage.verifyURL("https://www.magicbricks.com/ready-to-move-flats-in-bangalore-pppfs");
//	if(!isCorrect) {
//		throw new AssertionError("URL did not match expected Ready to Move flats page");
//	}  
}


@And("the user clicks on zero brokerage using")
public void the_user_clicks_on_zero_brokerage_using() {
	userpage.clickzerobrokerage();    
}


@Then("the Post Property page should be displayed successfully")
public void the_post_property_page_should_be_displayed_successfully() {
//	boolean isdis = userpage.selectdis("dis");
	
	System.out.println("Post Property page clicked successfully!");
	
//	driver.quit();
}
//======================================fifth Scenario========================================
@Given("user is on the MagicBricks Home Page")
public void user_is_on_the_magic_bricks_home_page() {
	String url = prop.getProperty("homepage1");
	userpage = new UserPage(driver, Hooks.test);
	driver.get(url); 
	
    
}

@And("the user clicks on the Rates and Trend")
public void the_user_clicks_on_the_rates_and_trend() {
	userpage.enterDataInteriorBudgetestimator();
   
}
@And("user enters project name from sheet {int} and row {int}")
public void user_enters_project_name_from_sheet_and_row(Integer int1, Integer int2) throws Exception {
	
	String sheetName = "Sheet2"; // Map sheetIndex if needed
    String currentRowData = ExcelReader.readData(int1, int2); // Use rowIndex dynamically
    String location = currentRowData;
    System.out.println(location);
    
    userpage.clickAndEnterAirportLocation1(location);
    
    boolean dropdownStatus = userpage.selectFirstDropdownOption();
    Assert.assertTrue(dropdownStatus, "Failed to select airport from suggestions.");
}
   

@When("user clicks on show Trends")
public void user_clicks_on_show_trends() {
	userpage.showtrends();
	
}

@Then("it should display the updated properties")
public void it_should_display_the_updated_properties() {
	boolean isVisible = userpage.isHeadingVisible();
    Assert.assertTrue(isVisible, "Heading is  not visible");
//    driver.quit();
	
}




   
}






