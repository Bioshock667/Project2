package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBarPage {
public static WebDriver wd;
	
	public NavBarPage(WebDriver d) {
		wd = d;
	}
	
	public WebElement getHomeLink() {
		return wd.findElement(By.cssSelector("body > div > ui-view > nav > div > ul:nth-child(1) > li > a > img"));
	}
	public WebElement getBatchLink() {
		return wd.findElement(By.cssSelector("link - body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(2) > a"));
	}
	public WebElement getAccessBatchLink() {
		return wd.findElement(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(3) > a"));
	}
	public WebElement getQualityLink() {
		return wd.findElement(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(4) > a"));
	}
	public WebElement getPanelLink() {
		return wd.findElement(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(5) > a"));
	}
	public WebElement getReportLink() {
		return wd.findElement(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li:nth-child(6) > a"));
	}
	public WebElement getSettingsDropdown() {
		return wd.findElement(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li.dropdown.open > a"));
	}
	public WebElement getSettingsTrainerLink() {
		return wd.findElement(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li.dropdown.open > ul > li:nth-child(1) > a"));
	}
	public WebElement getSettingsLocationLink() {
		return wd.findElement(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li.dropdown.open > ul > li:nth-child(2) > a"));
	}
	public WebElement getSettingsCategoryLink() {
		return wd.findElement(By.cssSelector("body > div > ui-view > nav > div > ul.nav.navbar-nav.navbar-right > li.dropdown.open > ul > li:nth-child(3) > a"));
	}
}
