package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.ExcelReader;
import com.setup.BaseSteps;

public class SearchPage extends BaseSteps{
	
	@FindBy(id="tabPLOT")
	private WebElement plotclick;
	
//	WebDriver driver=BaseSteps.driver;
	
	public SearchPage() {
        PageFactory.initElements(driver, this);
    }
	
	public void clickPlot() {
		plotclick.click();
		
	}
	
		 // method to enter search details
	    public void enterSearchDetailsFromExcel() throws InterruptedException {
	    	
//	    	    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//	    	    	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    	    	    
	    	    	    String filePath = "C:\\Training Materials\\Sprint Magic Bricks\\MagicBricks\\src\\test\\resources\\Exceldata\\DataTest.xlsx";
	    	    	    String sheetName = "Sheet1";
	    	    	    
	    	    	    List<String[]> testData = ExcelReader.readExcelData(filePath, sheetName);
	    	    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	    	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    	    	    
	    	    	    for (String[] row : testData) {
	    	    	        String city = row[0];
	    	    	        String budget = row[1];

	    	    	        System.out.println("🔍 Starting search for → City: " + city + ", Budget: " + budget);
	    	    	        
	    	    	     // Step 1: Enter city
	    	    	        WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'mb-search__input')]")));
	    	    	      //  WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#keyword")));
	    	    	        locationInput.clear();
	    	    	        locationInput.sendKeys(city);    	    	      
	    	    	        
	    	    	        try {
	    	    	            
	    	    	        	WebElement budgetDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".buy_budget_lbl")));
	    	    	            budgetDropdown.click(); // Open dropdown
	    	    	            Thread.sleep(1000); // Allow options to render

	    	    	       
	    	    	            String budgetXPath = String.format("//div[contains(text(),'%s')]", budget);
	    	    	            System.out.println("Trying to select budget: " + budget);

	    	    	            
	    	    	            WebElement budgetOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(budgetXPath)));
	    	    	            budgetOption.click(); // Select the budget option

	    	    	            System.out.println("✅ Budget selected: " + budget);

	    	    	        } catch (Exception e) {
	    	    	            System.out.println("❌ Budget selection failed for value: " + budget + " → " + e.getMessage());
	    	    	            throw e;
	    	    	        }
	    	    	        
	    	    	    }    	    	       
	    	    	        
	    	    	    }  
	    	    	     
	
	public void clickOnSearch() {
		
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mb-search__btn")));
		        searchBtn.click();
//		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
//		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);

		        System.out.println("Search clicked. Waiting for 10 seconds...");

		        // ⏳ Wait for 10 seconds before closing
		        Thread.sleep(10000);

		        System.out.println("Done waiting. Closing browser now.");
		        driver.quit();

		    } catch (Exception e) {
		        System.out.println("Something went wrong: " + e.getMessage());
		        driver.quit(); // Ensure browser closes even on failure
		        throw new RuntimeException(e);
		    }

		
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // ⬅️ Place it here
//		  
//		  driver.findElement(By.cssSelector("div.mb-search__btn")).click();
		  
	}

//          try {
//              WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mb-search__btn"))).click();;
////              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
////              ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
//
//              //System.out.println("✅ Search executed successfully for: " + city + " - " + budget);
//
//              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Properties')]")));
//
//          } catch (Exception e) {
//              System.out.println("❌ Search button or results page failed: " + e.getMessage());
//              throw e;
//          }
//      }

      
	
	
	
	public void navigateToSearchResultPage() {
		
	}
	
	public void clickOnFirstProperty() {
		
	}
	
	public void rederictedToTheSelectedProperty() {
		
	}
	
	public void navigatesToPropertiesForSale() {
		
	}
	
	
	
	
	
	

}
