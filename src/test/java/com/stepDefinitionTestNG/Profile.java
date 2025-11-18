package com.stepDefinitionTestNG; 
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.pages.HomePage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;
import com.setup.Reports;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Profile extends BaseSteps {
   HomePage home;
   Hooks hooks;
   WebDriver driver = Hooks.driver;
   private String locationValue;
   String minPriceValue;
   
    @Given("the user launches the MagicBricks homepage")
    public void the_user_launches_the_magicbricks_homepage() {
        Hooks.home.openBaseUrl();
    }
    @When("the user clicks on the MB Advice section")
    public void the_user_clicks_on_the_mb_advice_section() throws InterruptedException {
       Hooks. home.clickMbAdviceSection();
    }
    @And("the user selects Localities in New Delhi page")
    public void the_user_selects_localities_in_new_delhi_page() {
        Hooks.home.selectLocalitiesNewDelhi();
    }
    @And("the user clicks on the first displayed locality")
    public void the_user_clicks_on_the_first_displayed_locality() throws InterruptedException {
        Hooks.home.clickFirstLocalityCard();
    }  
    @Then("the first locality page is displayed")
    public void the_first_locality_page_is_displayed() {
    boolean isDisplayed = Hooks.home.isLocalityPageDisplayed();
    Assert.assertTrue(isDisplayed, "Locality page is not displayed as expected.");
    Reports.captureScreenshot(Hooks.home.driver, "Homepage");
}

//------second scenario-------------------------------------------------------------------------//

    @When("the user clicks on Compare Localities")
    public void the_user_clicks_on_compare_localities() {
        Hooks.home.clickCompareLocalities();
    }


    @Then("the compare localities should launch")
    public void the_compare_localities_should_launch() {
        boolean pageLoaded =Hooks.home.isCompareLocalitiesPageLoaded();  
      //  Assert.assertTrue(pageLoaded,"Error is displayed");
        Reports.captureScreenshot(Hooks.home.driver, "Projectsindelhi");
    }



//-----Third scenario-------------------------------------------------------------------------------------//

@When("the user clicks on the Price\\/sqrt filter option")
public void the_user_clicks_on_the_price_sqrt_filter_option() {
    Hooks.home.clickPriceSqftFilter();
    System.out.println(" Price/Sqft filter clicked");
}

@When("the user reads Min price values from Excel sheet {int} and row {int}")
public void the_user_reads_min_price_values_from_excel_sheet_and_row(Integer sheetIndex, Integer rowIndex) {
	String excelPath ="src/test/resources/TestData/MagicBricksData.xlsx";
    ExcelReader reader = new ExcelReader();
    List<String> priceValues = reader.getRowData(excelPath, sheetIndex, rowIndex);
    minPriceValue = priceValues.get(0); // e.g., "5,000" or "10,000"
    System.out.println(" Min Price read from Excel: " + minPriceValue);
}

@When("the user clicks on the Done")
public void the_user_clicks_on_the_done() {
    Hooks.home.selectMinPriceAndClickDone(minPriceValue);
}

@Then("the result is displayed")
public void the_result_is_displayed() {
    // Validate that results are updated (basic check: property cards exist)
    List<WebElement> results = Hooks.driver.findElements(By.xpath("//*[@id=\"autoLoadLocalities\"]/div[1]/div[1]"));
    Assert.assertTrue(results.size() > 0, " No results displayed after applying filter");
    System.out.println(" Results displayed successfully");
    Reports.captureScreenshot(Hooks.home.driver, "price/sqrtfilter");
}

    

//----------------------4th scenario outline --------------------------------//

@When("the user clicks on search box")
public void the_user_clicks_on_search_box() {
    Hooks.home.clickSearchBox();
    System.out.println("Clicked on search box.");
}


    @When("the user reads City from Excel sheet {int} and {int}")
    public void the_user_reads_city_from_excel_sheet_and(Integer sheet, Integer row) {
    	String excelPath ="src/test/resources/TestData/MagicBricksData.xlsx";
        ExcelReader reader = new ExcelReader();
        List<String> rowData = reader.getRowData(excelPath, sheet, row);
        String city = rowData.get(0);
        Hooks.home.enterCityInSearch(city);
        System.out.println("City from Excel: " + city);
    }
    
     @Then("the locality page displays")
     public void the_locality_page_displays() {
     Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("localities"),"Locality page not displayed!");
     Reports.captureScreenshot(Hooks.home.driver, "ExcelReader");

}

   
    //--------------------5th scenario ---------------------------//
    @When("the user selects New Projects in New Delhi page")
    public void the_user_selects_new_projects_in_new_delhi_page() {
        // Hover over MB Advice and click New Projects in New Delhi
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(Hooks.home.getMbAdviceMenu()).pause(Duration.ofSeconds(2)).perform();
        Hooks.home.selectNewProjects(); // This method handles hover + click + wait
    }

    @Then("the page should be displayed")
    public void the_page_should_be_displayed() {
        // Validate that the New Projects page is displayed
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("new-projects"), "New Projects page not displayed!");
        Reports.captureScreenshot(Hooks.home.driver, "Projectsindelhi");
        System.out.println("New Projects page displayed successfully.");
    }
 
//-----------------------6th scenario ------------------------------------------//

	//id="location-error-id"
    @When("the user enters an invalid location from properties")
    public void the_user_enters_an_invalid_location_from_properties() {
        // Read invalid location from properties file
        String invalidLocation = Hooks.prop.getProperty("invalid_location");
        
        // Use HomePage method to enter the location
        Hooks.home.enterSearch(invalidLocation);
        System.out.println("Entered invalid location: " + invalidLocation);
    }

    @Then("an error message should be displayed from properties")
    public void an_error_message_should_be_displayed_from_properties() {
        Assert.assertTrue(Hooks.home.isErrorMessageDisplayed(), "Error message is not displayed!");
        Reports.captureScreenshot(Hooks.home.driver, "invalidMagicBricks");
        
    }

   
}