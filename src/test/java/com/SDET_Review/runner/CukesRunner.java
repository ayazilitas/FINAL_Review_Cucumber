package com.SDET_Review.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/Features",
        glue = "com/SDET_Review/StepDefs",
        monochrome = true,
        dryRun = true ,
        tags = "@wip"
)
public class CukesRunner {
}
