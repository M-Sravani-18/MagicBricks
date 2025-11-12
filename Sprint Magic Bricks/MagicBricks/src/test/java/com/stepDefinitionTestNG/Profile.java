package com.stepDefinitionTestNG;

import java.util.Properties;

import org.testng.Assert;

import com.pages.UserPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends UserPage {
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

	

}
