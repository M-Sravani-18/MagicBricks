package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.HomePage;
import com.pages.LocHard;
import com.pages.LocalPage;
import com.pages.PGPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileLoc extends BaseSteps {

	Properties prop=PropertyReader.readProperty();
	HomePage homepage=new HomePage(driver);
	PGPage pgPage=new PGPage(driver);
	LocHard locl=new LocHard(driver);
	LocalPage local=new LocalPage(driver);

	public  ProfileLoc() {
		//		 this.homepage=new Homepage(driver);
		//		 this.pgPage=new pgPage(driver);
		this.homepage=homepage;
		this.pgPage=pgPage;
		this.locl=locl;
		this.local=local;
	}
	//

	@When("the user clicks on Rent tab")
	public void the_user_clicks_on_Rent_tab() throws InterruptedException
	{



		locl.clickonRent();
	}




	@When("the user enters PG locality city from sheet {int} and row  {int}")
	public void the_user_enters_pg_locality_city_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) {
		String filepath = prop.getProperty("excelPath");
		String localities = ExcelReader.getLocalityByRow(filepath, sheetIndex, rowIndex);
		Assert.assertNotNull(localities, "Locality not found at sheet " + sheetIndex + ", row " + rowIndex);
		System.out.println("City from Excel:" + localities);

		local.enterLocality(localities);
	}




	@And("user clicks on search button")
	public void user_clicks_on_search_button() throws InterruptedException {
		//	locl.clickFirstSuggestion();
		local.searchButton();



	}



	@Then("it should display PG listings in that locality")
	public void it_should_display_pg_listings_in_that_locality() {

		PGPage pgPage = new PGPage(driver);
		boolean listingsVisible = local.getPageTitle();

		Assert.assertTrue(listingsVisible, "PG listings were not displayed for the selected locality.");




	}





}


