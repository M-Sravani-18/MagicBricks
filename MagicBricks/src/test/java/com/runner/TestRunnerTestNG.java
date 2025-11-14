package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		features = ".\\src\\test\\resources\\Features\\Profile.feature",		
		glue = "com.StepDefinitionTestNG",
		//tags="@scenario4",
		//tags="@secnari4",
		//tags="@sec3",
		tags="@scenario5",
		
	    
	       plugin = {"pretty", "html:Reports/cucumber-reports.html"}
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
 
 
	
}
