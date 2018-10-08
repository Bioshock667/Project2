package consoleTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import pages.HomePage;
import pages.LoginPage;

public class IanTestForHP {

	public static void main(String[] args) throws InterruptedException {
		File f = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);

		lp.getUName().sendKeys("calibot@revature.com");
		lp.getPwd().sendKeys("*6Ak4-&kXnNTfTh6");
		lp.getLogin().click();		
		
		
		System.out.println("Prayers");

		
		// TEST User Guide
//		UGtest(hp);
		
		// TEST Weekly Progress ... Chart and Table
//		LQAtest(hp);
		
		// TEST Weekly Progress ... Chart and Table
//		WPtest(hp);
		
		// TEST Panel Progress ... Chart and Table(small)
//		 PPtest(hp);
		
		// THESE ARE RELATIVE, Don't Work
//		hp.getRIGHTLQASelector();
//		toggles(hp);
//		Thread.sleep(3000);
//		toggles(hp);
//		Thread.sleep(3000);
		
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