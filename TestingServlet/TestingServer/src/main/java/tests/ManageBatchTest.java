package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageBatchPage;
import pages.NavBarPage;

public class ManageBatchTest {

	public static NavBarPage navBar;
	public static ManageBatchPage manageBatch;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties props;

	@BeforeSuite // run before all tests
	public void setupDriverAndPage() {

		File f = new File("../webapps/TestingServer/WEB-INF/classes/chromedriver.exe");
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
		manageBatch = new ManageBatchPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[2]/a")));
		navBar.getBatchLink().click();

		

		// wait until any element is loaded to begin testing
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-target='#createBatchModal']")));

	}

	@Test(priority = 2)
	public void checkYearFilterOptions() {
		manageBatch.getYearFilter().click();
		int year = 2019;
		for (int i = 1; i <= 4; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
					"#manage > div:nth-child(1) > div > div > ul > li.dropdown > ul > li:nth-child(" + i + ") > a")));
			manageBatch.getYearFilterOptions(i).click();
			manageBatch.getYearFilter().click();
			String yearString = Integer.toString(year);
			Assert.assertEquals(manageBatch.getYearFilterOptions(i).getAttribute("innerHTML"), yearString);
			year -= 1;
		}
	}

	@Test(priority = 4)
	public void checkCreateBatchClose() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getCreateBatchModal()));

		manageBatch.getCreateBatchButton().click();
		manageBatch.getCreateBatchClose().click();

		// wait until the create batch modal has closed fully
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getCreateBatchModal()));

		Assert.assertFalse(manageBatch.getCreateBatchModal().isDisplayed());
	}

	@Test(priority = 5)
	public void checkCreateBatchCloseButton() {
		manageBatch.getCreateBatchButton().click();
		manageBatch.getCreateBatchCloseButton().click();

		// wait until the create batch modal has closed fully
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getCreateBatchModal()));

		Assert.assertFalse(manageBatch.getCreateBatchModal().isDisplayed());
	}

	@Test(priority = 7)
	public void checkBatchCreation() throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getCreateBatchModal()));

		manageBatch.getCreateBatchButton().click();
		manageBatch.getCreateBatchTrainingName().sendKeys("1234 Sept15 Java");
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());

		Select trainingType = new Select(manageBatch.getCreateBatchTrainingType());
		trainingType.selectByIndex(1);
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());

		Select skillType = new Select(manageBatch.getCreateBatchSkillType());
		skillType.selectByIndex(6);
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());

		Select location = new Select(manageBatch.getCreateBatchLocation());
		location.selectByIndex(3);
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());

		Select trainer = new Select(manageBatch.getCreateBatchTrainer());
		trainer.selectByIndex(4);
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());

		Select coTrainer = new Select(manageBatch.getCreateBatchCoTrainer());
		coTrainer.selectByIndex(3);
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());

		manageBatch.getCreateBatchStartDate().sendKeys("08" + "27" + "2018");
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());

		manageBatch.getCreateBatchEndDate().sendKeys("11" + "06" + "2018");
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());

		manageBatch.getCreateBatchGoodGrade().sendKeys("80");
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());

		manageBatch.getCreateBatchPassingGrade().sendKeys("60");
		manageBatch.getCreateBatchSaveButton().click();

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getCreateBatchModal()));

		Assert.assertFalse(manageBatch.getCreateBatchModal().isDisplayed());
	}

	@Test(priority = 8)
	public void checkDateError() {
		manageBatch.getCreateBatchButton().click();
		manageBatch.getCreateBatchTrainingName().sendKeys("7833 Aug27 Java");
		Select trainingType = new Select(manageBatch.getCreateBatchTrainingType());
		trainingType.selectByIndex(1);
		Select skillType = new Select(manageBatch.getCreateBatchSkillType());
		skillType.selectByIndex(6);
		Select location = new Select(manageBatch.getCreateBatchLocation());
		location.selectByIndex(3);
		Select trainer = new Select(manageBatch.getCreateBatchTrainer());
		trainer.selectByIndex(3);
		Select coTrainer = new Select(manageBatch.getCreateBatchCoTrainer());
		coTrainer.selectByIndex(3);
		manageBatch.getCreateBatchStartDate().sendKeys("08" + "27" + "2018");
		manageBatch.getCreateBatchEndDate().sendKeys("08" + "26" + "2018");
		manageBatch.getCreateBatchGoodGrade().sendKeys("80");
		manageBatch.getCreateBatchPassingGrade().sendKeys("60");
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchDateError().isDisplayed());
		manageBatch.getCreateBatchDateErrorClose().click();
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getCreateBatchDateError()));

		manageBatch.getCreateBatchCloseButton().click();

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getCreateBatchModal()));
	}

	@Test(priority = 10)
	public void checkTraineesAddTrainee() {
		manageBatch.getYearFilter().click();
		manageBatch.getYearFilterOptions(2).click();

		manageBatch.getTraineesGlyph().click();

		manageBatch.getTraineesAdd().click();

		manageBatch.getTraineesAddName().sendKeys("Bob Dylan");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddEmail().sendKeys("BobDylan@gmail.com");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddSkype().sendKeys("TheRealBobDylan");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddPhone().sendKeys("3305347899");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddCollege().sendKeys("West Virginia University");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddDegree().sendKeys("Master's Degree of Classic Music");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddMajor().sendKeys("Fine Arts");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddRecruiter().sendKeys("Recruiter");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddTechScreener().sendKeys("Tech Screener");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddProjectCompletion().sendKeys("99");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddProfileURL().sendKeys("https://www.example.com/revature");
		manageBatch.getTraineesAddSave().click();

		Select trainingType = new Select(manageBatch.getTraineesAddTrainingStatus());
		trainingType.selectByIndex(3);

		// Added test to make sure incorrect email fails when all other fields are
		// correct
		manageBatch.getTraineesAddEmail().clear();
		manageBatch.getTraineesAddEmail().sendKeys("TheRealBobDylan");
		manageBatch.getTraineesAddSave().click();

		manageBatch.getTraineesAddSave().click();

		// Make sure page the add trainee modal is still displayed since email is
		// improper
		Assert.assertTrue(manageBatch.getTraineesAddModal().isDisplayed());

		manageBatch.getTraineesAddEmail().clear();
		manageBatch.getTraineesAddEmail().sendKeys("TheRealBobDylan@");
		manageBatch.getTraineesAddSave().click();

		// Make sure page the add trainee modal is still displayed since email is
		// improper
		Assert.assertTrue(manageBatch.getTraineesAddModal().isDisplayed());

		manageBatch.getTraineesAddEmail().clear();
		manageBatch.getTraineesAddEmail().sendKeys("TheRealBobDylan@gmail.com");
		manageBatch.getTraineesAddSave().click();

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getTraineesAddModal()));

		Assert.assertTrue(manageBatch.getTraineesViewName("Bob Dylan"));
	}

	@Test(priority = 11, dependsOnMethods = { "checkTraineesAddTrainee" })
	public void checkTraineesEdit() {
		manageBatch.getTraineesEdit().click();
		manageBatch.getTraineesAddName().clear();
		manageBatch.getTraineesAddName().sendKeys("Dylan, Bob");
		manageBatch.getTraineesAddRecruiter().clear();
		manageBatch.getTraineesAddRecruiter().sendKeys("Alpha Recruiter");
		manageBatch.getTraineesEditSave().click();

		Assert.assertTrue(manageBatch.getTraineesViewName("Dylan, Bob"));

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getTraineesAddModal()));
	}

	@Test(priority = 12, dependsOnMethods = { "checkTraineesEdit" })
	public void checkTraineesDelete() throws InterruptedException {
		manageBatch.getTraineesDelete().click();
		manageBatch.getTraineesConfirmCancel().click();

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getTraineesConfirmModal()));

		manageBatch.getTraineesDelete().click();
		manageBatch.getTraineesConfirmDelete().click();

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getTraineesConfirmModal()));

		Assert.assertFalse(manageBatch.getTraineesViewName("Dylan, Bob"));
		manageBatch.getTraineesClose().click();

		Thread.sleep(1000);
	}

	@Test(priority = 13)
	public void checkBatchDelete() {
		manageBatch.getYearFilter().click();
		manageBatch.getYearFilterOptions(2).click();

		manageBatch.getManageDelete().click();
		manageBatch.getManageConfirmDelete().click();
		Assert.assertTrue(manageBatch.getManageCantDeleteModal().isDisplayed());
		manageBatch.getManageCantDeleteOk().click();
	}

	@AfterSuite // runs after all tests
	public void cleanup() {
		driver.quit();
	}
}
