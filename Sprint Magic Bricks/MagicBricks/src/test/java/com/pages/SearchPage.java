package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class SearchPage extends BaseSteps{
	
	Properties prop = PropertyReader.readProperty();
	
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
	    	
	    	    	    
	    	    	    //String filePath = "C:\\Training Materials\\Sprint Magic Bricks\\MagicBricks\\src\\test\\resources\\Exceldata\\DataTest.xlsx";
	    	String path1=prop.getProperty("filePath");
	    	    	    String sheetName = "Sheet1";
	    	    	    //String browser = prop.getProperty("browserName"); 
	    	    	    
	    	    	    
	    	    	    List<String[]> testData = ExcelReader.readExcelData(path1, sheetName);
//	    	    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    	    	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    	    	    
	    	    	    for (String[] row : testData) {
	    	    	        String city = row[0];
	    	    	        String budget = row[1];

	    	    	        System.out.println("Starting search for  City: " + city + ", Budget: " + budget);
	    	    	        
	    	    	     // Launch browser inside the loop
	    	    	        launchBrowser(); // make sure this returns a WebDriver
	    	    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    	    	    JavascriptExecutor js = (JavascriptExecutor) driver;
		    	    	    
	    	    	        
	    	    	        try {
	    	    	        
	    	    	     // Step 1: Enter city
	    	    	        WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'mb-search__input')]")));
	    	    	      //  WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#keyword")));
	    	    	        locationInput.clear();
	    	    	        locationInput.sendKeys(city); 
	    	    	        
	    	    	        
	    	    	        WebElement budgetDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".buy_budget_lbl")));
   	    	            budgetDropdown.click(); // Open dropdown
  	    	            Thread.sleep(1000); // Allow options to render
	    	    	        
	    	    	        //Step 2: Select budget dynamically
	    	    	        String budgetXPath = "";

	    	    	        if (budget.equalsIgnoreCase("5 Lac")) {
	    	    	        	budgetXPath = String.format("//div[contains(@class,'mb-search__min-max__item') and contains(text(),'₹%s')]", budget);

	    	    	            //budgetXPath = "//li[contains(text(),'5 Lac')]";
	    	    	        } else if (budget.equalsIgnoreCase("10 Lac")) {
	    	    	        budgetXPath = "//div[contains(@class,'mb-search__min-max__item') and contains(text(),'₹10 Lac')]";

	    	    	            //budgetXPath = "//div[contains(text(),'10 Lac')]";
	    	    	        } else {
	    	    	            budgetXPath = String.format("//*[contains(text(),'%s')]", budget);
	    	    	        }

	    	    	        WebElement budgetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(budgetXPath)));
	    	    	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", budgetElement);
	    	    	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", budgetElement);
	    	    	        System.out.println(" Budget selected: " + budget);

	    	    	        // Step 3: Click the search button
	    	    	        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mb-search__btn")));
	    	    	       // WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mb-search__btn")));
	    	    	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
	    	    	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
	    	    	        System.out.println("Search clicked for: " + city + " - " + budget);


	    	    	     // ⏳ Step 4: Wait for 10 seconds
	    	    	        Thread.sleep(10000);
	    	    	        System.out.println("Waited 10 seconds after search");
	    	    	   
	    } catch (Exception e) {
	        System.out.println("Error during search for: " + city + " - ₹" + budget + " → " + e.getMessage());
	    } finally {
	        driver.quit(); // Always close browser
	        System.out.println("Browser closed for: " + city);
	    }


	    	    	    
	    	    	    }

	    }    	    	            	    	     
	
	public void clickOnSearch() {
		
		System.out.println("Search clicked suucessfully");
		
		  
	}  
	
	//==================================================================================================================
	// 4 Scenario 
	//=================================================================================================================
	
	
	
	
	@FindBy(xpath = "//input[contains(@class,'mb-search__input")
	WebElement inputFields;
	
	@FindBy(css = "div.mb-search__btn")
	WebElement searchButton;
	


      public boolean enteringCityname(String cname) throws InterruptedException
      {
    	  try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			wait.until(ExpectedConditions.visibilityOf(inputFields));
			wait.until(ExpectedConditions.elementToBeClickable(inputFields));
			inputFields.clear();
			inputFields.click();
			inputFields.sendKeys(cname);
			BaseSteps.sleep(3000);
			return true;
		  } catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		  }
			
      }
      
      
      public boolean clickSearch()
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//
				wait.until(ExpectedConditions.elementToBeClickable(searchButton));
				searchButton.click();
				BaseSteps.sleep(5000);
				return true;
			}

			catch (Exception e) {
				System.out.println("Error clicking Search button: " + e.getMessage());
				return false;
			}

		}

	
	
	
//	public boolean enterCityAndSearch(String city) {
//	    boolean result = true;
//	    try {
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	        // Step 1: Enter city name
//	        WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'mb-search__input')]")));
//	        locationInput.clear();
//	        locationInput.sendKeys(city);
//	        locationInput.sendKeys(Keys.ENTER);
//
//	        Thread.sleep(2000); // Let suggestions load
//
//	        // Step 2: Click search button
//	        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
//	            By.cssSelector(".mb-search__btn")));
//	        searchButton.click();
//
//	        System.out.println("Search triggered for: " + city);
//	    } catch (Exception e) {
//	        result = false;
//	        System.out.println("Failed to search for city: " + city);
//	        e.printStackTrace();
//	    }
//	    return result;
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	    }


	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

				
				
				
				
				
				
				
				
				
				
			

		
		
		
	
	
	
	
	
	
	
	
	
	


