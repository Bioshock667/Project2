package tests;

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

	@BeforeSuite // run before all tests
	public void setupDriverAndPage() {

		File f = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		LoginPage lp = new LoginPage(driver);
		lp.getUName().sendKeys("calibot@revature.com");
		lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
		lp.getLogin().click();
		navBar = new NavBarPage(driver);
		manageBatch = new ManageBatchPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[2]/a")));
		navBar.getBatchLink().click();
		
		//wait until any element is loaded to begin testing
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-target='#createBatchModal']")));

	}
	//test
	@Test(priority = 2)
	public void checkYearFilterOptions() throws InterruptedException {
		manageBatch.getYearFilter().click();
		for(int i = 1; i <= 4; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#manage > div:nth-child(1) > div > div > ul > li.dropdown > ul > li:nth-child(" + i + ") > a")));
			manageBatch.getYearFilterOptions(i).click();
			manageBatch.getYearFilter().click();
		}
	}
	
	@Test(priority = 3)
	public void checkBatchButton() throws InterruptedException {
		manageBatch.getCreateBatchButton().click();
		
		//wait until an element is visible to see if page is displayed
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(manageBatch.getCreateBatchClose()));
		
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());
	}
	
	@Test(priority = 4)
	public void checkCreateBatchClose() throws InterruptedException {
		manageBatch.getCreateBatchClose().click();
		
		//wait until the create batch modal has closed fully
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getCreateBatchModal()));
		
		Assert.assertFalse(manageBatch.getCreateBatchModal().isDisplayed());
	}
	
	@Test(priority = 5)
	public void checkCreateBatchCloseButton() {
		manageBatch.getCreateBatchButton().click();
		manageBatch.getCreateBatchCloseButton().click();
		
		//wait until the create batch modal has closed fully
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(manageBatch.getCreateBatchModal()));
		
		Assert.assertFalse(manageBatch.getCreateBatchModal().isDisplayed());
	}
	
	@Test(priority = 6)
	public void checkSaveButton() {
		manageBatch.getCreateBatchButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#createBatchModal > div > div > div.modal-footer > input")));
		manageBatch.getCreateBatchSaveButton().click();
		Assert.assertTrue(manageBatch.getCreateBatchModal().isDisplayed());
	}
	
	@Test(priority = 7)
	public void checkBatchCreation() throws InterruptedException {
		manageBatch.getCreateBatchTrainingName().sendKeys("7833 Aug27 Java");
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
		trainer.selectByIndex(3);
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
		
		Thread.sleep(1000);
		Assert.assertFalse(manageBatch.getCreateBatchModal().isDisplayed());
	}

//	@Test(priority = 8)
//	public void checkTraineesGlyph() {
//		manageBatch.getTraineesGlyph().click();
//	}
	
	@AfterSuite // runs after all tests
	public void cleanup() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
