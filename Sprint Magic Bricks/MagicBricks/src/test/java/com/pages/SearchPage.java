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

import com.pages.BasePage.BrowserUtils;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class SearchPage extends BaseSteps{
	
	Properties prop = PropertyReader.readProperty();
	
	HomePage homepage = new HomePage();
	
	@FindBy(id="tabPLOT")
	private WebElement plotclick;
	
//	WebDriver driver=BaseSteps.driver;
	
	 public SearchPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }

	
	public SearchPage() {
        PageFactory.initElements(driver, this);
    }
	
	public void clickPlot() {
		plotclick.click();
		
	}
	
	public void clickSeePlots1() {
	    try {
	        WebElement seePlots1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,'seepmore') and (contains(text(),'See') or contains(text(),'Plot'))])[1]")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", seePlots1);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seePlots1);
	        System.out.println("Clicked on See Plots 1.");
	    } catch (Exception e) {
	        System.out.println("Error clicking See Plots 1.");
	        e.printStackTrace();
	    }
	}

	public void clickSeePlots2() {
	    try {
	        // Optional: wait for navigation or new tab
	        BrowserUtils.switchToNewTab(driver); // if it opens in a new tab

	        WebElement seePlots2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"aboutWraperSection\"]/div[1]/div[1]/div[2]/a")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", seePlots2);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seePlots2);
	        System.out.println("Clicked on See Plots 2.");
	    } catch (Exception e) {
	        System.out.println("Error clicking See Plots 2.");
	        e.printStackTrace();
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//==================================================================================================================//
	//                                                4 Scenario                                                        //
	//=================================================================================================================//
	
	@FindBy(xpath = "//input[contains(@class,'mb-search__input]")
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
			
			return false;
		  }
			
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
    	   // WebElement plotButton = driver.findElement(By.id("plotBtn")); // Adjust locator
    	   // plotButton.click();
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

 	        if (budget.equalsIgnoreCase("5 Lac")) {
 	        	budgetXPath = String.format("//div[contains(@class,'mb-search__min-max__item') and contains(text(),'₹%s')]", budget);  

 	            //budgetXPath = "//li[contains(text(),'5 Lac')]";
 	        } else if (budget.equalsIgnoreCase("10 Lac")) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

				
				
				
				
				
				
				
				
				
				
			

		
		
		
	
	
	
	
	
	
	
	
	
	


