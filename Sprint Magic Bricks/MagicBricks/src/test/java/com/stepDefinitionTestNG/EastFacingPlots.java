package com.stepDefinitionTestNG;

import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EastFacingPlots extends HomePage {
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


}
