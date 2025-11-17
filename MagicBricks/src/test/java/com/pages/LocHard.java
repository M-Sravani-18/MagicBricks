package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Replace with actual ID or locator



import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reports;

public class LocHard extends BaseSteps{
	    //private WebElement localityInput;
    	private static WebDriverWait wait;
        private static ExtentTest test;
     

    public LocHard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    
    @FindBy(xpath = "//*[@id=\"tabRENT\"]")
    private WebElement rent;
    
    
    
    
    @FindBy(xpath = "//*[@id=\"keyword\"]")
    private WebElement locality;
    
    
    @FindBy(xpath = "//*[@id=\"topLocalitiesDiv\"]/div[1]") 
    private WebElement firstSuggestion;
    
    
    @FindBy(xpath="//div[text()='What kind of PG accomodation are you looking for?']")
    private WebElement text;
      
//    
//    public void search()
//    {
//    	locality.click();
//    }
//    
    
    
    public void clickonRent() throws InterruptedException
    {
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
      	Thread.sleep(2000);
    	wait.until(ExpectedConditions.visibilityOf(rent));
    	//wait.until(ExpectedConditions.elementToBeClickable(pgInBangaloreOption)).click();
    	
    	Thread.sleep(2000);
         rent.click();
    	
    	
    }
    
    
    
    public void clickonsearch() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
      	Thread.sleep(2000);
    	wait.until(ExpectedConditions.visibilityOf(locality));
    	//wait.until(ExpectedConditions.elementToBeClickable(pgInBangaloreOption)).click();
    	
    	Thread.sleep(2000);
        locality.click();
        locality.sendKeys("sarjapur");
        Thread.sleep(5000);
    }
    
    
  
     
    public static boolean getPageTitle() {
    	
        try {
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current Page URL: " + currentUrl);
            Reports.generateReport(driver, test, Status.PASS, "PG  Page is verified");
            
            // Just check if URL contains 'seat-availability'
            return currentUrl.contains("pg-in-bangalore-pppfr");
        } catch (Exception e) {
            System.out.println("Error verifying PG page: " + e.getMessage());
            Reports.generateReport(driver, test, Status.FAIL, "PG Page is not verified");
            return false;
        }
    
    
    
    }
    
    
}	