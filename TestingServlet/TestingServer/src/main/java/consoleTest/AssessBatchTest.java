package consoleTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

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
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		ab = new AssessBatch(driver);
		nbp = new NavBarPage(driver);
		lp.getUName().sendKeys("calibot@revature.com");
		lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
		lp.getLogin().click();
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(3) > a")));
		nbp.getAccessBatchLink().click();
	}
	
	@Test(priority = 1)
	public void BatchTest2019() {
		ab.goToYear("2019");
		ab.goToBatchName("CaliberBot - 2/28/19");
		Assert.assertTrue(ab.getCurrentBatch().contains("Caliber Bot - 2/28/19 "));
	}
	@Test(priority = 2)
	public void BatchTest2018() {
		ab.goToYear("2018");
		ab.goToBatchName("Peter Alagna - 8/22/18");
		Assert.assertEquals(ab.getCurrentBatch(), "Peter Alagna - 8/22/18 ");
	}
	@Test(priority = 3)
	public void BatchTest2017() {
		ab.goToYear("2017");
		ab.goToBatchName("August Duet - 8/8/17");
		Assert.assertEquals(ab.getCurrentBatch(), "August Duet - 8/8/17 ");
	}
	@Test(priority = 4)
	public void BatchTest2016() {
		ab.goToYear("2016");
		ab.goToBatchName("Patrick Walsh - 5/4/16");
		Assert.assertEquals(ab.getCurrentBatch(), "Patrick Walsh - 5/4/16 ");
	}
	
	@Test(priority = 5)
	public void CanCreateAssessment() {
		Assert.assertEquals(ab.canCreateAssessment(), true);
	}
	@Test(priority = 6)
	public void CloseCANoSave() {
		int numassessments = ab.getNumberOfAssessments();
		ab.getCreateAssessment().click();		
		ab.getCAAssessmentCategory().sendKeys(Keys.DOWN, Keys.DOWN);
		ab.getCAMaxPoints().click();
		ab.getCAMaxPoints().sendKeys("50");
		ab.getCAAssessmentType().click();
		ab.getCAAssessmentType().sendKeys(Keys.DOWN, Keys.DOWN);
		ab.getCACLOSEbutton().click();
		Assert.assertEquals(ab.getNumberOfAssessments(), numassessments);
	}
	@Test(priority = 7)
	public void SaveCA() {
		int numassessments = ab.getNumberOfAssessments();
		ab.getCreateAssessment().click();		
		ab.getCASAVEbutton().click();
		Assert.assertEquals(ab.getNumberOfAssessments(), numassessments + 1);
	}
	
	@Test(priority = 8)
	public void CanImportGrades() {
	Assert.assertTrue(ab.canImportGrades());
	}
	@Test(priority = 9)
	public void CanCloseImportGrades() {
		ab.getImportGrades().click();
		ab.getImportGradesCLOSE().click();
	}
	
	@Test(priority = 10)
	public void WeeksAvailable() {
		ab.goToYear("2016");
		ab.goToBatchName("Patrick Walsh - 11/19/16");
		Assert.assertEquals(ab.weeksAvailable(), true);
	}
	@Test(priority = 11)
	public void AddWeekCloseNoAdd() {
		int numweeks = ab.getNumberOfWeeks();
		ab.getAddWeek().click();
		ab.getAddWeekNo().click();
		Assert.assertEquals(ab.getNumberOfWeeks(), numweeks);
	}
	@Test(priority = 12)
	public void AddWeek() {
		int numweeks = ab.getNumberOfWeeks();
		ab.getAddWeek().click();
		ab.getAddWeekYes().click();
		Assert.assertEquals(ab.getNumberOfWeeks(), numweeks + 1);
	}
	
	@Test(priority = 13)
	public void SetFlagAtSecondEmployee() {
		ab.getWeek(7).click();
		ab.getFlag(2).click();
		ab.getFlagComment(2).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE,"WOWZERS");
		ab.getFlagSave(2).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test(priority = 14)
	public void AssessmentsFilledOut() {
		int asnums = ab.getNumberOfAssessments();
		System.out.println(asnums);
		for(int i = 1; i <= asnums; i++) {
		ab.getAssessmentsByTestOrder(2, i).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, Integer.toString(i));
		}
	}
	@Test(priority = 15)
	public void AssessmentNote() {
		ab.getNotesByRow(2).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, "This is a great trainee");
	}
	
	@Test(priority = 16)
	public void BranchSummaryNote() {
		ab.getBatchNotes().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, "This is a great branch");
	}
	@Test(priority = 17)
	public void WatchSaveSpin() {
		ab.getBatchSaveButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
		
	
//		
//		
//		String a = "\r\n" + 
//				"										Servlet Exam\r\n" + 
//				"										(100%)\r\n" + 
//				"										";
//		a = a.trim();
//		a = a.replaceAll("[\n\r()%\\d]", "");
//		a = a.replaceAll("										", "");
//		a = a.trim();
//		
//		System.out.println("UGH");
//		System.out.println(a);
		
//		ab.pause();
//	}

		@AfterSuite
	public void cleanup() {
		ab.pause();
		driver.close();
		driver.quit();
	}
}

