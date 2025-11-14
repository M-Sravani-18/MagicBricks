package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Replace with actual ID or locator



import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reports;

public class LocalPage extends BaseSteps{
	private WebElement localityInput;
	private static WebDriverWait wait;
    private static ExtentTest test;
 


    public LocalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
//    
//    @FindBy(xpath = "//*[@id=\"keyword\"]")
//    private WebElement locality;
//    
    
     @FindBy(css = "input#keyword")
	  WebElement locality;
     
		@FindBy(css = "div.mb-search__btn")
		WebElement searchButton;
    


    @FindBy(xpath = "//div[text()='What kind of PG accomodation are you looking for?']") 
    private List<WebElement> pgListings;

    
    public boolean enterLocality(String localityText) {
    	try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(locality));
        wait.until(ExpectedConditions.visibilityOf(locality));
        locality.clear();
        locality.click();
        locality.sendKeys(localityText);
      
        return true;
    	}
    	catch(Exception e) {
    		return false;
        
		
		
    	}
    }
    
    
    
    public boolean searchButton() throws InterruptedException
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
   
    
 

  public static boolean getPageTitle() {
    	
        try {
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current Page URL: " + currentUrl);
            Reports.generateReport(driver, test, Status.PASS, "PG  Page is verified");
            
            // Just check if URL contains 'seat-availability'
            return currentUrl.contains("hostels-in-bangalore-pppfr");
        } catch (Exception e) {
            System.out.println("Error verifying PG page: " + e.getMessage());
            Reports.generateReport(driver, test, Status.FAIL, "PG Page is not verified");
            return false;
        }
	
	
    }
    
	
	

}
