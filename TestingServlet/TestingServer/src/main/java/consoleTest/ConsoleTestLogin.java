package consoleTest;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

public class ConsoleTestLogin {
	
	public static void main(String[] args) {
		File f  = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		LoginPage lp = new LoginPage(driver);
		lp.getUName().sendKeys("calibot@revature.com");
		lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
		lp.getLogin().click();
	}

}
