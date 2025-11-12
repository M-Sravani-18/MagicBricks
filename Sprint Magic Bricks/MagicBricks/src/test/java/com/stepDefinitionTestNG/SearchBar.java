package com.stepDefinitionTestNG;

import com.pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBar {
	
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
	
	@When("enters the search data in the search bar<SheetNo>")
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

	@Then("the user should be navigated to the Search Result page")
	public void the_user_should_be_navigated_to_the_search_result_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on the first property details page")
	public void user_clicks_on_the_first_property_details_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the selected property details page")
	public void the_user_should_be_redirected_to_the_selected_property_details_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("navigates to the properties foe sale sale section")
	public void navigates_to_the_properties_foe_sale_sale_section() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}


}
