package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage.BrowserUtils;
import com.setup.BaseSteps;

public class HomePage extends BaseSteps{
	
	@FindBy(id="tabPLOT")
	private WebElement plotclick;
	
	//@FindBy(xpath="//h1[text()='Presenting Plots and Land in Bangalore by Magicbricks']")
	//private WebElement displayPlotInBangalore;
	
	//@FindBy(xpath="//div[@class='mb-home__collection__card--content'][.//div[text()='East facing Plots']]")
	@FindBy(xpath="//a[.//img[@alt='East facing Plots']]")                       //div[text()='East facing Plots']
	WebElement clickOnEastFacingPlots;
	
	@FindBy(xpath = "//a[contains(text(),'See Plots')]")
	private WebElement seePlots;

	
	
	 public HomePage() {
	        PageFactory.initElements(driver, this);
	    }


	public void clickPlot() {
		//driver.findElement(By.id("tabPLOT")).click();
		plotclick.click();
		
	}
	
	public void displayPresentingPlotsandLandInBangalore() {	
		//boolean display_Heading=driver.findElement(By.cssSelector("h1.strip-red")).isDisplayed();
		//boolean display_Heading=displayPlotInBangalore.isDisplayed();
		System.out.println("Presenting Plots and Land in Bangalore by Magicbricks Is vivible after clicking plot");
	}
	
	public void clickEastFacingPlots() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//div[@class='mb-home__collection__card--content'][.//div[text()='East facing Plots']]")).click();
		clickOnEastFacingPlots.click();
	}
	

	public void clickOnNewProjects() {		
		        try {
		            // Switch to the new tab
		            BrowserUtils.switchToNewTab(driver);

		            // Create JavascriptExecutor and Wait object
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		            // Scroll the page a little to make sure elements load
		            js.executeScript("window.scrollBy(0, 800);");
		            Thread.sleep(1000);

		            // Wait until the "See Plots" button is visible
		            wait.until(ExpectedConditions.visibilityOf(seePlots));

		            // Scroll directly to that element
		            js.executeScript("arguments[0].scrollIntoView({block:'center', behavior:'smooth'});", seePlots);
		            Thread.sleep(1000);

		            // Wait until clickable and click
		            wait.until(ExpectedConditions.elementToBeClickable(seePlots));
		            seePlots.click();

		            System.out.println("Clicked on 'See Plots' successfully!");

		        } catch (Exception e) {
		            System.out.println("Error while clicking 'See Plots': " + e.getMessage());
		        }
		    }

		
		
	}
	

	
	


