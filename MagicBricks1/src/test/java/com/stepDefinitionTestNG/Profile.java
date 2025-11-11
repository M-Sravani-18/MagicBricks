//package com.stepDefinitionTestNG;
// 
//import com.pages.HomePage;
//import com.setup.BaseSteps;
//import io.cucumber.java.en.*;
// 
//public class Profile extends BaseSteps {
//	HomePage pgPage;
//    @Given("the user launches the MagicBricks homepage")
//    public void the_user_launches_the_magic_bricks_homepage() {
//        openURL(); // This comes from your BaseSteps to open browser & URL
//        pgPage = new HomePage(driver);
//    }
// 
//    @When("the user hovers on the {string} dropdown")
//    public void the_user_hovers_on_the_dropdown(String dropdownName) {
//        pgPage.hoverOnRent();
//    }
// 
//    @When("the user clicks on the {string} option")
//    public void the_user_clicks_on_the_option(String optionName) throws InterruptedException {
//    	Thread.sleep(15);
//        pgPage.clickPGInBangalore();
//    }
// 
//    @Then("the PG listings page should be displayed with a list of PGs")
//    public void the_pg_listings_page_should_be_displayed_with_a_list_of_pgs(){
//        pgPage.verifyPGListPage();
//    }
// 
//    @When("the user clicks on the first PG from the list")
//    public void the_user_clicks_on_the_first_pg_from_the_list() {
//        pgPage.clickFirstPG();
//    }
// 
//    @Then("the PG details page should be displayed with property information")
//    public void the_pg_details_page_should_be_displayed_with_property_information() {
//        pgPage.verifyPGDetailsPage();
//    }
// 
//    @Then("the page should contain PG name, rent price, and contact button")
//    public void the_page_should_contain_pg_name_rent_price_and_contact_button() {
//        pgPage.verifyPGDetailsPage();
//    }
//}
// 
package com.stepDefinitionTestNG;
 
import com.pages.HomePage;
import com.setup.BaseSteps;
import io.cucumber.java.en.*;
 
public class Profile extends BaseSteps {
 
    HomePage pgPage;
 
    //  Launch MagicBricks homepage
    @Given("the user launches the MagicBricks homepage")
    public void the_user_launches_the_magic_bricks_homepage() {
        openURL(); // comes from BaseSteps
        pgPage = new HomePage(driver);
        System.out.println(" Opened MagicBricks homepage successfully.");
    }
 
    //  Hover on Rent dropdown
    @When("the user hovers on the {string} dropdown")
    public void the_user_hovers_on_the_dropdown(String dropdownName) {
        pgPage.hoverOnRent();
        System.out.println("Hovered over Rent dropdown.");
    }
 
    // Click on 'PG in Bangalore' option
    @When("the user clicks on the {string} option")
    public void the_user_clicks_on_the_option(String optionName) throws InterruptedException {
    	Thread.sleep(20);
        pgPage.clickPGInBangalore();
        System.out.println(" Clicked on 'PG in Bangalore' option.");
    }
 
    //  Click the first PG from listings
    @When("the user clicks on the first PG from the list")
    public void the_user_clicks_on_the_first_pg_from_the_listings() throws InterruptedException {
    	//Thread.sleep(15);
        pgPage.clickFirstPG();
        System.out.println("Clicked on the first PG from the listings.");
    }
 
    //  Verify PG details page
    @Then("the PG details page should be displayed with property information")
    public void the_pg_details_page_should_be_displayed_with_property_information() {
        pgPage.verifyPGDetailsPage();
        System.out.println("Verified PG details page displayed successfully.");
    }
}
 