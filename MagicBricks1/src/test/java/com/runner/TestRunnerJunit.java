package com.runner;
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/features",
        glue = {
                "com.stepDefinitionJunit",
                "com.setup",
                "com.parameters",
                "com.pages"
        },
        plugin = {
                "pretty",
                "html:target/JUnit-Cucumber-Report.html"
        }
)
public class TestRunnerJunit {
 
}
 