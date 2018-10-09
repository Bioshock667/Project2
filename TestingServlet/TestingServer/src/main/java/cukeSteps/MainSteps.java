package cukeSteps;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class MainSteps {
	private ChromeDriver driver;
	{
		File f  = new File("../webapps/TestingServer/WEB-INF/classes/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
		driver = new ChromeDriver();
	}
	@Given("^I visit the login page$")
	public void i_visit_the_login_page() throws Throwable {
		driver.get("https://dev-caliber.revature.tech/");
	}

	@When("^I enter correct credentials And I click Submit$")
	public void i_enter_correct_credentials_And_I_click_Submit() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.getUName().sendKeys("calibot@revature.com");
		lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
		lp.getLogin().click();
	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Throwable {
		 driver.close();
	}
}
