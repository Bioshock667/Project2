package consoleTest;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.NavBarPage;
import pages.AssessBatch;

public class AssessBatchTest {

	
	public static HomePage hp;
	public static LoginPage lp;
	public static AssessBatch ab;
	public static NavBarPage nbp;
	public static WebDriver driver;
	public static WebDriverWait wait;
		
	@BeforeSuite
	public void setDriversLoginAssessBatch() {
//		File file = new File("src/main/resources/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//		driver = new ChromeDriver();
//		driver.get("https://dev-caliber.revature.tech/");
//		hp = new HomePage(driver);
//		lp = new LoginPage(driver);
//		ab = new AssessBatch(driver);
//		nbp = new NavBarPage(driver);
//		lp.getUName().sendKeys("calibot@revature.com");
//		lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
//		lp.getLogin().click();
//		
//		wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(3) > a")));
//		nbp.getAccessBatchLink().click();
	}
	
//	@Test(priority = 1)
//	public void BatchTests() {
//		ab.goToYear("2019");
//		ab.goToBatchName("CaliberBot - 2/28/19");
//		Assert.assertTrue(ab.getCurrentBatch().contains("Caliber Bot - 2/28/19 "));
//		ab.goToYear("2018");
//		ab.goToBatchName("Peter Alagna - 8/22/18");
//		Assert.assertEquals(ab.getCurrentBatch(), "Peter Alagna - 8/22/18 ");
//		ab.goToYear("2017");
//		ab.goToBatchName("August Duet - 8/8/17");
//		Assert.assertEquals(ab.getCurrentBatch(), "August Duet - 8/8/17 ");
//		ab.goToYear("2016");
//		ab.goToBatchName("Patrick Walsh - 4/25/16");
//		Assert.assertEquals(ab.getCurrentBatch(), "Patrick Walsh - 4/25/16 ");
//	}
	
	@Test(priority = 2)
	public void CreateAssessmentTests() {
//		ab.goToYear("2016");
//		Assert.assertEquals(ab.canCreateAssessment(), true);
//		int numassessments = ab.getNumberOfAssessments();
//		System.out.println(numassessments);
//		
//		ab.getCreateAssessment().click();	
//		ab.getCAAssessmentCategory().sendKeys(Keys.DOWN, Keys.DOWN);
//
//		Assert.assertEquals(ab.getCAAssessmentCategory().getAttribute("value"), "Servlet");
//		ab.getCAMaxPoints().click();
//		ab.getCAMaxPoints().sendKeys("50");
//
//		ab.getCAAssessmentType().click();
//		ab.getCAAssessmentType().sendKeys(Keys.DOWN, Keys.DOWN);
		
		
		
		String a = "\r\n" + 
				"										Servlet Exam\r\n" + 
				"										(100%)\r\n" + 
				"										";
		a = a.trim();
		a = a.replaceAll("[\n\r()%\\d]", "");
		a = a.replaceAll("										", "");
		a = a.trim();
		
		System.out.println("UGH");
		System.out.println(a);
		
//		ab.pause();
	}

		@AfterSuite
	public void cleanup() {
//		driver.close();
//		driver.quit();
	}
}

