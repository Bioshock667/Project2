package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
public static WebDriver wd;
	
	public HomePage(WebDriver d) {
		wd = d;
	}
	
	public WebElement getBarChart() {
		return wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-body > div.chart-container.top5 > canvas"));
	}

}
