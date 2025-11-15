package com.runner;
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/Features",
        glue = {
                "com.stepDefinitionJunit",
                "com.setup",
                "com.parameters",
                "com.pages"
        },
        plugin = {
                "pretty",
                "html:target/JUnit-Cucumber-Report.html"},
              tags = "@secondScenario"
        
)
public class TestRunnerjunit {
 
}