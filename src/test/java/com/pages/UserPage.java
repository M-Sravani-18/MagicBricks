package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.setup.BaseSteps;

public class UserPage {

	private static WebDriver driver;
	private static WebDriverWait wait;
	static ExtentTest test;


	public UserPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return BaseSteps.driver;
	}

	public String getPageTitle() {
		return getDriver().getTitle();
	}

	public String getCurrentURL() {
		return getDriver().getCurrentUrl();
	}

	//  Verify homepage
	public boolean verifyHomePage() {
	    try {
	        String title = getPageTitle();
	        return title.contains("MagicBricks");
	    } catch (Exception e) {
	        return false;
	    }
	}

	// Click Buy module
	public boolean clickBuyModule() {
	    try {
	        By buyModule = By.xpath("//a[text()='Buy']");
	        wait.until(ExpectedConditions.elementToBeClickable(buyModule)).click();
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}

	// Click Villa in Bangalore
	public boolean selectPropertyType(String propertyType) {
	    try {
	    	Thread.sleep(2000);
	        By propertyTypeLocator = By.xpath("//a[contains(text(),'" + propertyType + "')]");
	        wait.until(ExpectedConditions.elementToBeClickable(propertyTypeLocator)).click();
	        // Handle new tab if opened
	        String originalWindow = driver.getWindowHandle();
	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(originalWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }

	        // Wait for URL to change
	        wait.until(ExpectedConditions.urlContains("villa"));
	        return true;
	    } catch (Exception e) {
	        System.out.println("Error clicking property type: " + e.getMessage());
	        return false;
	    }
	}
	
	// Third Scenario 
	

		@FindBy(css = "input#keyword")
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

	      
	      
	      
	      
	      
}

	
	


