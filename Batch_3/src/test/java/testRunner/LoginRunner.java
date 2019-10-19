package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/AmamzonLogin.feature", 
		glue = "steps", 
		tags = {"@regression"},
		dryRun = false)
public class LoginRunner {

}
