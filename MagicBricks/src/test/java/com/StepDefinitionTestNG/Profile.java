package com.StepDefinitionTestNG;

import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.Pages.EstimatedCostPage;
import com.Pages.Profilepage;
import com.Parameters.ExcelReader;
import com.Parameters.PropertyReader;
import com.Setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	//WebDriver driver = BaseSteps.driver;
	EstimatedCostPage estimate;
    Profilepage profilePage;
   // Properties prop;
    Properties prop =PropertyReader.readProperty();
    String excel;

    // -------------------- Launch & Homepage Verification --------------------

    @Given("User launches the application with configured url")
    public void user_launches_the_application_with_configured_url() {
        launchBrowser();
 
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
    	profilePage = new Profilepage(driver);
        System.out.println("User is on homepage");
    }

    @When("user hover on Home Interiors dropdown")
    public void user_hover_on_home_interiors_dropdown() {
        profilePage.hoverOnHomeInteriorsDropdown();
    }

    @And("user click Home interior Design services")
    public void user_click_home_interior_design_services() {
    	profilePage.clickHomeInteriorDesignServices();
    	
   }
 @Then("user nagivate to Home interior Design services page")
    public void user_nagivate_to_home_interior_design_services_page() throws InterruptedException 
    {
        //assertTrue(profilePage.isHomeInteriorDesignPageDisplayed());
//        Properties prop = PropertyReader.readProperty();
//        String expectedTitle = props.getProperty("HomeInterior.expected");
//        String actualTitle = driver.getTitle();
//      if (!actualTitle.contains(HomeInterior.expected)) {
//          actualTitle = false;
    	Thread.sleep(1000);
        if(driver.getTitle().equals("Home interior Design services"))
        {
        	System.out.println(driver.getTitle());
        }
        
        
        

    }

//    @When("user click on hyderabad")
//    public void user_click_on_hyderabad() {
//        profilePage.clickHyderabad();
//    }
//
//    @Then("user navigate to Interior Designers in Hyderabad page.")
//    
//    public void user_navigate_to_interior_designers_in_hyderabad_page() {
//        assertTrue(profilePage.isHyderabadDesignersPageDisplayed(),
//                   "Hyderabad Designers page is not displayed");
//    }

    

    
//==========================================Second secnario===============================================
    
   // EstimatedCostPage estimatepage;
    

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	launchBrowser();
    	profilePage = new Profilepage(driver);

    }

    @When("user hover on the Home Interiors dropdown")
    public void user_hover_on_the_home_interiors_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        profilePage.hoverOnHomeInteriorsDropdown();
    }

    
    @And("user click Home interior Design in banglore")
    public void user_click_home_interior_design_in_banglore() {
    	
        estimate = new EstimatedCostPage(driver);
        estimate.clickInteriorDesignInBangalore();
       
    }
    
    @Then("user nagivate to Home interior Design in banglore page")
    public void user_nagivate_to_home_interior_design_in_banglore_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	Thread.sleep(1000);
        if(driver.getTitle().equals("Interior Designers in Bangalore"))
        {
        	System.out.println(driver.getTitle());
        }
    }

//    @And("user click on Get Estimate Now")
//    public void user_click_on_get_estimate_now_bangalore() {
//        estimate.clickGetEstimateNow();
//    }
//
//    @Then("navigate toSelect your BHK type")
//    public void navigate_to_select_your_bhk_type() {
//        assertTrue(estimate.isBHKDropdownVisible(), "BHK type selection is not visible.");
//        System.out.println("✅ BHK type selection page loaded successfully.");
//    }
    
//=================================outline 1======================================================
    
    @Given("user lands on home page")
    public void user_lands_on_home_page() {
    	launchBrowser();
    	profilePage = new Profilepage(driver);
    	
    	
    }

    @When("user clicks on the Commercial")
    public void user_clicks_on_the_commercial() {
        profilePage.clickCommercialTab();
    }
 
    @When("user enters city name from sheet {int} and row {int}")
//    public void user_enters_city_name_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) throws InterruptedException {
//        String cityName = ExcelReader.getCellData(sheetIndex, rowIndex, 0); // Assuming column 0 has city name
//        boolean entered = profilePage.enteringCityname(cityName);
//        Assert.assertTrue(entered, "Failed to enter city name in search bar");
//    }
    
    public void user_enters_city_name_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) throws InterruptedException {
		String filepath = prop.getProperty("filepath");
		
		// Fetch locality from specific sheet and row
		String nameOfCity = ExcelReader.getLocalityByRow(filepath, sheetIndex, rowIndex);
		Assert.assertNotNull(nameOfCity, "Locality not found at sheet " + sheetIndex + ", row " + rowIndex);
		System.out.println("City from Excel:" + nameOfCity);
		//Assert.assertNotNull(userpage, "UserPage object is not initialized");
		
		profilePage.enteringCityname(nameOfCity);
	}
 
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        //boolean clicked = profilePage.clickSearch();
    	profilePage.clickSearch();
        //Assert.assertTrue(clicked, "Failed to click search button");
    }
 
    @Then("it shoiuld display list of properties available")
    public void it_shoiuld_display_list_of_properties_available() {
        // You can add a method in ProfilePage to verify property list or use an assertion on a locator
        // Example:
        boolean isDisplayed = driver.getPageSource().contains("Properties"); // Replace with actual check
        Assert.assertTrue(isDisplayed, "Property list is not displayed!");
    }
 

//====================================== 4th scenario==============================================================

//@Given("user is on The Homepage")
//public void user_is_on_The_Homepage() {
//	launchBrowser();
//	profilePage = new Profilepage(driver);
//}
//
//
//@When("user hovers on the Home Interiors dropdown")
//    public void user_hovers_on_the_home_interiors_dropdown() {
//	
//        profilePage.hoverOnHomeInteriorsDropdown();
//    }
//
//
//@And("user clicks  interior Designers in banglore")
//    public void user_clicks_interior_Designers_in_bangalore() {
//	
//        profilePage.clickInteriorDesignInBangalore();
//    }
//
//
//
//
//@And("user click the contact")
//    public void user_click_the_contact() {
//	
//        profilePage.clickContactButton();
//    }
//
//
//
//@Then("user navigate to Please share your contact details page")
//    public void user_navigate_to_contact_details_page() {
//        //Assert.assertTrue(profilePage.isContactDetailsPageDisplayed(), 
//            //"Contact details page is not  displayed!\");
//
//
////closeBrowser();
//    }

    
    
//=====================================scenario 4 =========================================================================

    @Given("user is on The HomePage")
    public void user_is_on_the_home_page() {
    	launchBrowser();
    	profilePage = new Profilepage(driver);
    }

    @When("user hover on the MB Advice dropdown")
    public void user_hover_on_the_mb_advice_dropdown() {
       profilePage.hoverOnMBAdviceDropdown();
    }

    

    @When("user clicks on Prop Index")
    public void user_clicks_on_prop_index() {
    	  profilePage.clickPropIndex();
    }

//    @When("user clicks on Get Estimate")
//    public void user_clicks_on_get_estimate() throws InterruptedException {
//    	profilePage.clickGetEstimate();
//    }
//
//    @Then("How much is my property worth?")
//    public void how_much_is_my_property_worth() {
//
//Assert.assertTrue(profilePage.isPropertyWorthPageDisplayed(),
//                "Property worth page is not displayed!");
//        closeBrowser();
//    }

    @Then("user navigate to propworth page")
    public void user_navigate_to_propworth_page() throws InterruptedException {
    	Thread.sleep(1000);
        if(driver.getTitle().equals("propworth/bangalore"))
        {
        	System.out.println(driver.getTitle());
        }
        
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

    @And("user enters the locality name from sheet <sheet1> and <row1>")
    public void user_enters_city_name_from_sheet_and_row1(Integer sheetIndex, Integer rowIndex) throws InterruptedException {
		String excelPathSO = prop.getProperty("filepath").trim();
		// Fetch locality from specific sheet and row
		String nameOfCity = ExcelReader.getLocalityByRow(excelPathSO, sheetIndex, rowIndex);
		Assert.assertNotNull(nameOfCity, "Locality not found at sheet " + sheetIndex + ", row " + rowIndex);
		System.out.println("City from Excel:" + nameOfCity);
		//Assert.assertNotNull(userpage, "UserPage object is not initialized");
		profilePage.enterPlace(nameOfCity);
	}
 

    @Then("it displays the updated page")
    public void it_displays_the_updated_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}




