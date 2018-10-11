package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
	
	Properties props;
	public static HomePage hp;
	public static LoginPage lp;
	public static WebDriver driver;

	@BeforeSuite
	public void setUpDriverAndPage() {

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
		driver = new ChromeDriver();
		driver.get(props.getProperty("url"));
		hp = new HomePage(driver);
		lp = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void login() {
		lp.getUName().sendKeys(props.getProperty("uname"));
		lp.getPwd().sendKeys(props.getProperty("pwd"));
		lp.getLogin().click();
		Assert.assertEquals(driver.getTitle(), "Caliber | Performance Management");
	}

	@Test(priority = 2)
	public void UserPage() {
		hp.getUserGuide().sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/revaturelabs/caliber/wiki#user-guide");
	}

	@AfterSuite
	public void cleanup() {
    driver.close();
		driver.quit();
	}
}
