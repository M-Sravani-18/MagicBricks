package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
        features = {"src/test/resources/Features/Login.feature"},
        glue = {"com.stepDefinitionTestNG"},
        		
        		plugin = {"pretty:reports/prettyReport.html","html:reports/HTMLReports.html",
						"json:reports/json-report.json",
						"junit:reports/junit_report.xml","pretty", "html:target/cucumber-reports.html"},
                         tags = "@Locality or @CompareLocalities or @Price/sqftfilter or @Searchbox or @Projects or @NegativeScenario",       
        				  monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests { 
	
}
 