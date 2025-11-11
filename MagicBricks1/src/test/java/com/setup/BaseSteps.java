package com.setup;
 
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
import com.parameters.PropertyReader;
 
public class BaseSteps {
	  
	     public static WebDriver driver;
	  
	     public void openBrowser() {
	  
	         PropertyReader.loadProperties();
	  
	         String browser = PropertyReader.get("browserName");
	  
	         if (browser.equalsIgnoreCase("chrome")) {
	             driver = new ChromeDriver();
	         }
	         else if (browser.equalsIgnoreCase("edge")) {
	             driver = new EdgeDriver();
	         }
	         else {
	             throw new RuntimeException("Invalid browser name: " + browser);
	         }
	            
	         
	  
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	     }
	  
	     public void openURL() {
	         driver.get(PropertyReader.get("sourceUrl"));
	     }
	     
//	     public static void closeBrowser() throws InterruptedException
//	     {
//	    	 if(driver != null) {
//	    		 driver.quit();
//	    	 }
//	    	 Thread.sleep(15);
//	     }
	 }
	  
 
 
 