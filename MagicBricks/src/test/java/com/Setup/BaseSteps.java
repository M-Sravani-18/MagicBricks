package com.Setup;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.Parameters.PropertyReader;

public class BaseSteps {
    public static WebDriver driver;

    public static void launchBrowser() {
        Properties prop = PropertyReader.readProperty();
        String browser = prop.getProperty("browserName");

        if (browser.equalsIgnoreCase("chrome")) {
        	ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications"); //  Disable notifications popup
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false); 
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--disable-notifications"); 
            
            driver = new EdgeDriver(options);
        } else {
            System.out.println("Invalid browser specified in config.properties");
            return;
        }

        
        String url = prop.getProperty("sourceUrl");
        driver.get(url);
//        String url2=prop.getProperty("url2");
//        driver.get(url2);
        driver.manage().window().maximize();
    }

    public static void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void closeBrowser()
    {
    	//sleep(4000);
    	driver.quit();
    	System.out.println("Browser closed successfully");
    }
    
}


