package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessBatch {
	
public static WebDriver wd;

// MODALS - Should be checked for invisible before any main commands

// Constructor(driver)
public AssessBatch(WebDriver d) {
		wd = d;
}

public void pause() {
	WebDriverWait pause = new WebDriverWait(wd,3);
	try {
		pause.until(ExpectedConditions.elementToBeClickable(By.cssSelector("WONGOBONGOSALADTIME")));
	} catch (Exception pauseE) {
		
	}
}

// YEAR
public WebElement getYearButtonOpen() {
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")));
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
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
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
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1)       > div     > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a"));
}

public void goToYear(String year) {
	getYearButtonOpen();
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	int kids = getYearNumberOfChildren();
	for (int i= 1; i < kids + 1; i++) {
	WebElement e = wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + i + ") > a"));
	String s2 = e.getAttribute("innerHTML");
	String current = year;
		if (current.equals(s2)) {
			WebDriverWait ABWAIT = new WebDriverWait(wd,10);
			try {
					ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")));
					wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")).click();
					ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + i + ") > a")));
					wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + i + ") > a")).click();
			} catch (NoSuchElementException noyear) {
				System.out.println("That year does not exists");
			}
			break;
		}
		if (!current.equals(s2) && i == kids) {
			System.out.println("Year " + year + " doesn't exist");
		}
	}
}

public void goToYearByChild(int year) {
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
			ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")));
			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")).click();
			ABWAIT.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a")));
			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a")).click();
		
	} catch (Exception e) {
		ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")));
		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1)")).click();
		ABWAIT.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a")));
		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a")).click();
	}
}

public String getCurrentYear() {
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > a")));
	WebElement e = wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > a"));
	return  e.getAttribute("innerText");
}


// BATCH
public boolean hasBatches () {
	WebDriverWait BATCHwait = new WebDriverWait(wd,10);
	BATCHwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
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
	WebDriverWait BATCHwait = new WebDriverWait(wd,10);
	BATCHwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
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
	WebDriverWait BATCHwait = new WebDriverWait(wd,10);
	BATCHwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
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
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	WebElement e = wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + batchNum + ") > a"));
	return e;
}

public WebElement selectBatchByBatchName(String s) {
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	int kids = getBatchNumberOfChildren();
	for (int i= 1; i < kids + 1; i++) {
	WebElement e = wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a"));
	String s2 = e.getAttribute("innerHTML");
	String current = "\n" + 
			"								"+ s + "\n" + 
			"						";
		if (current.equals(s2)) {
			return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a"));
		}
	}
	return null;
}

public void goToBatch(int batchNum) {
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
			ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)")));
			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)")).click();
			ABWAIT.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + batchNum + ") > a")));
			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + batchNum + ") > a")).click();
	} catch (Exception e) {
		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.dropdown.ng-hide")).click(); // IM-POSS-E-BREW
		ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.dropdown.open > ul")));
		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + batchNum + ") > a")).click(); // IM-POSS-E-BREW
	}
}

public void goToBatchName(String s)  {
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	int kids = getBatchNumberOfChildren();
	for (int i= 1; i < kids + 1; i++) {
	WebElement e = wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a"));
	String s2 = e.getAttribute("innerHTML");
	String current = "\n" + 
			"								"+ s + "\n" + 
			"						";
		if (current.equals(s2)) {
			try {
				ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)")));
				wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)")).click();
				ABWAIT.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a")));
				wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a")).click();
			} catch (Exception gavel) {
				System.out.println("Batch not found");	
			}
			break;
		}
	}
}

public String getCurrentBatch() {
	WebDriverWait YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)")));
	WebElement e = wd.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[2]/ul[1]/li[2]/a"));
	System.out.println(e.getAttribute("innerText"));
	return  e.getAttribute("innerText");
}

//// CREATE ASSESSMENT METHODS /////////////
public boolean canCreateAssessment () {
	WebDriverWait BATCHwait = new WebDriverWait(wd,10);
	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	BATCHwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"))){
			return true;
		}
	} catch (Exception e) {
		return false; 
	}
	return false; // should never happen
}

public WebElement getCreateAssessment() {
	WebDriverWait CAwait = new WebDriverWait(wd,10);
	CAwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)")));
	return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"));
}

public WebElement getCAAssessmentCategory() {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	try{ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-body > div:nth-child(1) > div > select")));}
	catch (Exception e) {}
	return wd.findElement(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-body > div:nth-child(1) > div > select"));
}

public int getCAAssessmentCategoryChildren() {
	int children = 1;
	while (true) {
	try {
		if (null != wd.findElement(By.cssSelector("#category > option:nth-child(" + children + ")"))){
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

public WebElement getCAMaxPoints() {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-body > div:nth-child(2) > div:nth-child(1) > input")));
	return wd.findElement(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-body > div:nth-child(2) > div:nth-child(1) > input"));
}

public WebElement getCAAssessmentType() {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-body > div:nth-child(2) > div:nth-child(2) > select")));	
	return wd.findElement(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-body > div:nth-child(2) > div:nth-child(2) > select"));
}

public int getCATypeChildren() {
	int children = 1;
	while (true) {
	try {
		if (null != wd.findElement(By.cssSelector("#assessmentType > option:nth-child(" + children + ")"))){
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

public WebElement getCASAVEbutton() {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-footer > input")));
	return wd.findElement(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-footer > input"));
}

public WebElement getCACLOSEbutton() {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-footer > button")));
	return wd.findElement(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-footer > button"));
}


// Edit Assessment Methods ////
public WebElement getEditAssessment(int num) {	
	WebDriverWait CAwait = new WebDriverWait(wd,10);
	CAwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > thead > tr > th:nth-child(" + num + ")")));
	return wd.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > thead > tr > th:nth-child(" + num + ")"));
}

///// IMPORT GRADES ////////////////
public boolean canImportGrades () {
	WebDriverWait BATCHwait = new WebDriverWait(wd,10);
	BATCHwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(3)"))){
			return true;
		}
	} catch (Exception e) {
		return false; 
	}
	return false; // should never happen
}

public WebElement getImportGrades() {
	WebDriverWait IGwait = new WebDriverWait(wd,10);
	IGwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(3)")));
	return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(3)"));
}

public WebElement getTextArea() {
	WebDriverWait IGwait = new WebDriverWait(wd,10);
	IGwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#importGradesModal > div > div > form > div.modal-body > div:nth-child(2) > div > textarea")));
	return wd.findElement(By.cssSelector("#importGradesModal > div > div > form > div.modal-body > div:nth-child(2) > div > textarea"));
}

public WebElement getImportGradesSAVE() {
	WebDriverWait IGwait = new WebDriverWait(wd,10);
	IGwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#importGradesModal > div > div > form > div.modal-footer > input")));
	return wd.findElement(By.cssSelector("#importGradesModal > div > div > form > div.modal-footer > input"));
}

public WebElement getImportGradesCLOSE() {
	WebDriverWait IGwait = new WebDriverWait(wd,10);
	IGwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#importGradesModal > div > div > form > div.modal-footer > button")));
	return wd.findElement(By.cssSelector("#importGradesModal > div > div > form > div.modal-footer > button"));
}


// WEEK TABS ///////////////	
public boolean weeksAvailable() {
	try {
		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-sm-12.col-md-12.col-lg-12.top5.ng-hide"))){
			return false;
		}
	} catch (Exception e) {
		return true; 
	}
	return false; // should never happen
}

public int getNumberOfWeeks() {
	int children = 1;
	while (true) {
		try {
			if (null != wd.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[3]/ul/li[" + children + "]/a"))){
			} else {
				break;
			}
		} catch (Exception e) {
			break;
		}
	children++;
	}
	return children - 2; // this is -2 instead of -1 because the '+' to create a new week is considered  the final element
}

public WebElement getWeek(int weeknum) {
	wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	return wd.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[3]/ul/li[" + weeknum + "]"));
}

public WebElement getAddWeek() {
	int wheretoadd = getNumberOfWeeks() + 1;
	return wd.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[3]/ul/li[" + wheretoadd + "]/a"));	
}

public WebElement getAddWeekYes() {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#yesBtn")));
	return wd.findElement(By.cssSelector("#yesBtn"));
}

public WebElement getAddWeekNo() {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#confirmingweeks > div > div > div.modal-footer > button.btn.btn-default")));
	return wd.findElement(By.cssSelector("#confirmingweeks > div > div > div.modal-footer > button.btn.btn-default"));
}


// NUMBER OF TRAINEES ///////
public int getNumberOfTrainees() {
int children = 1;
	while (true) {
		try {
			if (null != wd.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + children + ")"))){
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


/// FLAGS ////
public WebElement getFlag(int child) {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-2.col-md-2.col-lg-2.ng-binding")));
	return wd.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-2.col-md-2.col-lg-2.ng-binding"));
}

public WebElement getFlagComment(int child) {
	wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	return wd.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[" + child + "]/td[2]/form/input[1]"));
}

public WebElement getFlagSave(int child) {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-1.col-md-1.col-lg-1 > form > input[type=\"submit\"]:nth-child(2)")));
	return wd.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-1.col-md-1.col-lg-1 > form > input[type=\"submit\"]:nth-child(2)"));
}

public WebElement getFlagClose(int child) {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-1.col-md-1.col-lg-1 > form > span")));
	return wd.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-1.col-md-1.col-lg-1 > form > span"));
}


// ASSESSMENTS IN TABLE //
public int getNumberOfAssessments() {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	ABWAIT.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[1]")));
	int children = 1;
	while (true) {
		try {
			if (null != wd.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[1]/td[" + children + "]"))){
			}
		} catch (Exception e) {
			break;
		}
		children++;
	}
return children - 4;
}

public WebElement getAssessmentsByTestOrder(int row, int test) {
	test = test + 2;
	wd.manage().timeouts().implicitlyWait(3,  TimeUnit.SECONDS);
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[1]")));
	return wd.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[" + row + "]/td[" + test + "]/input"));
}


// NOTES IN TABLE //
public WebElement getNotesByRow(int row) {
	wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	int notescol = getNumberOfAssessments() + 3;
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
//	ABWAIT.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[1]")));
//	int children = 1;
//	int trainees = getNumberOfTrainees();
//	while (true) {
//		try {
//			if (null != wd.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[1]/td[" + children + "]"))){
//			}
//		} catch (Exception e) {
//			break;
//		}
//		children++;
//	}
//	children = children - 1;
	
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[" + row + "]/td[" + notescol + "]/textarea")));
	return wd.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[" + row + "]/td[" + notescol + "]/textarea"));
}


// SUMMARY NOTE //
public WebElement getBatchNotes() {
	wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"tBatchNotes\"]")));
	return wd.findElement(By.xpath("//*[@id=\"tBatchNotes\"]"));
	}


// SAVE BUTTON
public WebElement getBatchSaveButton() {
	WebDriverWait ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/div[3]/div/a")));
	return wd.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/div[3]/div/a"));
	}
}
