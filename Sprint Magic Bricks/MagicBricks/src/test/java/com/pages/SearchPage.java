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
	
	
	
	
	

	
	//================================================================  Scenario-4 ================================================================================
	
	@FindBy(xpath = "//input[contains(@class,'mb-search__input')]")
	WebElement city;
	
	
	@FindBy(xpath = "div.mb-search__tag-close[data-text='Bangalore']")
	WebElement close;
		
	@FindBy(css = "div.mb-search__btn")
	WebElement searchButton;
	
	@FindBy(xpath = "(//a[@href='https://www.magicbricks.com/agricultural-land-for-sale-in-bangalore-pppfs' and .//div[text()='Agriculture Land']])[1]")
	WebElement 	agriculture;
	
	
	
      public void enteringCityname(String cityName) throws InterruptedException
      {
    	  
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	    JavascriptExecutor js = (JavascriptExecutor) driver;

    	    // Step 1: Click into the city input field
    	    WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(city));
    	      
    	    cityInput.click();
    	    Thread.sleep(500); // allow UI to activate

    	    // Step 2: Clear Bangalore tag if present
    	    try {
    	        WebElement closeTag = wait.until(ExpectedConditions.elementToBeClickable(close));
    	           
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
    	    String actualCity = cityInput.getAttribute("value").trim();
    	    Assert.assertEquals(actualCity, cityName.trim(), "City input field was not updated correctly.");
    	    cityInput.sendKeys(Keys.CONTROL + "a");
    	    cityInput.sendKeys(Keys.DELETE);
    	    agriculture.click();
    	   
    	  
    	    }

    	    

     
      
    //================================================================  Scenario-5 ================================================================================
  	     
      @FindBy(xpath = "//div[@class='mb-search__title']//span[text()='Budget']")
  	WebElement budget;
  	
      
      @FindBy(css = "div.mb-search__btn")
    	WebElement search;
      
      
    	
  	
      
      
      public void clickPlot1() {
    	    plotclick.click();
    	}

    	public void clickBudget() {
    	 
    	    budget.click();
    	}
    	
    	
    	
    	
    	public void enterBudget(String budget) {
    		
    		
    		
    		String budgetXPath = String.format("//div[contains(@class,'mb-search__min-max__item') and contains(text(),'₹%s')]", budget);

    		WebElement budgetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(budgetXPath)));
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", budgetElement);
    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", budgetElement);

    		System.out.println("Budget selected: " + budget);

    		
    	


    	}
    	
    	
    	public void clickSearch() {
    			
    		 
  	       WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(search));
 	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
 	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
 	        
 	       System.out.println(" Search button clicked");
// 	       System.out.println("Current URL: " +driver.getCurrentUrl());
// 	       String ExpectedURL=prop.getProperty("expectedURL");
// 	       Assert.assertTrue(driver.getCurrentUrl().equals(ExpectedURL));
// 	       
    		
    	}
     
	




	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

				
				
				
				
				
				
				
				
				
				
			

		
		
		
	
	
	
	
	
	
	
	
	
	


