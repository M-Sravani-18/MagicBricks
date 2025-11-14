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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Profile {
   HomePage home;
   Hooks hooks;
   WebDriver driver = Hooks.driver;
   private String locationValue;
   String excelPath = "src/test/resources/TestData/MagicBricksData.xlsx";
   String minPriceValue;
   String maxPriceValue;
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
    @When("the user selects Compare Localities")
    public void the_user_selects_compare_localities() {
    	Hooks.home.openCompareLocalitiesPage();
    }
    @Then("the Compare Localities page should launch")
    public void the_compare_localities_page_should_launch() {
    	Hooks.home.verifyCompareLocalitiesPage();
    }
    @When("the user clicks on the Price\\/sqrt filter option")
    public void the_user_clicks_on_the_price_sqrt_filter_option() {
        Hooks.home.clickPriceSqftFilter();
        System.out.println(" Price/Sqft filter clicked");
    }

    @When("the user reads Min price values from Excel sheet {int} and row {int}")
    public void the_user_reads_min_price_values_from_excel_sheet_and_row(Integer sheetIndex, Integer rowIndex) {
        try {
            ExcelReader reader = new ExcelReader();
            List<String> priceValues = reader.getRowData(excelPath, sheetIndex, rowIndex);
            minPriceValue = priceValues.get(0); // e.g., "5,000" or "10,000"
            System.out.println(" Min Price read from Excel: " + minPriceValue);
        } catch (Exception e) {
            Assert.fail(" Failed to read Min price from Excel: " + e.getMessage());
        }
    }

    @When("the user clicks on the Done")
    public void the_user_clicks_on_the_done() {
        try {
            Hooks.home.selectMinPriceAndClickDone(minPriceValue);
        } catch (Exception e) {
            Assert.fail(" Error clicking DONE: " + e.getMessage());
        }
    }

    @Then("the result is displayed")
    public void the_result_is_displayed() {
        try {
            // Validate that results are updated (basic check: property cards exist)
            List<WebElement> results = Hooks.driver.findElements(By.xpath("//*[@id=\"autoLoadLocalities\"]/div[1]/div[1]"));
            Assert.assertTrue(results.size() > 0, " No results displayed after applying filter");
            System.out.println(" Results displayed successfully");
        } catch (Exception e) {
            Assert.fail(" Failed to verify results: " + e.getMessage());
        }
    }
//----------------------4th scenario outline --------------------------------//

@When("the user clicks on search box")
public void the_user_clicks_on_search_box() {
    Hooks.home.clickSearchBox();
    System.out.println("Clicked on search box.");
}


    @When("the user reads City from Excel sheet {int} and {int}")
    public void the_user_reads_city_from_excel_sheet_and(Integer sheet, Integer row) {
        ExcelReader reader = new ExcelReader();
        List<String> rowData = reader.getRowData(excelPath, sheet, row);
        String city = rowData.get(0);
        Hooks.home.enterCityInSearch(city);
        System.out.println("City from Excel: " + city);
    }
    


@Then("the locality page displays")
public void the_locality_page_displays() {
Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("localities"),"Locality page not displayed!");

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
        System.out.println("New Projects page displayed successfully.");
    }
}