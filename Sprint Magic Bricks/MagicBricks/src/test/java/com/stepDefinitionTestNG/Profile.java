package com.stepDefinitionTestNG;

import java.util.List;
import java.util.Properties;

import org.testng.Assert;

import com.pages.HomePage;
import com.pages.SearchPage;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps{
	
	Properties prop = PropertyReader.readProperty();
	
	//==========================================================  Scenario1-UserPage  =========================================================================
	
	UserPage userpage=new UserPage();
	
	
	@Given("the user lauches the browser")
	public void the_user_lauches_the_browser() {
		System.out.println("User is on the HomePage Of tthe Magic Bricks");
		
	}

	@When("the user navigates to the application URL")
	public void the_user_navigates_to_the_application_url() {
		userpage.navigateToTheApplication();

		
	}

	@Then("the homepage should load successfully")
	public void the_homepage_should_load_successfully() {
	    		userpage.verifyHomepageLoaded();
	}

	@And("the application title should be displayed")
	public void the_application_title_should_be_displayed() {
		userpage.verifyApplicationTitle();
	        

	}
	
	@Then("the plot is displayed")
	public void the_plot_is_displayed() {
		userpage.verifyPlotDisplayed();
		
		
	}
	
	@Then("the plot is clickable")
	public void the_plot_is_clickable() {
userpage.verifyPlotClickable();

	
	}
	
	@When("user click on the Plots in Gated Community")
	public void user_click_on_the_plots_in_gated_community() {
		userpage.clickOnPltsInGatedCommunity();
	}

	
	
	
	//==========================================================  Scenario2-HomePage  ==========================================================================
	
	
	
HomePage homepage=new HomePage();
	
	@Given("user on the Homepage")
	public void user_on_the_homepage() {
	    System.out.println("User is on the HomePage");
	}

	@Then("click on plot")
	public void click_on_plot() {
	   
		homepage.clickPlot();
	}

	@Then("It displays presenting plots and lands in Bangalore")
	public void it_displays_presenting_plots_and_lands_in_bangalore() {
	   
		homepage.displayPresentingPlotsandLandInBangalore();
	}

	@When("user clicks on East Facing Plots Explore button")
	public void user_clicks_on_east_facing_plots_explore_button() {
	    
		homepage.clickEastFacingPlots();
	}

	@Then("user goes to the East Facing Plots listing page")
	public void user_goes_to_the_east_facing_plots_listing_page() {
	    
		System.out.println("User is on the East facing page");
	}

	@Then("select on the New projects")
	public void select_on_the_new_projects() {
	    
		homepage.clickOnNewProjects();
	}

	@Then("New projects page is loaded")
	public void new_projects_page_is_loaded() {
	    System.out.println("Navigated to the New Projects See plots Successfully");
	}

	
	
	//==========================================================  Scenario3-SearchPage  ==========================================================================
	
		
	SearchPage searchpage=new SearchPage();
	

	@Given("the user is on the Homepage of the magicBricks")
	public void the_user_is_on_the_homepage_of_the_magic_bricks() {
		System.out.println("User is on the home page");
	}

	@When("the user clicks on the plot option")
	public void the_user_clicks_on_the_plot_option() {
		searchpage.clickPlot();
		
	}
	
	@When("click on the see plots1")
	public void click_on_the_see_plots1() {
		searchpage.clickSeePlots1();
	}

	@Then("navigate to the plots page and click click on the seeplots2")
	public void navigate_to_the_plots_page_and_click_click_on_the_seeplots2() {
		searchpage.clickSeePlots2();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

	//==============================================================================================
	//===============================================================================================
	//================================================================================================
	
	
	@Given("the user on the Homepage")
	public void the_user_on_the_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Given("enter budget in the budget box {int} {int}")
	public void enter_budget_in_the_budget_box(Integer row, Integer sheet) throws InterruptedException {
		
String excelPathSO = prop.getProperty("excelpath").trim();
		
		// Fetch locality from specific sheet and row
		String nameOfCity = ExcelReader.getLocalityByRow(excelPathSO, sheet, row);
		Assert.assertNotNull(nameOfCity, "Locality not found at sheet " + sheet + ", row " + row);
		System.out.println("City from Excel:" + nameOfCity);
		//Assert.assertNotNull(userpage, "UserPage object is not initialized");
		
		searchpage.enteringCityname(nameOfCity);
		//searchpage.enteringCityname(nameOfCity);
		
		searchpage.clickSearch();
		driver.quit();
	}
	
	
	
 

	
	

//===============================================================================================================
//        5th Scenario                                                                                          
//===============================================================================================================



//	@Given("click on the RatesAndTrends")
//	public void click_on_the_rates_and_trends() {
//		
//		
//	    
//	}
//
//		
//@Given("the user enter the data in Rate And Trends {int} {int}")
//public void the_user_enter_the_data_in_rate_and_trends(Integer sheetIndex, Integer rowIndex) {
//	
//	
//	searchpage.scrollUptoRatesAndTrends();
//	
//	 String excelPath = prop.getProperty("excelratepath").trim();
//	    
//	    // Read locality from Excel
//	    String locality = ExcelReader.getLocalityByRow(excelPath, sheetIndex, rowIndex);
//	    Assert.assertNotNull(locality, "Locality not found at sheet " + sheetIndex + ", row " + rowIndex);
//
//	    System.out.println("Locality from Excel: " + locality);
//
//	    // Send locality to SearchPage method
//	    boolean success = searchpage.readAndEnterRatesAndTrendsData(locality);
//	    Assert.assertTrue(success, "Failed to enter locality in Rates & Trends");
//
//	
//	
//	
//	    // Optional: driver.quit(); only if this is the end of the scenario
//
//	
//}

		
	//===========================

@Given("user is on the home page")
public void user_is_on_the_home_page() {
	
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
}

@Given("the user clicks on plot")
public void the_user_clicks_on_plot() {
	searchpage.clickPlot();
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
}

@Given("user clicks Budget")
public void user_clicks_budget() {
	 searchpage.clickBudget();
	    System.out.println("Clicked on budget.");

    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
}

@Given("the user reads price from the excel sheet {int} {int}")
public void the_user_reads_price_from_the_excel_sheet(Integer sheetIndex, Integer rowIndex) {
	String excelPath = prop.getProperty("path");
    ExcelReader reader = new ExcelReader();
    String price = reader.getLocalityByRow(excelPath, sheetIndex, rowIndex);
    System.out.println("Price from Excel: " + price);
    searchpage.enterBudget(price);

    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
}

@Given("click on search")
public void click_on_search() {
//	searchpage.clickSearch();
//    System.out.println("Clicked on search.");

    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
}

@Then("result is displayed")
public void result_is_displayed() {
//	boolean resultVisible = searchpage.isResultDisplayed();
//    Assert.assertTrue(resultVisible, "Result is not displayed.");
//    System.out.println("Result is displayed.");
//
//    // Write code here that turns the phrase above into concrete actions
//   // throw new io.cucumber.java.PendingException();
//}

	
}
	
		
}

	
	
	

	


