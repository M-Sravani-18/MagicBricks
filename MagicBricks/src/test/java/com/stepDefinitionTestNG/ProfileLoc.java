package com.stepDefinitionTestNG;

import java.util.Properties;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.HomePage;
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
	HomePage homepage;
	PGPage pgPage=new PGPage(driver);
	LocalPage local=new LocalPage(driver);




	@When("the user enters PG locality from sheet {int} and row {int}")
	public void the_user_enters_pg_locality_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) {
		String excel=PropertyReader.getProperty("excelPath");
		String locality = ExcelReader.getLocalityByRow(excel, sheetIndex, rowIndex);
		
		local.enterLocality(locality);

		// Enter locality in the search box
		//HomePage homepage = new HomePage(driver);
		//local.enterLocality(locality);
		
		





	}

	@And("the user selects the city from suggestions")
	public void the_user_selects_the_city_from_suggestions() {
		// HomePage homepage = new HomePage(driver);
		local.selectFirstSuggestion();
		local.selectSecondSuggestion();
		local.selectThirdSuggestion();



	}

	@Then("it should display PG listings in that locality")
	public void it_should_display_pg_listings_in_that_locality() {

		PGPage pgPage = new PGPage(driver);
		boolean listingsVisible = local.getPageTitle();

		Assert.assertTrue(listingsVisible, "PG listings were not displayed for the selected locality.");




	}





}


