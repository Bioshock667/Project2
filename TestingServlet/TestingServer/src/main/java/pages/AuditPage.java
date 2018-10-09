package pages;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuditPage {

	private WebDriver wd;
	private WebDriverWait wait; 
	private String BatchDropdownSelector = "body > div > ui-view > ui-view > div.container.ng-scope > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)";
	private String YearDropdownSelector = "body > div > ui-view > ui-view > div.container.ng-scope > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.dropdown.ng-scope";
	private String NegRespBtnSelector = "body > div > ui-view > ui-view > div.container.ng-scope > div.container.ng-scope > div.row.centered > button:nth-child(4)";
	private String NeutRespBtnSelector = "body > div > ui-view > ui-view > div.container.ng-scope > div.container.ng-scope > div.row.centered > button:nth-child(3)";
	private String PosRespBtnSelector = "body > div > ui-view > ui-view > div.container.ng-scope > div.container.ng-scope > div.row.centered > button:nth-child(2)";
	private String WeekTabSelector = "body > div > ui-view > ui-view > div.container.ng-scope > div:nth-child(1) > div > div.col-sm-12.col-md-12.col-lg-12.top5.ng-scope > ul > li:nth-child";
	//private String TraineeFBBtnSelector = "#qcTrainees > div > ul > table > tbody > tr > td:nth-child(3) > button:nth-child(6) > i";
	private String TraineeFBBtnSelector = "#qcTrainees > div > ul > table > tbody > tr > td:nth-child(3)";
	public AuditPage(WebDriver w) {
		this.wd = w;
		this.wait = new WebDriverWait(wd,10);
		//wd.get("https://dev-caliber.revature.tech/caliber/#/vp/audit");
	}
	public WebElement getSaveButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("saveButton")));
		return wd.findElement(By.className("saveButton"));
	}
	public WebElement getNegativeResponseButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(NegRespBtnSelector)));
		return wd.findElement(By.cssSelector(NegRespBtnSelector));
	}
	public WebElement getNeutralResponseButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(NeutRespBtnSelector)));
		return wd.findElement(By.cssSelector(NeutRespBtnSelector));
	}
	public WebElement getPositiveResponseButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(PosRespBtnSelector)));
		return wd.findElement(By.cssSelector(PosRespBtnSelector));
	}
	public WebElement getResponseTextArea() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("qcBatchNotes")));
		return wd.findElement(By.id("qcBatchNotes"));
	}
	public WebElement getYearSelector() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(YearDropdownSelector)));
		return wd.findElement(By.cssSelector(YearDropdownSelector));
	}
	public WebElement getAddWeekButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("glyphicon glyphicon-plus")));
		return wd.findElement(By.className("glyphicon glyphicon-plus"));
	}
	public WebElement getBatchSelector() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BatchDropdownSelector)));
		return wd.findElement(By.cssSelector(BatchDropdownSelector));
	}
	public ArrayList<WebElement> getWeeks() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(WeekTabSelector + "(1)")));
		ArrayList<WebElement> list = new ArrayList<>();
		int index = 1;
		try {
			while (true) {
				WebElement nthWeek = wd.findElement(By.cssSelector(WeekTabSelector + "(" + index + ")"));
				list.add(nthWeek);
				index += 1;
			}
		} catch (NoSuchElementException e) {}
		return list;
	}
	public WebElement getBatchChoicebyName(String name) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(name)));
		return wd.findElement(By.linkText(name));
	}
	
	public WebElement getTraineeFBButton() {
		return wd.findElement(By.cssSelector(TraineeFBBtnSelector));
	}
}
