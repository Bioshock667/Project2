package consoleTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AuditPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NavBarPage;

public class ConsoleColorTest {
	
	public static void main(String[] args) {
	File f  = new File("src/main/resources/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
	ChromeDriver driver = new ChromeDriver();
	Properties props = new Properties();
	try {
		FileInputStream in = new FileInputStream("src/main/resources/info.properties");
		props.load(in);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.get(props.getProperty("url"));
	LoginPage lp = new LoginPage(driver);
	lp.getUName().sendKeys(props.getProperty("uname"));
	lp.getPwd().sendKeys(props.getProperty("pwd"));
	lp.getLogin().click();
	Actions aBuilder = new Actions(driver);
	HomePage hp= new HomePage(driver);
	NavBarPage nv = new NavBarPage(driver);
	nv.getQualityLink().click();
	AuditPage ap = new AuditPage(driver);
	ap.goToBatchName(props.getProperty("colorBatch"));
	WebDriverWait w = new WebDriverWait(driver,10);
	try {
		w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 1)));
	} catch (Exception e) {
		System.out.println("no element 1");
	}
	WebElement we = ap.getStatusButtonByOrd(1,1);
	for (int i=1;i<7;i++) {
		we = ap.getStatusButtonByOrd(1,i);
		if (we.isDisplayed()) {
			we.click();
			System.out.println("ID: "+i);
		}
	}
	
	w.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 2)));
	we = ap.getStatusButtonByOrd(1, 2);
	if (we.isDisplayed()) {
		System.out.println("passed turn blue");
		we.click();
		WebDriverWait ww = new WebDriverWait(driver,10);
		ww.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 3)));
	}
	we = ap.getStatusButtonByOrd(1, 3);
	if (we.isDisplayed()) {
		System.out.println("passed turn green");
		we.click();
		WebDriverWait ww = new WebDriverWait(driver,10);
		ww.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 4)));
	}
	we = ap.getStatusButtonByOrd(1, 4);
	if (we.isDisplayed()) {
		System.out.println("passed turn yellow");
		we.click();
		WebDriverWait ww = new WebDriverWait(driver,10);
		ww.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 5)));
	}
	we = ap.getStatusButtonByOrd(1, 5);
	if (we.isDisplayed()) {
		System.out.println("passed turn red");
		we.click();
		WebDriverWait ww = new WebDriverWait(driver,10);
		ww.until(ExpectedConditions.elementToBeClickable(ap.getStatusButtonByOrd(1, 6)));
	}
	//ap.getStatusButtonByOrd(1,1).click();
	//ap.getStatusButtonByOrd(1,6).click();
	//so far this does nothing, possible wrong coordinates? or clicks need to be sent to iframe
	
}

}
