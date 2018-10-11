package LoginCukeSteps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class loginCukeSteps {
	private ChromeDriver driver;
	private Properties props;
	{
		File f  = new File("../webapps/TestingServer/WEB-INF/classes/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
		driver = new ChromeDriver();
		props = new Properties();
		try {
			FileInputStream in = new FileInputStream("../webapps/TestingServer/WEB-INF/classes/info.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Given("^I visit the login page$")
	public void i_visit_the_login_page() throws Throwable {
	    driver.get(props.getProperty("url"));
	}
	
	@When("^I enter correct credentials And I click Submit$")
	public void i_enter_correct_credentials_And_I_click_Submit() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.getUName().sendKeys(props.getProperty("uname"));
		lp.getPwd().sendKeys(props.getProperty("pwd"));
		lp.getLogin().click();
	}
	
	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Throwable {
	
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("home")));
	    Assert.assertEquals(driver.getCurrentUrl(), props.getProperty("homeUrl"));
	}
	
	@After
	public void ending() {
		driver.quit();
	}
}
