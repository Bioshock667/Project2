package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
public static WebDriver wd;
// UG = User Guide
public static WebDriverWait UGwait;
//LQA = Last Quality Audit
public static WebDriverWait LQAwait;
//WP = Weekly Progress
public static WebDriverWait WPwait;

// NOTE: THE WAY THE SELECTORS ARE TOGGLED IS REGARDING EMPTY/NOT-EMPTY 
// 		 WHERE NOT EMPTY OPENS THE SECOND SELECTOR

	public HomePage(WebDriver d) {
		wd = d;
	}
	
	public WebElement getUserGuide() {
		UGwait = new WebDriverWait(wd,10);
		UGwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#home > div:nth-child(1) > div > p > a")));
		return wd.findElement(By.cssSelector("#home > div:nth-child(1) > div > p > a"));
	}
	
	public WebElement getBarChart() {
		return wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-body > div.chart-container.top5 > canvas"));
	}
	
	public WebElement getRIGHTLQASelector() {
		LQAwait = new WebDriverWait(wd,10);
		LQAwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-heading > select")));
//		System.out.println("HP LQA RIGHT");
		return wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-heading > select"));
	}
	
	public WebElement getLEFTLQASelector() {
		LQAwait = new WebDriverWait(wd,10);
		LQAwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-heading > select.pull-right.ng-valid.ng-dirty.ng-valid-parse.ng-touched.ng-not-empty")));
//		System.out.println("HP LQA LEFT");
//		System.out.println("WD : " + wd.);
//		System.out.println(wd.findElement(By.ByLinkText)))
		return wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-heading > select.pull-right.ng-valid.ng-dirty.ng-valid-parse.ng-touched.ng-not-empty"));
	}
	
	// y is 15
	// poor x is 194 - 234 
	// avg x is 245- 305
	// good 316 - 362
	// ss  375 - 435
	public void togLQApoor() {
		Actions aBuilder = new Actions(wd);
		Action LQApoor;	
		LQApoor = aBuilder.moveToElement(wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-body > div.chart-container.top5 > canvas")), 0, 0).moveByOffset(215,15).click().build();LQApoor.perform();// x ~60-74 : y ~60-74
	}
	
	public void togLQAaverage() {
		Actions aBuilder = new Actions(wd);
		Action LQAaverage;	
		LQAaverage = aBuilder.moveToElement(wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-body > div.chart-container.top5 > canvas")), 0, 0).moveByOffset(275,15).click().build();LQAaverage.perform();// x ~60-74 : y ~60-74
	}
	
	public void togLQAgood() {
		Actions aBuilder = new Actions(wd);
		Action LQAgood;	
		LQAgood = aBuilder.moveToElement(wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-body > div.chart-container.top5 > canvas")), 0, 0).moveByOffset(340,15).click().build();LQAgood.perform();// x ~60-74 : y ~60-74
	}

	public void togLQAsuperstar() {
		Actions aBuilder = new Actions(wd);
		Action LQAsuperstar;	
		LQAsuperstar = aBuilder.moveToElement(wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-body > div.chart-container.top5 > canvas")), 0, 0).moveByOffset(400,15).click().build();LQAsuperstar.perform();// x ~60-74 : y ~60-74
	}
	
	public WebElement explore() {
		return wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1)"));
	}
	
//	public WebElement findchildren() {
//
//		//		WebElement input = divA.findElement(By.xpath(".//input"));
//	}https://stackoverflow.com/questions/10520294/locating-child-nodes-of-webelements-in-selenium
	
	public int getRLQAChildren() {
		int children = 1;
		while (true) {
		try {
			System.out.println("BEFORE SEARCHING Children = " + children); Thread.sleep(2000);
			if (null != wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-heading > select > option:nth-child(" + children + ")"))){
			} else {
				break;
			}
		} catch (Exception e) {
			break;
		}
		children++;
		}
		return children - 1;
	}
	
	
	// this thing is straight garbage until i can find a way to grab a selector
//	public WebElement getLQAnState(int n) {
//		if (n > 0) {
//			LQAwait = new WebDriverWait(wd, 10);
//			LQAwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
//					"#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-heading > select.pull-right.ng-valid.ng-dirty.ng-valid-parse.ng-touched.ng-not-empty > option:nth-child("
//							+ n + ")")));
//			return wd.findElement(By.cssSelector(
//					"#home > div:nth-child(2) > div > div:nth-child(1) > div > div > div.panel-heading > select.pull-right.ng-valid.ng-dirty.ng-valid-parse.ng-touched.ng-not-empty > option:nth-child("
//							+ n + ")"));
//		}
//		else {return null;}
//	}
//	
	
	
	public WebElement getLEFTWPSelector() {
		WPwait = new WebDriverWait(wd,10);
		WPwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(2) > div > div > div.panel-heading > select.pull-right.ng-valid.ng-dirty.ng-valid-parse.ng-touched.ng-not-empty")));
//		System.out.println("HP LQA RIGHT");
		return wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(2) > div > div > div.panel-heading > select.pull-right.ng-valid.ng-dirty.ng-valid-parse.ng-touched.ng-not-empty"));
	}
	
	public WebElement getRIGHTWPSelector() {
		WPwait = new WebDriverWait(wd,10);
		WPwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(2) > div > div > div.panel-heading > select")));
//		System.out.println("HP LQA RIGHT");
		return wd.findElement(By.cssSelector("#home > div:nth-child(2) > div > div:nth-child(2) > div > div > div.panel-heading > select"));
	}

}
