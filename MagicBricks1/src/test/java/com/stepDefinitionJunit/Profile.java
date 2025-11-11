//package com.stepDefinitionJunit;
// 
//import com.pages.BasePage;
//import com.parameters.PropertyReader;
//import com.setup.BaseSteps;
//import io.cucumber.java.en.*;
//import static org.junit.Assert.*;
// 
//public class Profile extends BaseSteps {
// 
//    BasePage basePage;
// 
//    @Given("the user opens the configured browser")
//    public void open_browser() {
//        PropertyReader.loadProperties();
//        openBrowser();
//        basePage = new BasePage();
//    }
// 
//    @When("the user navigates to the configured application URL")
//    public void open_url() {
//        openURL();
//    }
// 
//    @And("the homepage should be displayed")
//    public void verify_homepage() {
//        assertTrue(basePage.getCurrentURL()
//                .startsWith(PropertyReader.get("sourceUrl")));
//    }
// 
//    @Then("the page title should be verified")
//    public void verify_title() {
//        assertTrue(basePage.getPageTitle()
//                .contains(PropertyReader.get("expectedTitle")));
//    }
//}
// 
// 