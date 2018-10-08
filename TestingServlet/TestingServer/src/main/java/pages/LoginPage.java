package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public static WebDriver wd;
	public static WebDriverWait UNwait;
	public static WebDriverWait PWwait;
	public static WebDriverWait Lwait;

	public LoginPage(WebDriver d) {
		wd = d;
	}
	
	public WebElement getUName() {
		UNwait = new WebDriverWait(wd,10);
		UNwait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		return wd.findElement(By.name("username"));
	}
	
	public WebElement getPwd() {
		PWwait = new WebDriverWait(wd,10);
		PWwait.until(ExpectedConditions.presenceOfElementLocated(By.name("pw")));		
		return wd.findElement(By.name("pw"));
	}
	
	public WebElement getLogin() {
		Lwait = new WebDriverWait(wd,10);
		Lwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > div > div > div.panel-body > div > form > div:nth-child(3) > div > input")));
		return wd.findElement(By.cssSelector("body > div > div > div > div.panel-body > div > form > div:nth-child(3) > div > input"));
	}

}
