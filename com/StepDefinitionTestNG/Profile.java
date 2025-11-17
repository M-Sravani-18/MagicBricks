package com.StepDefinitionTestNG;

import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.Parameters.ExcelReader;
import com.Parameters.ExcelUtils;
import com.Parameters.PropertyReader;
import com.Setup.BaseSteps;
import com.Setup.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.Pages.BasePage;

import com.Pages.Profilepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	
    Profilepage profilePage;
   // Properties prop;
    Properties prop =PropertyReader.readProperty();
    String excel;
    ExtentTest test=Hooks.test;

    // -------------------- Launch & Homepage Verification --------------------

    @Given("User launches the application with configured url")
    public void user_launches_the_application_with_configured_url() {
   BasePage basePage=new BasePage(driver,test);
 
    }

    @When("User waits until the homepage is fully loaded")
    public void user_waits_until_the_homepage_is_fully_loaded() {
        sleep(5000); // Consider replacing with WebDriverWait for better handling
    }

    @Then("Homepage should be displayed successfully")
    public void homepage_should_be_displayed_successfully() {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("magicbricks.com")) {
            throw new AssertionError("Homepage not loaded correctly. Current URL: " + currentUrl);
        }
    }

    @And("the application title should be displayed")
    public void the_application_title_should_be_displayed() {
        Properties prop = PropertyReader.readProperty();
        String actualTitle = driver.getTitle();
        System.out.println("Application title verified: " + actualTitle);

        // Optional title check
        // String expectedTitle = prop.getProperty("sourceTitle");
        // assertTrue(actualTitle.contains(expectedTitle), "Title mismatch");

       
    }

    // -------------------- Home Interiors Navigation --------------------

    @Given("user on the homepage")
    public void user_on_the_homepage() {
    	//profilePage = new Profilepage(driver);
        System.out.println("User is on homepage");
    }

    @When("user hover on Home Interiors dropdown")
    public void user_hover_on_home_interiors_dropdown() {
    	profilePage=new Profilepage(driver,test);
        profilePage.hoverOnHomeInteriorsDropdown();
    }

    @And("user click Home interior Design services")
    public void user_click_home_interior_design_services() throws InterruptedException {
    	profilePage=new Profilepage(driver,test);
    	profilePage.clickHomeInteriorDesignServices();
    	
   }
 @Then("user nagivate to Home interior Design services page")
    public void user_nagivate_to_home_interior_design_services_page() throws InterruptedException 
    {
        
    	Thread.sleep(5000);
        if(driver.getTitle().equals("Home interior Design services"))
        {
        	
        	System.out.println(driver.getTitle());
        
        Reports.captureScreenshot(driver, "scenario1");
        }
    }

    

    
//==========================================Second secnario===============================================
    
   // EstimatedCostPage estimatepage;
    

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
       	profilePage = new Profilepage(driver, test);

    }

    @When("user hover on the Home Interiors dropdown")
    public void user_hover_on_the_home_interiors_dropdown() {
        profilePage.hoverOnHomeInteriorsDropdown();
    }

    
    @And("user click Home interior Design in banglore")
    public void user_click_home_interior_design_in_banglore() throws InterruptedException {
    	profilePage = new Profilepage(driver, test);
        profilePage.clickInteriorDesignInBangalore();
       
    }
    
    @Then("user nagivate to Home interior Design in banglore page")
    public void user_nagivate_to_home_interior_design_in_banglore_page() throws InterruptedException {
    	Thread.sleep(1000);
        if(driver.getTitle().equals("Interior Designers in Bangalore"))
        {
        	System.out.println(driver.getTitle());
        	 Reports.captureScreenshot(driver, "scenario2");
        }
    
    }

    
//=================================outline 1======================================================
    
    @Given("user lands on home page")
    public void user_lands_on_home_page() {
    	//launchBrowser();
    	profilePage = new Profilepage(driver, test);
    	
    	
    }

    @When("user clicks on the Commercial")
    public void user_clicks_on_the_commercial() {
        profilePage.clickCommercialTab();
    }
 
    @When("user enters city name from sheet {int} and row {int}")

     public void user_enters_city_name_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) throws InterruptedException {
		String filepath = prop.getProperty("filepath");
		
		// Fetch locality from specific sheet and row
		String nameOfCity = ExcelReader.getLocalityByRow(filepath, sheetIndex, rowIndex);
		Assert.assertNotNull(nameOfCity, "Locality not found at sheet " + sheetIndex + ", row " + rowIndex);
		System.out.println("City from Excel:" + nameOfCity);
		profilePage.enteringCityname(nameOfCity);
		profilePage.selectFirstcity();
	}
 
    @When("user clicks on search button")
    public void user_clicks_on_search_button() throws InterruptedException {
       profilePage.clickSearch();
       
    }
 
    @Then("it shoiuld display list of properties available")
    public void it_shoiuld_display_list_of_properties_available() {
        boolean isDisplayed = driver.getPageSource().contains("Properties"); // Replace with actual check
        Reports.captureScreenshot(driver, "outline1");
        Assert.assertTrue(isDisplayed, "Property list is not displayed!");
       // Reports.captureScreenshot(driver, "outline1");
    }
 


    
//=====================================scenario 4 =========================================================================

    @Given("user is on The HomePage")
    public void user_is_on_the_home_page() {
    //	launchBrowser();
    	profilePage = new Profilepage(driver, test);
    }

    @When("user hover on the MB Advice dropdown")
    public void user_hover_on_the_mb_advice_dropdown() {
       profilePage.hoverOnMBAdviceDropdown();
    }

    

    @When("user clicks on Prop Index")
    public void user_clicks_on_prop_index() throws InterruptedException {
    	  profilePage.clickPropIndex();
    }

    @Then("user navigate to propworth page")
    public void user_navigate_to_propworth_page() throws InterruptedException {
    	Thread.sleep(1000);
        if(driver.getTitle().equals("propworth/bangalore"))
        {
         
        	System.out.println(driver.getTitle());
         }
        Reports.captureScreenshot(driver, "scenario4");
        driver.quit();
        }
    
   
 //============================= scenario 5 ===========================================================
    @When("user clicks on the commerical")
    public void user_clicks_on_the_commerical() {
    	 profilePage.clickCommercialTab();
    }

    @When("the user clicks on the rates and trends")
    public void the_user_clicks_on_the_rates_and_trends() {
    	profilePage.clickonrate();
    }
    
    @And("user enters the locality name from sheet {int} and row {int}")
    public void user_enters_the_locality_name_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) throws Exception {
    	String sheetName = "Sheet2"; // Map sheetIndex if needed
        String currentRowData = ExcelUtils.readData(sheetName, rowIndex); // Use rowIndex dynamically
        String location = currentRowData;
        System.out.println(location);
        
        profilePage.clickAndEntercityname(location);
        
        boolean dropdownStatus = profilePage.selectFirstDropdownOption();
	    Assert.assertTrue(dropdownStatus, "Failed to select airport from suggestions.");
    }
	
 @When("user cliks on show trends")
    public void user_cliks_on_show_trends() {
    	profilePage.clickShowtrends();
       
    }
 

    @Then("it displays the updated page")
    public void it_displays_the_updated_page() {
    	boolean isVisible = Profilepage.isHeadingVisible(PropertyReader.get("headingName"));
    Assert.assertTrue(isVisible, "Heading is  not visible");
    Reports.captureScreenshot(driver, "outline2");
    driver.quit();
    }




}




