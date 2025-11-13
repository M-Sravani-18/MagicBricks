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

public class Profile{
	
	Properties prop = PropertyReader.readProperty();
	
	
	
	UserPage userpage=new UserPage();
	
	@Given("the user lauches the browser")
	public void the_user_lauches_the_browser() {
		userpage.launchBrowserPage();
		
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
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		userpage.verifyPlotDisplayed();
		
		
	}
	
	@Then("the plot is clickable")
	public void the_plot_is_clickable() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
userpage.verifyPlotClickable();

	
	}
	
	@When("user click on the Plots in Gated Community")
	public void user_click_on_the_plots_in_gated_community() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		userpage.clickOnPltsInGatedCommunity();
	}

	
	// =========================================================================================================
	
	
HomePage homepage=new HomePage();
	
	@Given("user on the Homepage")
	public void user_on_the_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("click on plot")
	public void click_on_plot() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		homepage.clickPlot();
	}

	@Then("It displays presenting plots and lands in Bangalore")
	public void it_displays_presenting_plots_and_lands_in_bangalore() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		//System.out.println("Presenting plots and lands in Bangalore");
		homepage.displayPresentingPlotsandLandInBangalore();
	}

	@When("user clicks on East Facing Plots Explore button")
	public void user_clicks_on_east_facing_plots_explore_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		homepage.clickEastFacingPlots();
	}

	@Then("user goes to the East Facing Plots listing page")
	public void user_goes_to_the_east_facing_plots_listing_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("User is on the East facing page");
	}

	@Then("select on the New projects")
	public void select_on_the_new_projects() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		homepage.clickOnNewProjects();
	}

	@Then("New projects page is loaded")
	public void new_projects_page_is_loaded() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	
	
	//================================================================================================================
	
	
	
	
	SearchPage searchpage=new SearchPage();

	@Given("the user is on the Homepage of the magicBricks")
	public void the_user_is_on_the_homepage_of_the_magic_bricks() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the plot option")
	public void the_user_clicks_on_the_plot_option() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		searchpage.clickPlot();
		
	}
	
	@When("enters the search data in the search bar")
	public void enters_the_search_data_in_the_search_bar_sheet_no() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		searchpage.enterSearchDetailsFromExcel();
	}


//	@When("enters the search data in the search bar{int}")
//	public void enters_the_search_data_in_the_search_bar(Integer SheetNo) throws InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		searchpage.enterSearchDetailsFromExcel();
//	}

	@When("clicks on the search button")
	public void clicks_on_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		searchpage.clickOnSearch();
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
	}
	
	
 
//	@When("user clicks on search button")
//	public void user_clicks_on_search_button() {
		
		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//		
//String excelPathSO = prop.getProperty("excelpath").trim();
//		
//		// Fetch locality from specific sheet and row
//		String nameOfCity = ExcelReader.getLocalityByRow(excelPathSO, sheetIndex, rowIndex);
//		Assert.assertNotNull(nameOfCity, "Locality not found at sheet " + sheetIndex + ", row " + rowIndex);
//		System.out.println("City from Excel:" + nameOfCity);
//		//Assert.assertNotNull(userpage, "UserPage object is not initialized");
//		
//		userpage.enteringCityname(nameOfCity);
		
		
		
		
		

		
		
		
		
		
		
		
		
	}
	
//		    // Step 1: Read Excel data
//		    String excelPath = prop.getProperty("excelFilePath");
//		    ExcelReader reader = new ExcelReader(excelPath);
//		    List<String> rowData = reader.getRowData(sheet, row);
//
//		    // Step 2: Validate row data
//		    if (rowData == null || rowData.isEmpty()) {
//		        throw new RuntimeException("No data found at sheet " + sheet + ", row " + row);
//		    }
//
//		    // Step 3: Extract budget value
//		    String budget = rowData.get(0).trim(); // Column A (Budget)
//
//		    // Step 4: Select property type (Plot)
//		    searchpage.clickPlot();
//
//		    // Step 5: Select budget
//		    boolean status = searchpage.clickBudgetFilter(budget);
//		    Assert.assertTrue(status, "Budget selection failed for: " + budget);
//		}
//
////	    // Write code here that turns the phrase above into concrete actions
////	    //throw new io.cucumber.java.PendingException();
////		
////		 //   Step 1: Read Excel data
////	    String excelPath = prop.getProperty("excelFilePath");
////	    ExcelReader reader = new ExcelReader(excelPath);
////	    List<String> rowData = reader.getColumnData(sheet, row);
////
////	    // Step 2: Extract budget value
////	    String budget = rowData.get(0); // Column A (Budget)
////
////		searchpage.clickPlot();
////
////	    // Step 4: Select budget
////	    boolean status = searchpage.clickBudgetFilter(budget);
////	    Assert.assertTrue(status, "Budget selection failed for: " + budget);
//	}
//
//    // Write code here that turns the phrase above into concrete actions
//    //throw new io.cucumber.java.PendingException();
//
//		
		
		
		
	
	
	
	
		


	
	
	

	


