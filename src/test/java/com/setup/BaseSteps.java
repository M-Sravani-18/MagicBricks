package com.setup;
 
import java.util.Properties;

//import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import com.parameters.PropertyReader;
 
public class BaseSteps {
	public static WebDriver driver;
    public static void launchBrowser()
    {
        Properties prop = PropertyReader.readProperty();
        String browser = prop.getProperty("browserName");   
        if (browser.equalsIgnoreCase("edge"))             
        {
        	System.setProperty("webdriver.edge.driver", "C:\\Users\\madhams\\OneDrive - Capgemini\\Desktop\\Training\\SprintMagicBricks\\MagicBricks\\Drivers\\msedgedriver.exe");
        	EdgeOptions options= new EdgeOptions();
        	options.addArguments("--disable-notifications");
            driver = new EdgeDriver(options);
        }
        else if (browser.equalsIgnoreCase("firefox"))       
        {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome"))           
        {
            driver = new ChromeDriver();
        }
        else
        {
            System.out.println("Invalid browser specified in config.properties");
            return;
        }
        
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        String url = prop.getProperty("sourceUrl");
        driver.get(url);
//        try {
//        	// Switch to alert and dismiss (Block notifications)
//        	Alert alert = driver.switchTo().alert();
//        	alert.dismiss(); // or alert.accept() if you want to allow
//        	System.out.println("Notification popup handled successfully");
//        } catch (NoAlertPresentException e) {
//        	System.out.println("No notification popup appeared");
//        }
        driver.manage().window().maximize();
    }
    public static void sleep(int msec)                    
    {
        try
        {
            Thread.sleep(msec);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //  Close browser
     public static void closeBrowser() {
         if (driver != null) {
             driver.quit();
         }
     }
 }

 

