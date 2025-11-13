package com.stepdefinitiontestng;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends BaseSteps {

	public static ExtentSparkReporter spark;                     // classes of extent reports what should be color of report& gui
	public static ExtentReports extReports;                      // what to track on report (tester name , date etc..,)
	public static ExtentTest test;    
	public static List<Map<String, String>> testData;
	@BeforeAll                                                   // it will run the code before feature file starts
	public static void beforeAll() 
	{
		spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");   //for extent report
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
	}
	@AfterAll                                                     
	public static void afterAll() 
	{
		extReports.flush();                                       
	}
	@Before                                                           
	public void beforeScenario(Scenario scenario) 
	{
		test = extReports.createTest(scenario.getName());           
		extReports.createTest(scenario.getName());
		launchBrowser();  

	}

	@After
	public void afterScenario(Scenario scenario) {
	    try {
	        if (scenario.isFailed() && driver != null) {
	            try {
	                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	                test.addScreenCaptureFromPath(screenshot.getAbsolutePath());
	            } catch (Exception e) {
	                System.out.println("Screenshot failed: " + e.getMessage());
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	BaseSteps.sleep(5000);
	    	closeBrowser();
	    }
	    }
}

//	        try {
//	            Thread.sleep(2000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        } finally {
//	        	
//	            closeBrowser();
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace(); // Optional: handle any unexpected errors
//	    }
//	}
//
//	
//	}





