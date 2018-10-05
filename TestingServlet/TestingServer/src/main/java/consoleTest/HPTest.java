package consoleTest;

import java.io.File;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HPTest {
	
	
	public static HomePage hp;
	public static LoginPage lp;
	public static WebDriver driver;

	@BeforeSuite
	public void setUpDriverAndPage() {

		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		hp = new HomePage(driver);
		lp = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void login() {
		lp.getUName().sendKeys("calibot@revature.com");
		lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
		lp.getLogin().click();
		Assert.assertEquals(driver.getTitle(), "Caliber | Performance Management");
	}

	@Test(priority = 2)
	public void UserPage() {
		hp.getUserGuide().sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/revaturelabs/caliber/wiki#user-guide");
	}

	@Test(groups = "smoke")
	public void hello() {
		System.out.println("Smoke from HPTest");
	}

	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
