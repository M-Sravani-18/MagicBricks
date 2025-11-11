package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		features = ".\\src\\test\\resources\\Features\\Profile.feature",		
		glue = "com.StepDefinitionTestNG",
	    
	       plugin = {"pretty", "html:Reports/cucumber-reports.html"},tags= "@scenario"
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
 
 
}
