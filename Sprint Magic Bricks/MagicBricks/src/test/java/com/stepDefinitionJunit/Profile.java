package com.stepDefinitionJunit;

import java.util.Properties;

import org.testng.Assert;

import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Profile extends BaseSteps{
//	
//	
//	@Given("the user lauches the browser")
//	public void the_user_lauches_the_browser() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		launchBrowser();
//		System.out.println("Browse launched Successfully");
//		
//	}
//
//	@When("the user navigates to the application URL")
//	public void the_user_navigates_to_the_application_url() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		String currentURL=driver.getCurrentUrl();
//		Assert.assertNotNull("The current Url is null",currentURL);
//		Assert.assertTrue(!currentURL.trim().isEmpty());
//        System.out.println("Navigated to application URL: " + currentURL);
//
//		
//	}
//
//	@Then("the homepage should load successfully")
//	public void the_homepage_should_load_successfully() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		 String title = driver.getTitle();
//	        Assert.assertNotNull("Page title is null!", title);
//	        Assert.assertFalse(title.trim().isEmpty());
//	        System.out.println("Homepage loaded successfully with title: " + title);
//	}
//
//	@And("the application title should be displayed")
//	public void the_application_title_should_be_displayed() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		 Properties prop = PropertyReader.readProperty();
//	        //String expectedTitle = prop.getProperty("sourceTitle");
//
//	        String actualTitle = driver.getTitle();
//	    
//	       
//
//	        System.out.println("Application title verified: " + actualTitle);
//
//	        //Close the browser after verification
//	        driver.quit();
//	        System.out.println("Browser closed successfully.");
//
//	}
//

}
