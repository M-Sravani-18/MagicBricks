package com.Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Setup.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Profilepage extends BasePage {

    private static ExtentTest test;



	public Profilepage(WebDriver driver, ExtentTest test2) {
    	
        super(driver, test);
        
        PageFactory.initElements(driver, this);
       
    }

   
	@FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/a")
    private WebElement homeInteriorsDropdown;

    @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/div/div/div/ul/li[1]/a")
    private WebElement homeInteriorDesignServices;
//
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div/div[2]/div[2]/div/a[3]")
    private WebElement hyderabadLink;
  
    @FindBy(xpath = "//div[text()='Home Interior Design Services by']")//"//*[@id=\"root\"]/div[2]/div[1]/div/div[2]/h2")
    private WebElement homeInteriorDesignHeading;

    @FindBy(xpath = "//h1[contains(text(),'Interior Designers in Hyderabad')]")
   private WebElement hyderabadDesignersHeading;
    
    //========================
  // Bangalore Design Link
    @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/div/div/div/ul/li[2]/a")
    private WebElement bangaloreDesignLink;

     @FindBy(xpath = "//a[contains(@class, 'mb-button') and contains(text(), 'Get Estimate Now')]")
    private WebElement getEstimateButton;

   
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div[1]")
    private WebElement bhkDropdownLabel;
    
    //=====================outline 1================================
    @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/a")
    private WebElement homeInteriorsDropdown1;

    @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/div/div/div/ul/li[2]/a")
    private WebElement bangaloreLink;

    @FindBy(xpath= "(//div[text()='Bangalore'])[1]")
    private WebElement cityDropdown;
    
    @FindBy(xpath="(//*[@id=\"intsrpPages\"]/div[1]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2])")
    private WebElement ahm;



 //=====================1st scenario======================
    public void hoverOnHomeInteriorsDropdown() {
    	//try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homeInteriorsDropdown));
        Actions actions = new Actions(driver);
        actions.moveToElement(homeInteriorsDropdown).perform();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homeInteriorDesignServices));
        
    }
    

    public void clickHomeInteriorDesignServices() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //  Ensure submenu is visible
        wait.until(ExpectedConditions.visibilityOf(homeInteriorDesignServices));

        //  Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeInteriorDesignServices);

        //  Try normal click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(homeInteriorDesignServices));
            homeInteriorDesignServices.click();
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeInteriorDesignServices);
        }
    }

    
    
    
    public boolean isHomeInteriorDesignPageDisplayed() {
    	//boolean actResult = true;
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Interior Design Services')]")));
      //  Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
        
        return heading.isDisplayed();
        
            
            
         } catch (Exception e) {
        	//actResult = false;
            System.out.println("Header not found, fallback to URL check: " + e.getMessage());
         }
		return false;
    }

   
    
  //=============================second scenario=================================================== 
    
    public void clickInteriorDesignInBangalore() throws InterruptedException {
    //	try {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bangaloreDesignLink));
        Thread.sleep(5000);
        bangaloreDesignLink.click();
           System.out.println("Clicked on Interior Design in Bangalore link.");
           
 
    }

//=========================outline scenario 1==================================

   
    @FindBy(xpath="//div[@id='tabCOMM']")
    private WebElement clickcommerical;
    
   @FindBy(xpath="//input[@class=\"mb-search__input\"]")
   private WebElement searchbar;
   
   @FindBy(xpath="//div[@class=\"mb-search__tag-close\"]")
    private WebElement wrongbtn;
   
   @FindBy(xpath="(//div[@class=\"mb-search__auto-suggest__item\"])[4]")
   private WebElement cityname;
   
   @FindBy(xpath="//*[@id=\"commercialIndex\"]/section[1]/div/div[1]/div[3]/div[5]")
   private WebElement searchbutton;
   
   
   public void clickCommercialTab() {
	  // try {
      // WebElement clickcommercial;
	   wait.until(ExpectedConditions.visibilityOf(clickcommerical));
	   wait.until(ExpectedConditions.elementToBeClickable(clickcommerical));
	   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickcommerical);
	   
   }
   
 public boolean enteringCityname(String cname) throws InterruptedException
   {
 	 // try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			wait.until(ExpectedConditions.visibilityOf(searchbar));
			wait.until(ExpectedConditions.elementToBeClickable(searchbar));
			//searchbar.clear();
			
			searchbar.click();
			Thread.sleep(3000);
			wrongbtn.click();
			Thread.sleep(3000);
			searchbar.sendKeys(cname);
			Thread.sleep(3000);
		//	Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
			 
			return true;
			
   }
   
   public boolean selectFirstcity() {
	 
		boolean actResult = true;
		cityname.click();
		return actResult;

	   }  
   
   public boolean clickSearch() throws InterruptedException
		{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.elementToBeClickable(searchbutton));
				searchbutton.click();
				Thread.sleep(3000);
				return true;

		}
   
    
//========================================scenario 4============================================================
   
   
 @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[6]/a")
  private WebElement MBAdvice;
 
 @FindBy(xpath="//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[6]/div/div/div[3]/ul/li[4]/a")
 private WebElement clickpropwrth;
 
 @FindBy(xpath="//*[@id=\"propworth\"]/div[2]/div[1]/div[3]/span[2]")
 private WebElement clickgetestimate;
   



public void hoverOnMBAdviceDropdown() {
	
        wait.until(ExpectedConditions.visibilityOf(MBAdvice));
        wait.until(ExpectedConditions.elementToBeClickable(MBAdvice));
        Actions actions = new Actions(driver);
        actions.moveToElement(MBAdvice).perform();
   
}

public void clickPropIndex() throws InterruptedException {
//	try {
	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 wait.until(ExpectedConditions.visibilityOf(clickpropwrth));
     
wait.until(ExpectedConditions.elementToBeClickable(clickpropwrth));
clickpropwrth.click();
Thread.sleep(5000);

}   

//========================================scenario 5=============================================================

@FindBy(xpath="//*[@id=\"tabCOMM\"]")
private WebElement oncommercial;

@FindBy(xpath="//*[@id=\"swiper-wrapper-6478e62874105f5c9\"]/div[3]/div")
 WebElement clickrate;

@FindBy(xpath="//*[@id=\"autoSuggestInputDivkeyword\"]")
WebElement searchplace;

@FindBy(xpath="//input[@class=\"cityLocProjectField\"]")
WebElement clickSearchPlace;

@FindBy(xpath="//*[@id=\"keyword_suggest\"]/div[2]")
WebElement location;


@FindBy(xpath="//input[@class=\"searchBtn\"]")
WebElement showtrends;

@FindBy(xpath="//*[@id=\"locOrProjAvgPriceDiv\"]/div/div[1]/div/div[1]")
static
WebElement heading;


public static boolean isHeadingVisible(String headingname) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  wait.until(ExpectedConditions.visibilityOf(heading));
 
  return wait.until(ExpectedConditions.visibilityOf(heading)).isDisplayed();

}

public void clickOnCommercial() {
	try {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(oncommercial));
    oncommercial.click();
    Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
    
}catch (Exception e) {
	//Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
}
}
public void clickonrate() {
	 
  	 try {
  	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

  	        // Locate the element using XPath
  	        WebElement ratesAndTrends = driver.findElement(By.xpath("//div[@class='mb-home__tool-advice__card--title' and normalize-space(text())='Rates & Trends']/ancestor::a"));

  	        // Scroll into view using JavaScript
  	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", ratesAndTrends);

  	        // Wait until it's visible and clickable
  	        wait.until(ExpectedConditions.visibilityOf(ratesAndTrends));
  	        wait.until(ExpectedConditions.elementToBeClickable(ratesAndTrends));

  	        //  Click the button
  	        ratesAndTrends.click();
  	        
  	   
  	        // Switch to the new tab/window
   	     for (String handle : driver.getWindowHandles()) {
   	         driver.switchTo().window(handle);
   	   //   Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
   	   
   	     }
     // return true;
  	    } catch (Exception e) {
  	        e.printStackTrace();
  	   //   Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
  	        //return false;
  	    }
}

public boolean clickAndEntercityname(String location) throws InterruptedException {
	boolean actResult = true;
     wait.until(ExpectedConditions.elementToBeClickable(clickSearchPlace));
       clickSearchPlace.click();
       clickSearchPlace.clear(); // Important for second iteration
       clickSearchPlace.sendKeys(location);
       

     wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='keyword_suggest']")));

      Thread.sleep(3000);

       return actResult;
}


public boolean selectFirstDropdownOption() {
	//try {
	boolean actResult = true;
	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeClickable(location));
	location.click();
	return actResult;
	
}

public boolean clickShowtrends() {
	boolean actResult = true;
	wait.until(ExpectedConditions.elementToBeClickable(showtrends));
	showtrends.click();
	//Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
	 return actResult;
}
}








