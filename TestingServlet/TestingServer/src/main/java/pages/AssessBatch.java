package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessBatch {
	
public static WebDriver wd;

// Year
public static WebDriverWait YEARwait;
// Batch
public static WebDriverWait BATCHwait;
// Create Assessment
public static WebDriverWait CREASSwait;
//Import Grades
public static WebDriverWait IMPGRAwait;
//Add Week
public static WebDriverWait ADDWEEwait;
//Save?
public static WebDriverWait SAVEwait;




// YEAR
public WebElement getYearButtonOpen() {
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)"))){
			return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)"));
		}
	} catch (Exception e) {
		return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")); 
	}
	return null; // should never happen
}

public int getYearNumberOfChildren() {
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	int children = 1;
	while (true) {
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1)       > div     > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + children + ") > a"))){
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

public WebElement selectYearByChild(int year) {
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1)       > div     > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a"));
}

public void goToYear(int year) {
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)"))){
			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")).click();
			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a")).click();
		}
	} catch (Exception e) {
		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")).click(); 
		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a")).click();
	}
}


// BATCH
public boolean hasBatches () {
	BATCHwait = new WebDriverWait(wd,10);
	BATCHwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)"))){
			return true;
		}
	} catch (Exception e) {
		return false; 
	}
	return false; // should never happen
}

public WebElement getBatchButtonOpen() {
	BATCHwait = new WebDriverWait(wd,10);
	BATCHwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)"))){
			return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)"));
		}
	} catch (Exception e) {
		return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.dropdown.ng-hide")); // would never use, non-usable hidden button
	}
	return null; // should never happen
}

public int getBatchNumberOfChildren() {
	BATCHwait = new WebDriverWait(wd,10);
	BATCHwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	int children = 1;
	while (true) {
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + children + ") > a"))){
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

public WebElement selectBatchByChild(int batchNum) {
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + batchNum + ") > a"));
}

public void goToBatch(int batchNum) {
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)"))){
			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)")).click();
			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + batchNum + ") > a")).click();
			}
	} catch (Exception e) {
		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.dropdown.ng-hide")).click(); // IM-POSS-E-BREW
		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + batchNum + ") > a")).click(); // IM-POSS-E-BREW
	}
}


// Create Assessment
public boolean canCreateAssessment () {
	BATCHwait = new WebDriverWait(wd,10);
	BATCHwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"))){
			return true;
		}
	} catch (Exception e) {
		return false; 
	}
	return false; // should never happen
}

public WebElement getCreateAssessmentButton() {
	CREASSwait = new WebDriverWait(wd,10);
	CREASSwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"))){
			return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"));
		}
	} catch (Exception e) {
		return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)")); // would never use, non-usable hidden button
	}
	return null; // should never happen
}

public void clickCreateAssessmentButton() {
	CREASSwait = new WebDriverWait(wd,10);
	CREASSwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"))){
			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)")).click();
		}
	} catch (Exception e) {
		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)")).click();; // is this possible? it's hidden..
	}
}

// Create New Assessment Modal
public WebElement getCloseCreateNewAssessmentButton() {
	CREASSwait = new WebDriverWait(wd, 10);
	CREASSwait.until(ExpectedConditions.presenceOfElementLocated(By.id("createAssessmentModal")));
	return wd.findElement(By.cssSelector("#createAssessmentModal > div > div > div > button"));
}

public void clickCloseCreateNewAssessmentButton() {
	CREASSwait = new WebDriverWait(wd,10);
	CREASSwait.until(ExpectedConditions.presenceOfElementLocated(By.id("createAssessmentModal")));
	wd.findElement(By.cssSelector("#createAssessmentModal > div > div > div > button")).click();
}
















}
