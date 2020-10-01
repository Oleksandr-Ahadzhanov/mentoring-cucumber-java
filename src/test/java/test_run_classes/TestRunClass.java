package test_run_classes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features"},
        glue = {"stepdefs"}
)

public class TestRunClass { }
