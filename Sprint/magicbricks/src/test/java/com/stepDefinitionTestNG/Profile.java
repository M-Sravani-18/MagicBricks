package com.stepDefinitionTestNG;
 
import com.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class Profile {
 
   HomePage home;
 
    @Given("the user launches the MagicBricks homepage")
    public void the_user_launches_the_magicbricks_homepage() {
        // Already opened in Hooks for fresh sessions; keep idempotent:
        Hooks.home.openBaseUrl();
    }
 
    @When("the user clicks on the MB Advice section")
    public void the_user_clicks_on_the_mb_advice_section() throws InterruptedException {
       Hooks. home.clickMbAdviceSection();
    }
 
    @And("the user selects Localities in New Delhi page")
    public void the_user_selects_localities_in_new_delhi_page() throws InterruptedException {
        Hooks.home.selectLocalitiesNewDelhi();
    }
 
    @Then("the user clicks on the first displayed locality")
    public void the_user_clicks_on_the_first_displayed_locality() throws InterruptedException {
        Hooks.home.clickFirstLocalityCard();
    }
}