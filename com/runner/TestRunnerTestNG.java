package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		features = ".\\src\\test\\resources\\Features\\Profile.feature",		
		glue = "com.StepDefinitionTestNG",
	 //tags="@scenario1",
		//tags="@scenario2",
		//tags="@scenario3",
		//tags="@scenario4",
		tags="@scenario5",
		
	     plugin = {"pretty", "html:Reports/cucumber-reports.html",
	    		 "json:reports/json-report.json",
	    		   "junit:reports/junit_report.xml",}
	     //tags="@scenario5"
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
 
 
	
}
