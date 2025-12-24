package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = {"stepDefinitions", "hooks"},
    plugin = {
            "pretty", // Prints Gherkin steps in a readable format in the console
            // A basic HTML report for a quick overview or as a fallback
            "html:target/cucumber-report.html",
            // A JSON report is useful for CI/CD integration (e.g., Jenkins Cucumber plugin)
            "json:target/cucumber.json",
            // The primary plugin for generating detailed Extent Reports
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    // 'monochrome = true' makes the console output more readable by removing ANSI color codes.
    monochrome = true,
    dryRun = false,
    tags = "@signUp_smoke"
)
public class TestRunner {}
