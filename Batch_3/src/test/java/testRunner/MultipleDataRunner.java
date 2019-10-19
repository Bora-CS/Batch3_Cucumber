package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/loginTest.feature", 
glue = "src/test/java/steps",
dryRun=true)
public class MultipleDataRunner {

}
