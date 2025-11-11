package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
 
	@CucumberOptions(
	        features = "src/test/resources/com/features/Login.feature",
	        glue = {
	                "com.stepDefinitionTestNG",
	                "com.setup",
	                "com.pages",
	                "com.parameters"
	        },
	        plugin = {
	                "pretty",
	                "html:target/TestNG-Cucumber-Report.html"
	                
	        }
	)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
		
	}
 

 

 
 