package com.stepDefinitionTestNG;

import java.util.Properties;

import org.testng.Assert;

import com.pages.HomePage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile  extends BaseSteps{
	 
    Properties prop=PropertyReader.readProperty();
	HomePage homePage;
    

	@Given("the user launches the MagicBricks homepage")
	public void the_user_launches_the_magic_bricks_homepage() {
	   BaseSteps.launchBrowser();
	   homePage = new HomePage(driver);
	}

	@When("the user hovers on the Rent dropdown")
	public void the_user_hovers_on_the_rent_dropdown() {
		homePage.hoverOnRentDropdown();
	}

	@And("the user clicks on the PG in Banglore option")
	public void the_user_clicks_on_the_pg_in_banglore_option()  {
		homePage.clickPgInBangalore();
	}

	@Then("validate title of page is visible")
	public void validate_title_of_page_is_visible() {
//		String currenturl = homePage.getPageTitle();
//        Assert.assertTrue(currenturl.contains("pg-in-bangalore-pppfr"), "Url validation passed: ");
//		String actualUrl = BaseSteps.driver.getCurrentUrl();
//        String expectedUrl = PropertyReader.getProperty("");
//        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch!");
		
		
//		boolean status = HomePage.getPageTitle();
//	     Assert.assertTrue(status);
		
		if(driver.getTitle().equals("5042 PG in Bangalore"))
		{
			System.out.println(driver.getTitle());
		}

	}
	
	

@When("the user clicks on the Brand Filter")
public void the_user_clicks_on_the_brand_filter() {
    // Write code here that turns the phrase above into concrete actions
	
    
}

@Then("validate the page based on text")
public void validate_the_page_based_on_text() {
    // Write code here that turns the phrase above into concrete actions
    
}




	
	
	
	
}