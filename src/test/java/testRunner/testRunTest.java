package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/*@RunWith(Cucumber.class)
@CucumberOptions(
	
		
		
		
	features="/Users/jayashreehemmige/eclipse-workspace/cucumber_nop_ecommerce_maven/Features/Login_nop_ecommerce.feature",
	glue = "stepDefinitions",
	dryRun= false, //before running the actual run, every step is created correctly
	monochrome= true, //removes unneccessary characters from console window. Refer to  "/Users/jayashreehemmige/Documents/Selenium/Selenium Hybrid Framework_youtube/malformed_characters_in_cucumber_test.png"
	plugin= {"pretty","html:test-output"}
)*/


@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//Features/"},
		//features="/Users/jayashreehemmige/eclipse-workspace/cucumber_nop_ecommerce_maven/Features/customers.feature",
		//features="/Users/jayashreehemmige/eclipse-workspace/cucumber_nop_ecommerce_maven/Features/Login_nop_ecommerce.feature",
		glue="stepDefinitions",
		dryRun= false,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		//tags= "@SanityTest or @Regression" // runs cases tagged with SanityTest or Regression test
		//tags= "@prod" // runs casees tagged as prod
		//tags="@SanityTest"
		
		)
public class testRunTest {

}
