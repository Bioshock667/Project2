package consoleTest;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import pages.AuditPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NavBarPage;

public class ConsoleColorTest {
	
	public static void main(String[] args) {
	File f  = new File("src/main/resources/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://dev-caliber.revature.tech/");
	LoginPage lp = new LoginPage(driver);
	lp.getUName().sendKeys("calibot@revature.com");
	lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
	lp.getLogin().click();
	Actions aBuilder = new Actions(driver);
	HomePage hp= new HomePage(driver);
	NavBarPage nv = new NavBarPage(driver);
	nv.getQualityLink().click();
	AuditPage ap = new AuditPage(driver);
	ap.goToBatchName("Caliber Bot - 10/1/18");
	WebElement we = ap.getStatusButtonByOrd(1,1);
	for (int i=1;i<7;i++) {
		we = ap.getStatusButtonByOrd(1,i);
		if (we.isDisplayed()) {
			we.click();
			System.out.println("ID: "+i);
		}
	}
	//ap.getStatusButtonByOrd(1,1).click();
	//ap.getStatusButtonByOrd(1,6).click();
	//so far this does nothing, possible wrong coordinates? or clicks need to be sent to iframe
	
}

}
