package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
 
 
@CucumberOptions(
		features = ".\\src\\test\\resources\\Features\\Profile.feature",		
		glue = "com.stepDefinitionTestNG",
	       plugin = {"pretty", "html:Reports/cucumber-reports.html",
	    		   "pretty","html:reports/HTMLReports.html",
	    		   "json:reports/json-report.json",
	      "junit:reports/junit_report.xml"},

 
	      monochrome = true

		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
	
	
 
	
}

