package com.stepDefinitionTestNG;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LocHard;
import com.pages.PGPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Prolocal extends BaseSteps{

	Properties prop=PropertyReader.readProperty();
	HomePage homepage=new HomePage(driver);
	PGPage pgPage=new PGPage(driver);
	LocHard locl=new LocHard(driver);

	//	public Profile() {
	//        //this.driver = Hooks.getDriver(); // or however you're managing driver
	//        this.homePage = new HomePage(driver);
	//    }


	//new
	public  Prolocal() {
		//		 this.homepage=new Homepage(driver);
		//		 this.pgPage=new pgPage(driver);
		this.homepage=homepage;
		this.pgPage=pgPage;
		this.locl=locl;
	}
	
	
	
	@When("the user clicks on Rent tab")
	public void the_user_clicks_on_Rent_tab() throws InterruptedException
	{
		locl.clickonRent();
		
		
		
		
	}
	
	
	
	

	@And("the user enters PG locality city")
	public void the_user_enters_pg_locality( ) throws InterruptedException {
		
		
//		WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"refine_keyword\"]"));
		// Write code here that turns the phrase above into concrete actions
//		List<List<String>> data=dataTable.cells();
//		boolean status =userpage.getuname(data.get(1).get(0));
//		Assert.assertTrue(status);
		//new
//		driver.findElement(By.xpath("//*[@id=\"refine_keyword\"]"));
//		searchBar.sendKeys(city);
//		
 //new
		
		locl.clickonsearch();
	    //  locl.searchBar();
		//locl.enterLocality(locality);

	}

	@And("user clicks on search button")
	public void user_clicks_on_search_button() {
		// Write code here that turns the phrase above into concrete actions
		WebElement searchbtn=driver.findElement(By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[4]"));
		searchbtn.click();
	//	locl.clickFirstSuggestion();

	}

	@Then("the PG listings should be displayed for that locality")
	public void the_pg_listings_should_be_displayed_for_that_locality() {
		// Write code here that turns the phrase above into concrete actions

		if(driver.getTitle().equals("5042 PG in Bangalore"))
		{
			System.out.println(driver.getTitle());
		}
	}





}
