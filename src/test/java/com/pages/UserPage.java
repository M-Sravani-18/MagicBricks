
package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
//=======================================Second Sceanrio====================================================//

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
	        By propertyTypeLocator = By.xpath("//a[text()='Villa in Bangalore']");
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
	
	
	//======================================Third Scenario==========================================//
	

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

	      
//=========================fourth scenario====================================//
	     
	      
	      // Click Buy module
	      public boolean clickBuyModule1() {
	    	  try {
	    		  By buyModule = By.xpath("(//a[text()='Buy'])[1]");
	    		  WebElement clickBuy = wait.until(ExpectedConditions.elementToBeClickable(buyModule));
	    		  clickBuy.click();
	    		  return true;
	    	  } catch (Exception e) {
	    		  return false;
	    	  }
	      }


	      //  click Ready to Move
	      public boolean selectReadytoMove(String readytoMove) {
	    	  try {
	    		  Thread.sleep(2000);
	    		  By readytoMoveLocator = By.xpath("//a[text()='Ready to Move']");
	    		  WebElement ready = wait.until(ExpectedConditions.elementToBeClickable(readytoMoveLocator));
	    		  ready.click();
	  
	    		  // Handle new tab if opened
	    		  String originalWindow = driver.getWindowHandle();
	    		  for (String windowHandle : driver.getWindowHandles()) {
	    			  if (!windowHandle.equals(originalWindow)) {
	    				  driver.switchTo().window(windowHandle);
	    				  break;
	    			  }
	    		  }

	    		  // Wait for URL to change
	    		  wait.until(ExpectedConditions.urlContains("ready-to-move"));
                  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mb-srp__card')]")));
	    		  return true;
	    	  } catch (Exception e) {
	    		  System.out.println("Error clicking property type: " + e.getMessage());
	    		  return false;
	    	  }
	      }

	      // click on the click on zero brokerage
	      public void clickzerobrokerage() {
	    	    try {
	    	        // Use the exact XPath for ZERO BROKERAGE
	    	        By zeroBrokerageButton = By.xpath("//*[@id=\"cardid68974847\"]/div/div[1]/div[2]/div[2]/span");

	    	        // Wait for property cards to load (presence in DOM)
	    	        wait.until(ExpectedConditions.presenceOfElementLocated(zeroBrokerageButton));

	    	        // Wait until clickable
	    	        wait.until(ExpectedConditions.elementToBeClickable(zeroBrokerageButton)).click();

	    	        // Optional: Wait for navigation after click
//	    	        wait.until(ExpectedConditions.urlContains("brokerage"));
	    	    } catch (StaleElementReferenceException e) {
	    	        System.out.println("Element went stale, retrying...");
	    	        By zeroBrokerageButton = By.xpath("//*[@id='cardid68974847']/div/div[1]/div[2]/div[2]/span");
	    	        wait.until(ExpectedConditions.elementToBeClickable(zeroBrokerageButton)).click();
	    	    } catch (Exception e) {
	    	        System.out.println("Error clicking ZERO BROKERAGE: " + e.getMessage());
	    	    }
	    	}

	      // Method to verify URL
	      public boolean verifyURL(String expectedURL) {
	    	  return driver.getCurrentUrl().equals(expectedURL);
	      }
	      
	      
	      
	      
   
	      
	      
//==================================fifth Scenario==============================================//
	      
	      @FindBy(id="showTrendsId")
	      WebElement trendsBtn;
	      
	      @FindBy(id ="keyword")
	      WebElement clickSearchPlace;
	      
	      @FindBy(xpath="//*[@id=\"keyword_suggest\"]/div[2]")
	      WebElement location;
	       
	      @FindBy(xpath="//div[text()='Locality Average Price']")
	      static WebElement heading;
	      
	      public void enterDataInteriorBudgetestimator() {  	  
	    	  try {
	    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 
	    	        // Locate the element using XPath
	    	        WebElement ratesAndTrends = driver.findElement(By.xpath("(//div[contains(@class,'mb-home__tool-advice__card card-shadow')])[4]"));
	 
	    	        // Scroll into view using JavaScript
	    	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", ratesAndTrends);
	 
	    	        // Wait until it's visible and clickable
	    	        wait.until(ExpectedConditions.visibilityOf(ratesAndTrends));
	    	        wait.until(ExpectedConditions.elementToBeClickable(ratesAndTrends));
	 
	    	        // Optional: Click the button
	    	        ratesAndTrends.click();

	    	     // Switch to the new tab/window
	    	     for (String handle : driver.getWindowHandles()) {
	    	         driver.switchTo().window(handle);
	    	     }
	    	     
	    	     
	 
	    	       // return true;
	    	    } catch (Exception e) {
	    	        System.out.println("Rates & Trends button not found or not clickable.");
	    	        e.printStackTrace();
	    	        //return false;
	    	    }
	      }
	      public boolean clickAndEnterAirportLocation1(String location) throws InterruptedException {
	    		// TODO Auto-generated method stub
	    		boolean actResult = true;
	    	   
	    	    	wait.until(ExpectedConditions.visibilityOf(clickSearchPlace));
	    	    	clickSearchPlace.click();
	    	    	Thread.sleep(3000);
	    	    	clickSearchPlace.sendKeys(location);
	    	    	Thread.sleep(3000);
	    	       
	    	    	
	    	   
	    	    return actResult;
	    	}
	      public boolean selectFirstDropdownOption() {
	    		boolean actResult = true;
	    		// TODO Auto-generated method stub
	    		location.click();
	    		return actResult;
	    	}
	      public void showtrends() {  	  
	    	  try {
	    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 
	    	        // Locate the element using XPath
	    	        WebElement trends = driver.findElement(By.id("showTrendsId"));
	 
	    	        // Scroll into view using JavaScript
//	    	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", ratesAndTrends);
	 
	    	        // Wait until it's visible and clickable
	    	        wait.until(ExpectedConditions.visibilityOf(trends));
	    	        WebElement trends1 = wait.until(ExpectedConditions.elementToBeClickable(trends));
	 
	    	        // Optional: Click the button
	    	        trends1.click();

	    	     // Switch to the new tab/window
	    	     for (String handle : driver.getWindowHandles()) {
	    	         driver.switchTo().window(handle);
	    	     }
	    	         	     
	    	       // return true;
	    	    } catch (Exception e) {
	    	        System.out.println("Rates & Trends button not found or not clickable.");
	    	        e.printStackTrace();
	    	        //return false;
	    	    }
	      	      
	      }
	    	  
	      

	      public static boolean isHeadingVisible() {
	    	  //  WebElement confirmationSection = driver.findElement(
	    	  //      org.openqa.selenium.By.xpath("//*[contains(text(),'" + confirmationText + "')]"));
	    	  //  scrollToElement(confirmationSection);
	    	  //  return confirmationSection.isDisplayed();
	    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    	  wait.until(ExpectedConditions.visibilityOf(heading));
	    	  // Reports.generateReport(driver, test, Status.PASS, "heading is visible.");
	    	  return wait.until(ExpectedConditions.visibilityOf(heading)).isDisplayed();
	      }
	      
     	}
	      






	
	
