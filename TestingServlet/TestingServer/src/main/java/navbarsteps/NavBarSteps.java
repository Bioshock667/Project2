package navbarsteps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.NavBarPage;

public class NavBarSteps {
	
	public static NavBarPage navBar;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties props;

	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
		
		File f = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
    props = new Properties();
		try {
			FileInputStream in = new FileInputStream("../webapps/TestingServer/WEB-INF/classes/info.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = new ChromeDriver();
		driver.get(props.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUName().sendKeys(props.getProperty("uname"));
		lp.getPwd().sendKeys(props.getProperty("pwd"));
		lp.getLogin().click();
		navBar = new NavBarPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[2]/a")));
		navBar.getBatchLink().click();
		
		//wait until any element is loaded to begin testing
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-target='#createBatchModal']")));

	    throw new PendingException();
	}

	@When("^I click navbar Home$")
	public void i_click_navbar_Home() throws Throwable {
	    navBar.getHomeLink().click();
	    throw new PendingException();
	}

	@Then("^I verify that I am on the page https://dev-caliber\\.revature\\.tech/caliber/#/vp/home$")
	public void i_verify_that_I_am_on_the_page_https_dev_caliber_revature_tech_caliber_vp_home() throws Throwable {
	    Assert.assertEquals(driver.getCurrentUrl(), "https://dev-caliber\\\\.revature\\\\.tech/caliber/#/vp/home");
	    throw new PendingException();
	}

	@When("^I click navbar ManageBatch$")
	public void i_click_navbar_ManageBatch() throws Throwable {
	    navBar.getBatchLink().click();
	    throw new PendingException();
	}

	@Then("^I verify that I am on the page https://dev-caliber\\.revature\\.tech/caliber/#/vp/manage$")
	public void i_verify_that_I_am_on_the_page_https_dev_caliber_revature_tech_caliber_vp_manage() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev-caliber\\\\.revature\\\\.tech/caliber/#/vp/manage");
	    throw new PendingException();
	}

	@When("^I click navbar AccessBatch$")
	public void i_click_navbar_AccessBatch() throws Throwable {
		navBar.getAccessBatchLink().click();
	    throw new PendingException();
	}

	@Then("^I verify that I am on the page https://dev-caliber\\.revature\\.tech/caliber/#/vp/assess$")
	public void i_verify_that_I_am_on_the_page_https_dev_caliber_revature_tech_caliber_vp_assess() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev-caliber\\\\.revature\\\\.tech/caliber/#/vp/assess");
	    throw new PendingException();
	}

	@When("^I click navbar QualityAudit$")
	public void i_click_navbar_QualityAudit() throws Throwable {
		navBar.getQualityLink().click();
	    throw new PendingException();
	}

	@Then("^I verify that I am on the page https://dev-caliber\\.revature\\.tech/caliber/#/vp/audit$")
	public void i_verify_that_I_am_on_the_page_https_dev_caliber_revature_tech_caliber_vp_audit() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev-caliber\\\\.revature\\\\.tech/caliber/#/vp/audit");
	    throw new PendingException();
	}

	@When("^I click navbar Panel$")
	public void i_click_navbar_Panel() throws Throwable {
		navBar.getPanelLink().click();
	    throw new PendingException();
	}

	@Then("^I verify that I am on the page https://dev-caliber\\.revature\\.tech/caliber/#/vp/panels$")
	public void i_verify_that_I_am_on_the_page_https_dev_caliber_revature_tech_caliber_vp_panels() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev-caliber\\\\.revature\\\\.tech/caliber/#/vp/panels");
	    throw new PendingException();
	}

	@When("^I click navbar Reports$")
	public void i_click_navbar_Reports() throws Throwable {
		navBar.getReportLink().click();
	    throw new PendingException();
	}

	@Then("^I verify that I am on the page https://dev-caliber\\.revature\\.tech/caliber/#/vp/reports$")
	public void i_verify_that_I_am_on_the_page_https_dev_caliber_revature_tech_caliber_vp_reports() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev-caliber\\\\.revature\\\\.tech/caliber/#/vp/reports");
	    throw new PendingException();
	}
	
	@After //runs after all tests
	public void cleanup() {
		
		driver.quit();
	}
	
}
