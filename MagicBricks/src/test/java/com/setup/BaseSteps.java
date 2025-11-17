package com.setup;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.PropertyReader;

public class BaseSteps {
	public static WebDriver driver;
	protected static WebDriverWait wait;
    protected static JavascriptExecutor js;

    public static void launchBrowser()
    {
        Properties prop = PropertyReader.readProperty();
        String browser = prop.getProperty("browserName");   
        if (browser.equalsIgnoreCase("edge"))             
        {
        	//System.setProperty("webdriver.edge.driver", "C:\\Training Materials\\Selenium Grid\\msedgedriver.exe");
            driver = new EdgeDriver();
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
        String url = prop.getProperty("sourceUrl");
        driver.get(url);
        driver.manage().window().maximize();
    }
    public static void sleep(int msec)                     // Handling waits
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
    

	
	
	

}
