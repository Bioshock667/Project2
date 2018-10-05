package tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {
	
	@Test
	public void alwaysPass() {
		File f  = new File("../webapps/TestingServer/WEB-INF/classes/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		driver.quit();
	}

}
