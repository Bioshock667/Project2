package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public static WebDriver wd;
	
	public LoginPage(WebDriver d) {
		wd = d;
	}
	
	public WebElement getUName() {
		return wd.findElement(By.name("username"));
	}
	
	public WebElement getPwd() {
		return wd.findElement(By.name("pw"));
	}
	
	public WebElement getLogin() {
		return wd.findElement(By.cssSelector("body > div > div > div > div.panel-body > div > form > div:nth-child(3) > div > input"));
	}

}
