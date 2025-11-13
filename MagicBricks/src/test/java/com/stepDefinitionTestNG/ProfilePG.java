package com.stepDefinitionTestNG;

import java.util.Properties;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.HomePage;
import com.pages.PGPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfilePG extends BaseSteps {
	
	Properties prop=PropertyReader.readProperty();
	HomePage homepage=new HomePage(driver);
	PGPage pgPage=new PGPage(driver);
	
//	public Profile() {
//        //this.driver = Hooks.getDriver(); // or however you're managing driver
//        this.homePage = new HomePage(driver);
//    }

	
		//new
	 public ProfilePG() {
//		 this.homepage=new Homepage(driver);
//		 this.pgPage=new pgPage(driver);
		 this.homepage=homepage;
		 this.pgPage=pgPage;
	 }
	//new	
	    
	@When("the user clicks on the Hostels in Bangalore option")
	public void the_user_clicks_on_the_pg() throws InterruptedException {
	
		pgPage.clickHostelsinBglr();
	}

	 
	@Then("verify text displayed on the page")
	public void validate_title_of_page_is_visible() {
//		String currenturl = homePage.getPageTitle();
//        Assert.assertTrue(currenturl.contains("pg-in-bangalore-pppfr"), "Url validation passed: ");
//		String actualUrl = BaseSteps.driver.getCurrentUrl();
//        String expectedUrl = PropertyReader.getProperty("");
//        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch!");
		
		
//		boolean status = HomePage.getPageTitle();
//	     Assert.assertTrue(status);
		
		if(driver.getTitle().equals("4530 Hostels in Bangalore"))
		{
			System.out.println(driver.getTitle());
		}
		driver.close();

	}
	 


}
