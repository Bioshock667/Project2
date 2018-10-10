package consoleTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AssessBatch;
import pages.HomePage;
import pages.LoginPage;
import pages.NavBarPage;

public class IanTestForHP {

	public static void main(String[] args) throws InterruptedException {
		File f = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		NavBarPage nbp = new NavBarPage(driver);
		AssessBatch ab = new AssessBatch(driver);
		
		
		lp.getUName().sendKeys("calibot@revature.com");
		lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
		lp.getLogin().click();		
		
		
		System.out.println("Prayers"); Thread.sleep(2000); nbp.getAccessBatchLink().click();
		
		String heyo = "Thread.sleep is not allowed, but waiting for something that doesn't exist is";
		WebDriverWait shh = new WebDriverWait(driver,3);
		
		ab.goToYear("2018");
		ab.goToBatchName("Genesis Bonds - 9/16/18");
		
		
//		shh.until(ExpectedConditions.attributeToBeNotEmpty(ab.getNotesByRow(1), "innerHTML"));
		ab.getWeek(10).click();
		ab.pause();
//		shh.until(ExpectedConditions.attributeToBeNotEmpty(ab.getNotesByRow(1), "innerHTML"));
		ab.getNotesByRow(1).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, heyo);
		ab.getWeek(20).click();
		ab.pause();
//		shh.until(ExpectedConditions.attributeToBeNotEmpty(ab.getNotesByRow(1), "innerHTML"));
		ab.getNotesByRow(1).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, heyo);
		ab.getWeek(30).click();
		ab.pause();
//		shh.until(ExpectedConditions.attributeToBeNotEmpty(ab.getNotesByRow(1), "innerHTML"));
		ab.getNotesByRow(1).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, heyo);
		ab.getBatchSaveButton().click();
		Thread.sleep(3000);
//		System.out.println("weeks : " + ab.getNumberOfWeeks());
//
//		
//		System.out.println("batches : " + ab.getBatchNumberOfChildren());
//		
//		System.out.println("years : " + ab.getYearNumberOfChildren());
//
//		System.out.println("weeks available : " + ab.weeksAvailable());
//		ab.getWeek(17).click();
//		ab.getFlag(1).click();
//		ab.getFlagComment(1).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, "WILD TIME");
//		ab.getFlagSave(1).click();
//		System.out.println("number of assessments : " + ab.getNumberOfAssessments());
//		Thread.sleep(5000);
		// ** CLOSE OUT ** //	
		System.out.println("CLOSING");
		driver.quit();
	}

	public static void UGtest(HomePage hp) throws InterruptedException {
		System.out.println("Getting and clicking User Guide");
		hp.getUserGuide().sendKeys(Keys.ENTER);
	}
	
	public static void LQAtest(HomePage hp) throws InterruptedException {
		System.out.println("Right Sel ENTER");
		hp.getRIGHTLQASelector().sendKeys(Keys.ENTER);
	
	////////// GO TO STATE 1 ---------------//
	
	System.out.println("RIGHT Sel DOWN      down to state 1 ** NOTE RIGHT");
	hp.getRIGHTLQASelector().sendKeys(Keys.DOWN);	
	System.out.println("Right Sel ENTER");
	hp.getRIGHTLQASelector().sendKeys(Keys.ENTER);

	// GO TO CHILD A of State 1
	// IN CHILD A
	System.out.println("Right Sel ENTER");
	hp.getRIGHTLQASelector().sendKeys(Keys.ENTER);
	System.out.println("Right Sel DOWN");
	hp.getRIGHTLQASelector().sendKeys(Keys.DOWN);
	System.out.println("Right Sel ENTER");
	hp.getRIGHTLQASelector().sendKeys(Keys.ENTER); // This grabs it by the top, so no need to go back up below
	hp.getRIGHTLQASelector().sendKeys(Keys.UP);

	//------------END OF State 1///////////

	/////// Start state 2 -------//

	// GO TO STATE 2
	
	System.out.println("LEFT Sel DOWN      down to state 2");
	hp.getLEFTLQASelector().sendKeys(Keys.DOWN);

	// GO TO CHILD A of State 2
	// INTO CHILD A
	System.out.println("Right Sel ENTER");
	hp.getRIGHTLQASelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel DOWN");
	hp.getRIGHTLQASelector().sendKeys(Keys.DOWN);
	
	System.out.println("Right Sel ENTER");
	hp.getRIGHTLQASelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel UP");
	hp.getRIGHTLQASelector().sendKeys(Keys.UP);

	//------------- END OF State 2 /////////// 

	//////////////// Start state 3----------//

	// GO TO STATE 3
	
	System.out.println("LEFT Sel DOWN      down to state 3");
	hp.getLEFTLQASelector().sendKeys(Keys.DOWN);

	// GO TO CHILD A of State 3
	// INTO CHILD A
	System.out.println("Right Sel ENTER");
	hp.getRIGHTLQASelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel DOWN");
	hp.getRIGHTLQASelector().sendKeys(Keys.DOWN);
	
	System.out.println("Right Sel ENTER");
	hp.getRIGHTLQASelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel UP");
	hp.getRIGHTLQASelector().sendKeys(Keys.UP);

	//------------- END OF State 3 /////////// 
	
	//////////////// Start state 4----------//

	// GO TO STATE 4
	
	System.out.println("LEFT Sel DOWN      down to state 4");
	hp.getLEFTLQASelector().sendKeys(Keys.DOWN);

	// GO TO CHILD A of State 4
	// INTO CHILD A
	System.out.println("Right Sel ENTER");
	hp.getRIGHTLQASelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel DOWN");
	hp.getRIGHTLQASelector().sendKeys(Keys.DOWN);
	
	System.out.println("Right Sel ENTER");
	hp.getRIGHTLQASelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel UP");
	hp.getRIGHTLQASelector().sendKeys(Keys.UP);

	//------------- END OF State 4 /////////// 
	
	
	}
	
	public static void toggles(HomePage hp) throws InterruptedException {
		hp.togLQApoor();System.out.println("hit poor");
		Thread.sleep(2000);
		hp.togLQAaverage();System.out.println("hit avg");
		Thread.sleep(2000);
		hp.togLQAgood();System.out.println("hit good");
		Thread.sleep(2000);
		hp.togLQAsuperstar();System.out.println("hit ss");
		Thread.sleep(2000);
	}
	
	public static void WPtest(HomePage hp) throws InterruptedException {
		System.out.println("Right Sel ENTER");
		hp.getRIGHTWPSelector().sendKeys(Keys.ENTER);
//		for (int i = 0; i < 10; i++) {
//			hp.getRIGHTWPSelector().sendKeys(Keys.UP);
//			hp.getRIGHTWPSelector().sendKeys(Keys.DOWN);
//		}
	
	////////// GO TO STATE 1 ---------------//
	
	System.out.println("RIGHT Sel DOWN      down to state 1 ** NOTE RIGHT");
	hp.getRIGHTWPSelector().sendKeys(Keys.DOWN);
	
	System.out.println("Right Sel ENTER");
	hp.getRIGHTWPSelector().sendKeys(Keys.ENTER);
	

	// GO TO CHILD A of State 1
	// IN CHILD A
	System.out.println("Right Sel ENTER");
	hp.getRIGHTWPSelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel DOWN");
	hp.getRIGHTWPSelector().sendKeys(Keys.DOWN);
	
	System.out.println("Right Sel ENTER");
	hp.getRIGHTWPSelector().sendKeys(Keys.ENTER); // This grabs it by the top, so no need to go back up below
	
	hp.getRIGHTWPSelector().sendKeys(Keys.UP);



	//------------END OF State 1///////////

	/////// Start state 2 -------//

	// GO TO STATE 2
	
	System.out.println("LEFT Sel DOWN      down to state 2");
	hp.getLEFTWPSelector().sendKeys(Keys.DOWN);

	// GO TO CHILD A of State 2
	// INTO CHILD A
	System.out.println("Right Sel ENTER");
	hp.getRIGHTWPSelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel DOWN");
	hp.getRIGHTWPSelector().sendKeys(Keys.DOWN);
	
	System.out.println("Right Sel ENTER");
	hp.getRIGHTWPSelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel UP");
	hp.getRIGHTWPSelector().sendKeys(Keys.UP);

	//------------- END OF State 2 /////////// 

	//////////////// Start state 3----------//

	// GO TO STATE 3
	
	System.out.println("LEFT Sel DOWN      down to state 3");
	hp.getLEFTWPSelector().sendKeys(Keys.DOWN);

	// GO TO CHILD A of State 3
	// INTO CHILD A
	System.out.println("Right Sel ENTER");
	hp.getRIGHTWPSelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel DOWN");
	hp.getRIGHTWPSelector().sendKeys(Keys.DOWN);
	
	System.out.println("Right Sel ENTER");
	hp.getRIGHTWPSelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel UP");
	hp.getRIGHTWPSelector().sendKeys(Keys.UP);

	//------------- END OF State 3 /////////// 
	
	//////////////// Start state 4----------//

	// GO TO STATE 4
	
	System.out.println("LEFT Sel DOWN      down to state 4");
	hp.getLEFTWPSelector().sendKeys(Keys.DOWN);

	// GO TO CHILD A of State 4
	// INTO CHILD A
	System.out.println("Right Sel ENTER");
	hp.getRIGHTWPSelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel DOWN");
	hp.getRIGHTWPSelector().sendKeys(Keys.DOWN);
	
	System.out.println("Right Sel ENTER");
	hp.getRIGHTWPSelector().sendKeys(Keys.ENTER);
	
	System.out.println("Right Sel UP");
	hp.getRIGHTWPSelector().sendKeys(Keys.UP);

	//------------- END OF State 4 /////////// 
	}

	public static void PPtest(HomePage hp) {}
}