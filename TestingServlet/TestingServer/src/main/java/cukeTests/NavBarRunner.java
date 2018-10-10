package cukeTests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/main/resources/features/cucNavBar.feature"},
        glue = {"navbarsteps"}  //Where can it find the cucumber code
        )
public class NavBarRunner extends AbstractTestNGCucumberTests {
	
}
