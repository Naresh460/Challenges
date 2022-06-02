package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {".\\Feature\\Verifyingproducts.feature"},
		glue= "stepdefinition",
		monochrome = true	,
				plugin= {"pretty","rerun:target/failedtest-run.txt"}
		)

public class RunnerClass {
	

}
