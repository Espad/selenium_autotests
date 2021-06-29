package Runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/",
        glue = "Steps",
        tags = "@jsonTest",
        plugin = {"pretty", "json:target/Destination/cucumber.json", "html:target/Destination/index.html"}
        )
public class TestRunner {
}