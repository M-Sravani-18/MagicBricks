package com.pages;

import java.time.Duration;
import java.util.List;

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

public class LocHard extends BaseSteps{
	    private WebElement localityInput;
    	private static WebDriverWait wait;
        private static ExtentTest test;
     

    public LocHard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    
    @FindBy(xpath = "//input[contains(@placeholder,'Add More')]")
    private WebElement locality;
    
    
    @FindBy(xpath = "//*[@id=\"topLocalitiesDiv\"]/div[1]") 
    private WebElement firstSuggestion;
    
    
    @FindBy(xpath="//div[text()='What kind of PG accomodation are you looking for?']")
    private WebElement text;
    
    
    
    
    
    
    
    
    public void clickPgInBangalore() {
        //driver.findElement(pgInBangalore).click();
    	
    }
// 
//    public void enterLocality(String locality) {
//        driver.findElement(localityInput).sendKeys(locality);
//    }
// 
//    public void clickSearch() {
//        driver.findElement(searchBtn).click();
//    }
// 
//    public String getPgListingTitle() {
//        return driver.findElement(pgTitle).getText();
//    }
}	