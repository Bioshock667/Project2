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
public static WebDriverWait SAVEwait;

public static WebDriverWait CAwait;
public static WebDriverWait IGwait;
public static WebDriverWait ABWAIT;
public static WebDriverWait WeekWait;

// MODALS - Should be checked for invisible before any main commands
public static WebDriverWait ImportModalCloseWait;
public static WebDriverWait CreateModalCloseWait;
public static WebDriverWait ConfirmingWeeksCloseWait;
//ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
//ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));



	public AssessBatch(WebDriver d) {
		wd = d;
	}

// YEAR
public WebElement getYearButtonOpen() {
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
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
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1)       > div     > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a"));
}

public void goToYear(String year) {
	YEARwait = new WebDriverWait(wd,10);
	ABWAIT = new WebDriverWait(wd,10);
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

public WebElement selectYear(String year) {
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1)       > div     > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(" + year + ") > a"));
}

public void goToYearByChild(int year) {
	YEARwait = new WebDriverWait(wd,10);
	ABWAIT = new WebDriverWait(wd,10);
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

// BATCH
public boolean hasBatches () {
	BATCHwait = new WebDriverWait(wd,10);
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
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	BATCHwait = new WebDriverWait(wd,10);
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
	BATCHwait = new WebDriverWait(wd,10);
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
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	WebElement e = wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + batchNum + ") > a"));
	String s = e.getAttribute("innerHTML");
	String s2 = "\n" + 
			"								Genesis Bonds - 9/11/18\n" + 
			"						";
	System.out.println(s);
	System.out.println(s2);
	System.out.println(s.equals(s2));
	return e;
}

public WebElement selectBatchByBatchName(String s) {
	YEARwait = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	int kids = getBatchNumberOfChildren();
	for (int i= 1; i < kids + 1; i++) {
	WebElement e = wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a"));
	String s2 = e.getAttribute("innerHTML");
	String current = "\n" + 
			"								"+ s + "\n" + 
			"						";
		if (current.equals(s2)) {
			System.out.println("found");
			return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a"));
		}
	}
	return null;
}

public void goToBatch(int batchNum) {
	YEARwait = new WebDriverWait(wd,10);
	ABWAIT = new WebDriverWait(wd,10);
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
	YEARwait = new WebDriverWait(wd,10);
	ABWAIT = new WebDriverWait(wd,10);
	YEARwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
	int kids = getBatchNumberOfChildren();
	for (int i= 1; i < kids + 1; i++) {
	WebElement e = wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a"));
	String s2 = e.getAttribute("innerHTML");
	String current = "\n" + 
			"								"+ s + "\n" + 
			"						";
		if (current.equals(s2)) {
			System.out.println("found");
			try {
				ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)")));
				wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2)")).click();
				System.out.println("linkText : " + current);
				ABWAIT.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a")));
				wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(" + i + ") > a")).click();
			} catch (Exception gavel) {
				System.out.println("Batch not found");	
				}
		}
	}
}

// Create Assessment
public boolean canCreateAssessment () {
	BATCHwait = new WebDriverWait(wd,10);
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
//
//public WebElement getCreateAssessmentButton() {
//	CREASSwait = new WebDriverWait(wd,10);
//	CREASSwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
//	try {
//		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"))){
//			return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"));
//		}
//	} catch (Exception e) {
//		return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)")); // would never use, non-usable hidden button
//	}
//	return null; // should never happen
//}
//
//public void clickCreateAssessmentButton() {
//	CREASSwait = new WebDriverWait(wd,10);
//	CREASSwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div")));
//	try {
//		if (null != wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"))){
//			wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)")).click();
//		}
//	} catch (Exception e) {
//		wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div.container.ng-scope > div.row > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)")).click();; // is this possible? it's hidden..
//	}
//}
//
//// Create New Assessment Modal
//public WebElement getCloseCreateNewAssessmentButton() {
//	CREASSwait = new WebDriverWait(wd, 10);
//	CREASSwait.until(ExpectedConditions.presenceOfElementLocated(By.id("createAssessmentModal")));
//	return wd.findElement(By.cssSelector("#createAssessmentModal > div > div > div > button"));
//}
//
//public void clickCloseCreateNewAssessmentButton() {
//	CREASSwait = new WebDriverWait(wd,10);
//	CREASSwait.until(ExpectedConditions.presenceOfElementLocated(By.id("createAssessmentModal")));
//	wd.findElement(By.cssSelector("#createAssessmentModal > div > div > div > button")).click();
//}
//

//// CREATE ASSESSMENT METHODS /////////////
public WebElement getCreateAssessment() {
	CAwait = new WebDriverWait(wd,10);
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	CAwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)")));
	return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(4)"));
}

public WebElement getAssessmentCategory() {
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category")));
	return wd.findElement(By.cssSelector("#category"));
}

public int getCreateAssessmentAssessmentCategoryChildren() {
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

public WebElement getCreateAssessmentMaxPoints() {
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category")));
	return wd.findElement(By.cssSelector("#rawScore"));
}

public WebElement getCreateAssessmentAssessmentType() {
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category")));		
	return wd.findElement(By.cssSelector("#assessmentType"));
}

public int getCreateAssessmentTypeChildren() {
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

public WebElement getCreateAssessmentSAVEbutton() {
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category")));
	return wd.findElement(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-footer > input"));
}

public WebElement getCreateAssessmentCLOSEbutton() {
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-footer > button")));
	return wd.findElement(By.cssSelector("#createAssessmentModal > div > div > form > div.modal-footer > button"));
}


///// IMPORT GRADES ////////////////
public boolean canImportGrades () {
	BATCHwait = new WebDriverWait(wd,10);
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
	IGwait = new WebDriverWait(wd,10);
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	IGwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(3)")));
	return wd.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li:nth-child(3)"));
}

public WebElement getTextArea() {
IGwait = new WebDriverWait(wd,10);
IGwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#importGradesModal > div > div > form > div.modal-body > div:nth-child(2) > div > textarea")));
return wd.findElement(By.cssSelector("#importGradesModal > div > div > form > div.modal-body > div:nth-child(2) > div > textarea"));
}

public WebElement getImportGradesSAVE() {
	IGwait = new WebDriverWait(wd,10);
	IGwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#importGradesModal > div > div > form > div.modal-footer > input")));
	return wd.findElement(By.cssSelector("#importGradesModal > div > div > form > div.modal-footer > input"));
}

public WebElement getImportGradesCLOSE() {
	IGwait = new WebDriverWait(wd,10);
	IGwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#importGradesModal > div > div > form > div.modal-footer > button")));
	return wd.findElement(By.cssSelector("#importGradesModal > div > div > form > div.modal-footer > button"));
}


// WEEK TABS ///////////////	
public boolean weeksAvailable() {
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
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
	WeekWait = new WebDriverWait(wd,10);
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));

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
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	return wd.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[3]/ul/li[" + weeknum + "]/a"));
}

public WebElement getAddWeek() {
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	int wheretoadd = getNumberOfWeeks() + 1;
	return wd.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[3]/ul/li[" + wheretoadd + "]/a"));	
}

public WebElement getAddWeekYes() {
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#yesBtn")));
	return wd.findElement(By.cssSelector("#yesBtn"));
}

public WebElement getAddWeekNo() {
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#confirmingweeks > div > div > div.modal-footer > button.btn.btn-default")));
	return wd.findElement(By.cssSelector("#confirmingweeks > div > div > div.modal-footer > button.btn.btn-default"));
}

// NUMBER OF TRAINEES ///////
//#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(12)
public int getNumberOfTrainees() {
CreateModalCloseWait = new WebDriverWait(wd,10);
ImportModalCloseWait = new WebDriverWait(wd,10);
ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
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
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-2.col-md-2.col-lg-2.ng-binding")));
	return wd.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-2.col-md-2.col-lg-2.ng-binding"));
}

public WebElement getFlagComment(int child) {
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[" + child + "]/td[2]/form/input[1]")));
	return wd.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[" + child + "]/td[2]/form/input[1]"));
}

public WebElement getFlagSave(int child) {
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-1.col-md-1.col-lg-1 > form > input[type=\"submit\"]:nth-child(2)")));
	return wd.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-1.col-md-1.col-lg-1 > form > input[type=\"submit\"]:nth-child(2)"));
}

public WebElement getFlagClose(int child) {
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-1.col-md-1.col-lg-1 > form > span")));
	return wd.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > tbody > tr:nth-child(" + child + ") > td.col-sm-1.col-md-1.col-lg-1 > form > span"));
}

public int getNumberOfAssessments() {
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	ABWAIT = new WebDriverWait(wd,10);
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
		System.out.println("kids : " + children);
	}
return children - 4;
}

public int getAssessmentsByTestOrder(int child) {
	CreateModalCloseWait = new WebDriverWait(wd,10);
	ImportModalCloseWait = new WebDriverWait(wd,10);
	ConfirmingWeeksCloseWait = new WebDriverWait (wd,10);
	CreateModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#createAssessmentModal > div > div")));
	ImportModalCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#importGradesModal > div > div")));
	ConfirmingWeeksCloseWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirmingweeks > div > div")));
	ABWAIT = new WebDriverWait(wd,10);
	ABWAIT.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[1]")));
	return wd.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[1]/td[" + child + "]"));
}

	



}
