package pages;

import java.util.List;

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
	
	
//Trainees Modal
	public WebElement getTraineesGlyph() {
		String selector = "span[class='glyphicon glyphicon-user']";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getTraineesModal() {
		String selector = "traineeModalLabel";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesClose() {
		String selector = "button[data-dismiss=\"modal\"]";
		
		return wd.findElement(By.cssSelector(selector));
	}
	
//Trainnes Add Modal
	public WebElement getTraineesAdd() {
		String selector = "a[data-target=\"#addTraineeModal\"]";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getTraineesAddModal() {
		String selector = "addTraineeModal";
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddName() {
		String selector = "traineeName";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddEmail() {
		String selector = "traineeEmail";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddSkype() {
		String selector = "traineeSkype";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddPhone() {
		String selector = "traineePhone";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddCollege() {
		String selector = "traineeCollege";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddDegree() {
		String selector = "traineeDegree";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddMajor() {
		String selector = "traineeMajor";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddRecruiter() {
		String selector = "traineeRecruiterName";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddTechScreener() {
		String selector = "traineeTechScreenerName";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddProjectCompletion() {
		String selector = "traineeProjectCompletion";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddProfileURL() {
		String selector = "input[placeholder=\"http://www.example.com/revature\"]";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getTraineesAddTrainingStatus() {
		String selector = "traineeStatus";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(selector)));
		
		return wd.findElement(By.id(selector));
	}
	
	public WebElement getTraineesAddSave() {
			String selector = "input[ng-show=\"!Updating.status\"]";
			wait = new WebDriverWait(wd, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
			
			return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getTraineesAddClose() {
		String selector = "close";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.className(selector)));
		
		return wd.findElement(By.className(selector));
	}
	
	public boolean getTraineesViewName(String name) {
	    boolean isFound = false;
	    List<WebElement> rows = wd.findElements(By.cssSelector("#viewTraineeModal > div > div > div.modal-body.only-top-padding > div.col-md-12.col-lg-12 > div > table > tbody > tr:nth-child(1)"));
	    for(WebElement row : rows){
	        if(row.findElement(By.cssSelector("#viewTraineeModal > div > div > div.modal-body.only-top-padding > div.col-md-12.col-lg-12 > div > table > tbody > tr:nth-child(1) > td:nth-child(1)")).getText().equals(name)) {
	            isFound = true;
	            break;
	        }
	    }
	    return isFound;
	}
	
	public WebElement getTraineesEdit() {
		String selector = "a[ng-click=\"populateTrainee(trainee);getTrainee($index)\"]";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getTraineesEditSave() {
		String selector = "input[ng-show=\"Updating.status\"]";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getTraineesDelete() {
		String selector = "a[data-target=\"#deleteTraineeModal\"]";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getTraineesConfirmModal() {
		String selector = "#deleteTraineeModal > div > div";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
		
		return wd.findElement(By.cssSelector(selector));
	}
	
	public WebElement getTraineesConfirmDelete() {
		String selector = "//*[@id=\"deleteTraineeModal\"]/div/div/div[3]/input";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
		
		return wd.findElement(By.xpath(selector));
	}
	
	public WebElement getTraineesConfirmCancel() {
		String selector = "//*[@id=\"deleteTraineeModal\"]/div/div/div[3]/button";
		wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
		
		return wd.findElement(By.xpath(selector));
	}
}
