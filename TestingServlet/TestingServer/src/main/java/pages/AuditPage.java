package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuditPage {

	public static WebDriver wd;
	
	public AuditPage(WebDriver w) {
		this.wd = w;
		//wd.get("https://dev-caliber.revature.tech/caliber/#/vp/audit");
	}
	public WebElement getSaveButton() {
		return wd.findElement(By.className("saveButton"));
	}
	public WebElement getNegativeResponseButton() {
		return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.container.ng-scope > div.row.centered > button:nth-child(4)"));
	}
	public WebElement getNeutralResponseButton() {
		return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.container.ng-scope > div.row.centered > button:nth-child(3)"));
	}
	public WebElement getPositiveResponseButton() {
		return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.container.ng-scope > div.row.centered > button:nth-child(2)"));
	}
	public WebElement getResponseTextArea() {
		return wd.findElement(By.id("qcBatchNotes"));
	}
	public WebElement getYearSelector() {
		return wd.findElement(By.className("dropdown-toggle ng-binding"));
	}
	public WebElement getAddWeekButton() {
		return wd.findElement(By.className("glyphicon glyphicon-plus"));
	}
	public WebElement getTrainerDropDown() {
		return wd.findElement(By.className("dropdown-menu"));
	}
}
