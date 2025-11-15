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
import org.testng.Assert;

import com.pages.BasePage.BrowserUtils;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class SearchPage extends BaseSteps{
	
	Properties prop = PropertyReader.readProperty();
	
	
	public SearchPage() {
	        this.driver = BaseSteps.driver; // Ensure driver is inherited from BaseSteps
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        PageFactory.initElements(driver, this);
	    }

	//================================================================  Scenario-3 ================================================================================
	
	
	@FindBy(id="tabPLOT")
	private WebElement plotclick;
	
	@FindBy(xpath ="(//span[contains(@class,'seepmore') and (contains(text(),'See') or contains(text(),'Plot'))])[1]")
	private WebElement seePlots1;
	
	
	@FindBy(xpath="//*[@id=\"aboutWraperSection\"]/div[1]/div[1]/div[2]/a")
	private WebElement seePlots2;


	public void clickPlot() {
		 Assert.assertTrue(plotclick.isDisplayed(), " Plot tab is not visible.");
		    Assert.assertTrue(plotclick.isEnabled(), " Plot tab is not clickable.");
		    plotclick.click();
		    System.out.println(" Plot tab clicked successfully.");		
	}
	
	public void clickSeePlots1() {
	    try {
	       // WebElement seePlots1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,'seepmore') and (contains(text(),'See') or contains(text(),'Plot'))])[1]")));
	    	wait.until(ExpectedConditions.elementToBeClickable(seePlots1));

	        Assert.assertTrue(seePlots1.isDisplayed(), " 'See Plots 1' is not visible.");
	        Assert.assertTrue(seePlots1.isEnabled(), " 'See Plots 1' is not clickable.");

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", seePlots1);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seePlots1);
	        System.out.println("Clicked on See Plots 1.");
	    } catch (Exception e) {
	        System.out.println("Error clicking See Plots 1.");
	        Assert.fail(" Error clicking See Plots 1: " + e.getMessage());

	       
	    }
	}

	public void clickSeePlots2() {
	    try {
	        // Optional: wait for navigation or new tab
	        BrowserUtils.switchToNewTab(driver); // if it opens in a new tab

	        //WebElement seePlots2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"aboutWraperSection\"]/div[1]/div[1]/div[2]/a")));
	        
	        wait.until(ExpectedConditions.elementToBeClickable(seePlots2));


	        Assert.assertTrue(seePlots2.isDisplayed(), " 'See Plots 2' is not visible.");
	        Assert.assertTrue(seePlots2.isEnabled(), " 'See Plots 2' is not clickable.");

	        
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", seePlots2);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seePlots2);
	        System.out.println("Clicked on See Plots 2.");
	    } catch (Exception e) {
	        System.out.println("Error clicking See Plots 2.");
	        Assert.fail(" Error clicking See Plots 2: " + e.getMessage());

	    }
	}
	
	
	
	
	

	
	//==================================================================================================================//
	//                                                4 Scenario                                                        //
	//=================================================================================================================//
	
//	@FindBy(xpath = "//input[contains(@class,'mb-search__input')]")
//	WebElement cityInput;
//	
	@FindBy(css = "div.mb-search__btn")
	WebElement searchButton;
	
      public void enteringCityname(String cityName) throws InterruptedException
      {
    	  
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	    JavascriptExecutor js = (JavascriptExecutor) driver;

    	    // Step 1: Click into the city input field
    	    WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//input[contains(@class,'mb-search__input')]")));
    	    cityInput.click();
    	    Thread.sleep(500); // allow UI to activate

    	    // Step 2: Clear Bangalore tag if present
    	    try {
    	        WebElement closeTag = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.cssSelector("div.mb-search__tag-close[data-text='Bangalore']")));
    	        js.executeScript("arguments[0].click();", closeTag);
    	        System.out.println(" Cleared Bangalore tag");
    	        Thread.sleep(500);
    	    } catch (Exception e) {
    	        System.out.println(" No Bangalore tag to clear");
    	    }

    	    // Step 3: Clear and type the new city
    	    cityInput.sendKeys(Keys.CONTROL + "a");
    	    cityInput.sendKeys(Keys.DELETE);
    	    cityInput.sendKeys(cityName);
    	    Thread.sleep(2000); // wait for dropdown
    	    cityInput.sendKeys(Keys.CONTROL + "a");
    	    cityInput.sendKeys(Keys.DELETE);
    	    
    	    driver.findElement(By.xpath("(//a[@href='https://www.magicbricks.com/agricultural-land-for-sale-in-bangalore-pppfs' and .//div[text()='Agriculture Land']])[1]")).click();
    	    
 
    	  
    	    }

    	  
    	  
  
      public boolean clickSearch()
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
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
      
      
      
      
      
      
      //======================================================================================
      //                    5th Scenario                                                   
      //======================================================================================
      public void clickPlot1() {
    	    plotclick.click();
    	}

    	public void clickBudget() {
    	    WebElement budgetButton = driver.findElement(By.xpath("//div[@class='mb-search__title']//span[text()='Budget']")); // Adjust locator
    	    budgetButton.click();
    	}
    	
    	public void enterBudget(String budget) {
    		
    		// Locate the budget input field (adjust the ID as needed)
    		 WebElement budgetInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".buy_budget_lbl")));
    	   // WebElement  = driver.findElement(By.xpath("//*[@id=\"commercialIndex\"]/section[1]/div/div[1]/div[3]/div[4]/div[1]")); // Replace with actual ID

    	    // Clear and enter the budget value
    	   // budgetInput.clear();
    		 
    		 
    		  //Step 2: Select budget dynamically
 	        String budgetXPath = "";

 	        if (budget.equalsIgnoreCase(budget)) {
 	        	budgetXPath = String.format("//div[contains(@class,'mb-search__min-max__item') and contains(text(),'₹%s')]", budget);  

 	            //budgetXPath = "//li[contains(text(),'5 Lac')]";
 	        } else if (budget.equalsIgnoreCase(budget)) {
 	        	  budgetXPath=	String.format("//div[contains(@class,'mb-search__min-max__item') and contains(text(),'₹%s')]", budget);  

 	      // = "//div[contains(@class,'mb-search__min-max__item') and contains(text(),'₹10 Lac')]";
 	        	  

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
	       // System.out.println("Search clicked for: " + city + " - " + budget);
//	        driver.findElement(By.cssSelector("span.mb-srp__loanelgb__cta")).click();
//			homepage.clickOnNewProjects();
//			
    	}
     
	




	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

				
				
				
				
				
				
				
				
				
				
			

		
		
		
	
	
	
	
	
	
	
	
	
	


