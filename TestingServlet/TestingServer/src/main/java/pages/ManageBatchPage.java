package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageBatchPage {
	
	public static WebDriver wd;
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public ManageBatchPage(WebDriver d) {
		wd = d;
	}
	
	public WebElement getYearFilter() {
		String selector = "li[role=\"button\"]";
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getYearFilterOptions(int option) {
		String selector = "#manage > div:nth-child(1) > div > div > ul > li.dropdown > ul > li:nth-child(" + option + ") > a";
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getRandomStartDate() {
		String selector = "#manage > div:nth-child(2) > div > div > table > tbody > tr:nth-child(1) > td:nth-child(7)";
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getCreateBatchButton() {
		String selector = "li[data-target='#createBatchModal']";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getImportBatchButton() {
		String selector = "li[data-target=\'#importBatchModal\']";
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
//Create Batch Modal
	public WebElement getCreateBatchModal() {
		String selector = "modal-content";
		
		return wd.findElement(By.className(selector));
	}
	
	public WebElement getCreateBatchTrainingName() {
		String selector = "trainingName";
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getCreateBatchTrainingType() {
		String selector = "trainingType";
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getCreateBatchSkillType() {
		String selector = "skillType";
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getCreateBatchLocation() {
		String selector = "location";
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getCreateBatchTrainer() {
		String selector = "trainer";
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getCreateBatchCoTrainer() {
		String selector = "co-trainer";
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getCreateBatchStartDate() {
		String selector = "s";
		wait.until(ExpectedConditions.elementToBeClickable(By.name(selector)));
		
		return wd.findElement(By.name(selector));
	}
	
	public WebElement getCreateBatchEndDate() {
		String selector = "date";
		wait.until(ExpectedConditions.elementToBeClickable(By.name(selector)));
		
		return wd.findElement(By.name(selector));
	}
	
	public WebElement getCreateBatchGoodGrade() {
		String selector = "goodGrade";
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getCreateBatchPassingGrade() {
		String selector = "borderlineGrade";
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getCreateBatchSaveButton() {
		String selector = "#createBatchModal > div > div > div.modal-footer > input";
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getCreateBatchClose() {
		String selector = "button[class=\"close\"]";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getCreateBatchCloseButton() {
		String selector = "button[class=\'btn btn-default\']";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getCreateBatchDateError() {
		String selector = "batchModalLabel";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getCreateBatchDateErrorClose() {
		String selector = "#checkBatchModal > div > div > div.modal-footer > button";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getTraineesGlyph() {
		String selector = "span[class='glyphicon glyphicon-user']";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
}
