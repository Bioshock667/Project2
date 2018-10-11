package AssessBatchYearCukePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AssessBatch;
import pages.LoginPage;
import pages.NavBarPage;

public class AssessBatchYearSteps {
	
	public static LoginPage lp;
	public static NavBarPage nbp;
	public static AssessBatch ab;
	public static WebDriver driver;
	public static WebDriverWait wait;	
	
	@Given("^User is at Assess Batch Page$")
	public void user_is_at_Assess_Batch_Page() throws Throwable {
    Properties props;
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
		driver.get(props.getProperty("url"));
		
		lp = new LoginPage(driver);
		ab = new AssessBatch(driver);
		nbp = new NavBarPage(driver);
		
		lp.getUName().sendKeys(props.getProperty("uname"));
		lp.getPwd().sendKeys(props.getProperty("pwd"));
		lp.getLogin().click();
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(3) > a")));
		// System.out.println("Option to cry allowed here");
		nbp.getAccessBatchLink().click();

	}

	@When("^User selects \"([^\"]*)\" from the year tab$")
	public void user_selects(String arg1) throws Throwable {
		ab.goToYear(arg1);
	}

	@Then("^The \"([^\"]*)\" information is accessible$")
	public void the_information_is_accessible(String arg1) throws Throwable {
		// System.out.println("Forget about the pickling process and jump off a bridge instead");
		Assert.assertEquals(ab.getCurrentYear(), arg1);
	}

	@After
	public void closingTime() {
	driver.close();
	driver.quit();
	}
}
