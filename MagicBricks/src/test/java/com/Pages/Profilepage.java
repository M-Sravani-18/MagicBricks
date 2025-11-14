package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class Profilepage extends BasePage {

    public Profilepage(WebDriver driver) {
        super(driver);
        
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

    // 🔹 Get Estimate Button
    @FindBy(xpath = "//a[contains(@class, 'mb-button') and contains(text(), 'Get Estimate Now')]")

    private WebElement getEstimateButton;

     //🔹 BHK Dropdown Label
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homeInteriorsDropdown));
        Actions actions = new Actions(driver);
        actions.moveToElement(homeInteriorsDropdown).perform();
    }

    public void clickHomeInteriorDesignServices() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homeInteriorDesignServices));
        homeInteriorDesignServices.click();
        
    }
    
//    public void assertHomeInteriorDesignPageDisplayed() {
//        String expectedUrl = "https://www.magicbricks.com/home-interior/?inc=topnavigation";
//        String actualUrl = driver.getCurrentUrl().trim();
//
//        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch: Expected vs Actual");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement heading = wait.until(ExpectedConditions.visibilityOf(homeInteriorDesignHeading));
//        Assert.assertTrue(heading.isDisplayed(), "Home Interior Design page heading is not visible.");
//
//        System.out.println("✅ Home Interior Design page loaded successfully.");
//    }

    /*public boolean isHomeInteriorDesignPageDisplayed() {
        try {
            WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Interior Design Services')]")
            ));
            return pageHeader.isDisplayed();
        } catch (Exception e) {
            System.out.println("Header not found, fallback to URL check: " + e.getMessage());
            return driver.getCurrentUrl().contains("home-interior");
        }
    }*/
    /*public boolean isHomeInteriorDesignPageDisplayed() {
        try {
            WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Interior Design Services')]")
            ));
            return pageHeader.isDisplayed();
        } catch (Exception e) {
            System.out.println("Header not found, fallback to URL check: " + e.getMessage());
            return driver.getCurrentUrl().contains("home-interior");
        }*/
    public boolean isHomeInteriorDesignPageDisplayed() {
    	//boolean actResult = true;
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        	
////            WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
////                By.xpath("(//div[text()='Home Interior Design Services by']") ));
////        //h2[contains(text(),'Interior Design Services')]
//            wait.until(ExpectedConditions.visibilityOf(homeInteriorDesignHeading));
//            Properties props = PropertyReader.readProperty();
//            String expectedTitle = props.getProperty("HomeInterior.expected");
//            String actualTitle = driver.getTitle();
//            if (!actualTitle.contains(expectedTitle)) {
//                actResult = false;
        //WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
        //		By.xpath("//h2[contains(text(),'Interior Design Services')]")));
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Interior Design Services')]")));
        return heading.isDisplayed();

            
            
         } catch (Exception e) {
        	//actResult = false;
            System.out.println("Header not found, fallback to URL check: " + e.getMessage());
            //return driver.getCurrentUrl().contains("home-interior");

            return driver.getCurrentUrl().contains("home-interior");
         }
    }
//        if (!driver.getCurrentUrl().contains("home-interior")) {
//            actResult = false;
//        } else {
//            actResult = true;
//        }
//
//        }
        //return actResult;

//    public boolean isHomeInteriorDesignPageDisplayed() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        return wait.until(ExpectedConditions.visibilityOf(homeInteriorDesignHeading)).isDisplayed();
//    }
  //*[@id="root"]/div[2]/div[1]/div/div[2]/div[2]/div/a[3]


//
//   public boolean isHyderabadDesignersPageDisplayed() {
//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        return wait.until(ExpectedConditions.visibilityOf(hyderabadDesignersHeading)).isDisplayed();
//   }
   
    
  //=============================second scenario=================================================== 
    
    // ✅ Step 1: Click Bangalore Design Link
  
    /*public void clickInteriorDesignInBangalore() {
     wait.until(ExpectedConditions.elementToBeClickable(bangaloreDesignLink)).click();
        System.out.println("Clicked on Interior Design in Bangalore link.");
    }
}*/
    public void clickInteriorDesignInBangalore() {
        wait.until(ExpectedConditions.elementToBeClickable(bangaloreDesignLink));
        bangaloreDesignLink.click();
           System.out.println("Clicked on Interior Design in Bangalore link.");
       }


    // ✅ Step 2: Click Get Estimate Now
//    public void clickGetEstimateNow() {
//        wait.until(ExpectedConditions.elementToBeClickable(getEstimateButton)).click();
//        System.out.println("Clicked on Get Estimate Now.");
//    }
//
//    // ✅ Step 3: Verify BHK Dropdown Visibility
//    public boolean isBHKDropdownVisible() {
//        boolean visible = isElementDisplayed(bhkDropdownLabel);
//        System.out.println("BHK dropdown visibility: " + visible);
//        return visible;
//    }
    
    
    




//=========================outline scenario 1==================================

    @FindBy(xpath="(//div[text()='Commercial'])[1]")
    private WebElement clickcommerical;
    
//   @FindBy(id="tabCOMM")
//   private WebElement clickcommerical;
    
   @FindBy(className=".mb-search__input")
   private WebElement searchbar;
   
   @FindBy(xpath="//*[@id=\"commercialIndex\"]/section[1]/div/div[1]/div[3]/div[5]")
   private WebElement searchbutton;
   
   
   public void clickCommercialTab() {
      // WebElement clickcommercial;
	   wait.until(ExpectedConditions.visibilityOf(clickcommerical));
	   wait.until(ExpectedConditions.elementToBeClickable(clickcommerical));
	   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickcommerical);
	   //clickcommerical.click();
   }

   public boolean enteringCityname(String cname) throws InterruptedException
   {
 	  try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			wait.until(ExpectedConditions.visibilityOf(searchbar));
			wait.until(ExpectedConditions.elementToBeClickable(searchbar));
			//searchbar.clear();
			
			searchbar.click();
			
			searchbar.sendKeys(cname);
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
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//
				wait.until(ExpectedConditions.elementToBeClickable(searchbutton));
				searchbutton.click();
				return true;
			}

			catch (Exception e) {
				System.out.println("Error clicking Search button: " + e.getMessage());
				return false;
			}

		}
   
    
//=============================== 4th scenario==============================================================   

   //@FindBy(xpath="//*[@id=\"intsrpPages\"]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/a/div[2]/div[2]/span[2]")
  // @FindBy(css = "a[href^=\"https://post.magicbricks.com\"]"
   //@FindBy(xpath="//*[@id=\"intsrpPages\"]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/a/div[1]/h2")
//   @FindBy(xpath="//*[@id=\"intsrpPages\"]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/a")
//   private WebElement contactbtn;
//
// 
//   
//
//public void clickContactButton() {
//	//try {
//	wait.until(ExpectedConditions.urlContains("interior-design")); 
//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactbtn);
//        wait.until(ExpectedConditions.elementToBeClickable(contactbtn)).click();
//    } 
//catch (Exception e) {
//        System.out.println("Contact button not clickable: " + e.getMessage());
//    }

    //}


//    public boolean isContactDetailsPageDisplayed() {
//        return wait.until(ExpectedConditions.visibilityOf(contactDetailsHeader)).isDisplayed();
//    }


   
   
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


public void clickPropIndex() {
	 wait.until(ExpectedConditions.visibilityOf(clickpropwrth));
     
wait.until(ExpectedConditions.elementToBeClickable(clickpropwrth));
clickpropwrth.click();

    }

    


//public void clickGetEstimate() throws InterruptedException {
//	Thread.sleep(1000);
//wait.until(ExpectedConditions.visibilityOf(getEstimateButton));
//wait.until(ExpectedConditions.elementToBeClickable(getEstimateButton));
//getEstimateButton.click();
//
//    }
//
//public boolean isPropertyWorthPageDisplayed() {
//	// TODO Auto-generated method stub
//	return false;
//}

//========================================scenario 5=============================================================

@FindBy(xpath="//*[@id=\"tabCOMM\"]")
WebElement oncommercial;

@FindBy(xpath="//*[@id=\"swiper-wrapper-6478e62874105f5c9\"]/div[3]/div")
 WebElement clickrate;

@FindBy(xpath="//*[@id=\"autoSuggestInputDivkeyword\"]")
WebElement searchplace;

@FindBy(xpath="//*[@id=\"keyword_suggest\"]/div[2]")
WebElement location;

@FindBy(xpath="//*[@id=\"searchWrap\"]/div[2]")
WebElement showtrends;




public void clickOnCommercial() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(oncommercial));
    oncommercial.click();
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

  	        // Optional: Click the button
  	        ratesAndTrends.click();

  	       // return true;
  	    } catch (Exception e) {
  	        System.out.println("Rates & Trends button not found or not clickable.");
  	        e.printStackTrace();
  	        //return false;
  	    }
}

//public void toEnterData() throws InterruptedException {
//	wait.until(ExpectedConditions.visibilityOf(searchplace));
//	searchplace.click();
//	Thread.sleep(3000);
//	searchplace.sendKeys();
//	Thread.sleep(5000);
//
//    }

public boolean enterPlace(String cname) throws InterruptedException
{
	  try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			wait.until(ExpectedConditions.visibilityOf(searchplace));
			wait.until(ExpectedConditions.elementToBeClickable(searchplace));
			//searchbar.clear();
			
			searchplace.click();
			
			searchplace.sendKeys(cname);
			return true;
		  } catch (Exception e) {

			return false;
		  }
			
}




  














}


 







