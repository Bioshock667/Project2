package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavBarPage;

public class NavBarTest {

	public static NavBarPage navBar;
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	@BeforeSuite //run before all tests
	public void setupDriverAndPage() throws InterruptedException {
		
		File f  = new File("../webapps/TestingServer/WEB-INF/classes/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		LoginPage lp = new LoginPage(driver);
		lp.getUName().sendKeys("calibot@revature.com");
		lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
		lp.getLogin().click();
		navBar = new NavBarPage(driver);
		wait = new WebDriverWait(driver, 10);
		
	}
	
	@Test(priority = 1)
	public void checkBatchLink() throws InterruptedException {
	    
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[2]/a")));
		
		navBar.getBatchLink().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"manage\"]/div[1]/div/div/ul/li[3]/a")));
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://dev-caliber.revature.tech/caliber/#/vp/manage");
	}
	
	@AfterSuite //runs after all tests
	public void cleanup() {
		
		driver.quit();
	}
}
