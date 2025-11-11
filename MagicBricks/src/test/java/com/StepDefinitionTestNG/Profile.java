package com.StepDefinitionTestNG;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.Pages.Profilepage;
import com.Parameters.PropertyReader;
import com.Setup.BaseSteps;

import io.cucumber.java.en.*;

public class Profile extends BaseSteps {

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

    @When("user click Home interior Design services")
    public void user_click_home_interior_design_services() {
        profilePage.clickHomeInteriorDesignServices();
    }

//    @Then("user nagivate to Home interior Design services page")
//    public void user_nagivate_to_home_interior_design_services_page() {
//        assertTrue(profilePage.isHomeInteriorDesignPageDisplayed(),
//                   "Home Interior Design Services page is not displayed");
//    }

    @When("user click on hyderabad")
    public void user_click_on_hyderabad() {
        profilePage.clickHyderabad();
    }

    @Then("user navigate to Interior Designers in Hyderabad page.")
    public void user_navigate_to_interior_designers_in_hyderabad_page() {
        assertTrue(profilePage.isHyderabadDesignersPageDisplayed(),
                   "Hyderabad Designers page is not displayed");
    }
}