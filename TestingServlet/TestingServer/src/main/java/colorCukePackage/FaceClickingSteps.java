package colorCukePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AuditPage;
import pages.LoginPage;
import pages.NavBarPage;

public class FaceClickingSteps {
	private ChromeDriver driver;
	Properties props;
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
	
	@Given("^I am on the caliberbot (\\d+)-(\\d+)-(\\d+) assess page$")
	public void i_am_on_the_caliberbot_assess_page(int arg1, int arg2, int arg3) throws Throwable {
		driver.get(props.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUName().sendKeys(props.getProperty("uname"));
		lp.getPwd().sendKeys(props.getProperty("pwd"));
		lp.getLogin().click();
		NavBarPage nv = new NavBarPage(driver);
		nv.getQualityLink().click();
		AuditPage ap = new AuditPage(driver);
		ap.goToBatchName(props.getProperty("colorBatch"));
	}

	@When("^I click on the red question mark$")
	public void i_click_on_the_red_question_mark() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebElement we = ap.getStatusButtonByOrd(1,1);
		WebDriverWait w = new WebDriverWait(driver,10);
		try {
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 1)));
		} catch (Exception e) {
			System.out.println("no element 1");
		}
		for (int i=1;i<7;i++) {
			we = ap.getStatusButtonByOrd(1,i);
			if (we.isDisplayed()) {
				System.out.println("ID: "+i);
				we.click();
				
			}
		}
		
	}

	@Then("^the red question mark changes to a blue star$")
	public void the_red_question_mark_changes_to_a_blue_star() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 2)));
		Assert.assertTrue(ap.getStatusButtonByOrd(1, 2).isDisplayed());
		if (driver !=null)driver.quit();
	}

	@When("^I click on the blue star$")
	public void i_click_on_the_blue_star() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 2)));
		WebElement we = ap.getStatusButtonByOrd(1,2);
		we.click();
	}

	@Then("^the blue star changes to a green face$")
	public void the_blue_star_changes_to_a_green_face() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 3)));
		Assert.assertTrue(ap.getStatusButtonByOrd(1, 3).isDisplayed());
		if (driver != null)driver.quit();
	}

	@When("^I click on the green face$")
	public void i_click_on_the_green_face() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 3)));
		WebElement we = ap.getStatusButtonByOrd(1,3);
		we.click();
	}

	@Then("^the green face changes to a yellow face$")
	public void the_green_face_changes_to_a_yellow_face() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 4)));
		Assert.assertTrue(ap.getStatusButtonByOrd(1, 4).isDisplayed());
		if (driver != null)driver.quit();
	}

	@When("^I click on the yellow face$")
	public void i_click_on_the_yellow_face() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 4)));
		WebElement we = ap.getStatusButtonByOrd(1,4);
		we.click();
	}

	@Then("^the yellow face changes to a red face$")
	public void the_yellow_face_changes_to_a_red_face() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 5)));
		Assert.assertTrue(ap.getStatusButtonByOrd(1, 5).isDisplayed());
		if (driver != null)driver.quit();
	}

	@When("^I click on the red face$")
	public void i_click_on_the_red_face() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 5)));
		WebElement we = ap.getStatusButtonByOrd(1,5);
		we.click();
	}

	@Then("^the red face changes to a question mark$")
	public void the_red_face_changes_to_a_question_mark() throws Throwable {
		AuditPage ap = new AuditPage(driver);
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 6)));
		Assert.assertTrue(ap.getStatusButtonByOrd(1, 6).isDisplayed());
		if (driver != null)driver.quit();
	}
	
	@After
	public void ending() {
		if (driver != null)driver.quit();
	}

}
