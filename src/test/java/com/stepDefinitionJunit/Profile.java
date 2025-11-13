package com.stepDefinitionJunit;
 
import org.testng.Assert;
 
import com.setup.BaseSteps;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class Profile {
	@Given("the user opens the configured browser")
	public void the_user_opens_the_configured_browser() {
		BaseSteps.launchBrowser();  
		// Launch browser using BaseSteps
	    
	}
 
	@When("the user navigate to the configured application URL")
	public void the_user_navigate_to_the_configured_application_url() {
 
		 // Already handled in launchBrowser() because driver.get(url) is called there
		   System.out.println("Navigated to application URL");
 
	   
	}
 
	@Then("the homepage should be displayed")
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
    
	}
 
 