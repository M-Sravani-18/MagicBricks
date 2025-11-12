package com.StepDefinitionTestNG;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import com.Pages.EstimatedCostPage;
import com.Pages.Profilepage;
import com.Parameters.PropertyReader;
import com.Setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	EstimatedCostPage estimate;
    Profilepage profilePage;
    Properties prop;

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
        
        
        
//    }
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

    
//=============================estimate page====================================================

//@Given("User launches the site with configured url")
//public void User_launches_the_application_with_configured_url() {
//    launchBrowser();
//    driver.get(prop.getProperty("url2")); // Reads Hyderabad URL from properties
//}
//
//@When("user select Economic")
//public void user_select_economic() {
//    estimatepage.selectBudgetOption(prop.getProperty("budgetoption")); // Reads "Economic"
//}
//
////   @When("user select Economic")
////   public void user_select_economic() {
////        estimatepage = new EstimatedCostPage(driver);
////        estimatepage.selectBudgetOption(prop.getProperty("budgetOption")); // e.g., "Economic"
////    }
//
//    @When("click on Get Estimate Now")
//    public void click_on_get_estimate_now() {
//        estimatepage.clickGetEstimateNow();
//    }
//
//
//@When("click on {int}+BHK and slect option")
//public void click_on_bhk_and_slect_option(Integer int1) {
//    estimatepage.selectBHKOption(Integer.parseInt(prop.getProperty("bhkOption"))); // Reads "2"
//}
//
//
//    @When("click on next")
//    public void click_on_next() {
//        estimatepage.clickNext();
//    }
//
//    @When("click on continue")
//    public void click_on_continue() {
//        estimatepage.clickContinue();
//    }
//
//    @Then("Your Estimated Cost for Home Interiors {int} + BHK will display")
//    public void your_estimated_cost_for_home_interiors_bhk_will_display(Integer int1) {
//        assertTrue(estimatepage.isEstimatedCostDisplayed(int1), "Estimated cost not displayed for " + int1 + " BHK");
//    }
    
//==========================================Second secnario===============================================
    
    EstimatedCostPage estimatepage;
    

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	profilePage = new Profilepage(driver);
    }

    @When("user hover on the Home Interiors dropdown")
    public void user_hover_on_the_home_interiors_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        profilePage.hoverOnHomeInteriorsDropdown();
    }

    
    @When("user click Home interior Design in banglore")
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


}








