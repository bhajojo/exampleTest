package options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty"},
		glue = {"stepdefs"},
		features = {"src/test/java/featurefiles"})
public class CucumberTests {}
