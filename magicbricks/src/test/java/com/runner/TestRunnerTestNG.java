package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
        features = {"src/test/resources/Features/Login.feature"},
        glue = {"com.stepDefinitionTestNG"},
        		  plugin = {"pretty", "html:target/cucumber-report.html",
        	        		"pretty","html:reports/HTMLReports.html",
        	    			"json:reports/json-report.json",
        	    			"junit:reports/junit_report.xml"},
        				  tags = "@Locality or @CompareLocalities or @Price/sqftfilter or @Searchbox or @Projects",        		  monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests { 
	
}
