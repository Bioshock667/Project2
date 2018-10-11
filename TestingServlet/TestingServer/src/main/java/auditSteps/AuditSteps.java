package auditSteps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AuditPage;
import pages.LoginPage;

public class AuditSteps {
	private ChromeDriver driver;
	private AuditPage auditpage;
	private Properties props;
	private int numberCurrentWeeks;
	private WebElement FBBtn;
	private WebElement currentWeek;
	{
		File f  = new File("../webapps/TestingServer/WEB-INF/classes/chromedriver.exe");
		//File f = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
		driver = new ChromeDriver();
		props = new Properties();
		try {
			FileInputStream in = new FileInputStream("../webapps/TestingServer/WEB-INF/classes/info.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Given("^I visit the login page$")
	public void i_visit_the_login_page() throws Throwable {
		driver.get(props.getProperty("url"));
	}

	@When("^I enter correct credentials And I click Submit$")
	public void i_enter_correct_credentials_And_I_click_Submit() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.getUName().sendKeys(props.getProperty("uname"));
		lp.getPwd().sendKeys(props.getProperty("pwd"));
		lp.getLogin().click();
	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Throwable {
//		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("home")));
//	    Assert.assertEquals(driver.getCurrentUrl(), props.getProperty("homeUrl"));
	}

	
	@Given("^I am at the Quality Audit Page$")
	public void i_am_at_the_Quality_Audit_Page() throws Throwable {
	    driver.get(props.getProperty("auditUrl"));
	    auditpage = new AuditPage(driver);
	}

	@Given("^I can add weeks$")
	public void i_can_add_weeks() throws Throwable {
	    // Implement if there are maximum weeks
	}
	
	@When("^I click the new week button And I click yes on the New Week dialog$")
	public void i_click_the_new_week_button() throws Throwable {
		numberCurrentWeeks = auditpage.getWeeks().size();
	    auditpage.getAddWeekButton().click();
	    auditpage.getAddWeekYesButton().click();
	}
	
	@Then("^there should be one more week than beforehand$")
	public void there_should_be_one_more_week_than_beforehand() throws Throwable {
		WebDriverWait w = new WebDriverWait(driver, 10);
		Thread.sleep(2000);
	    int newNumberWeeks = auditpage.getWeeks().size();
	    int difference = newNumberWeeks - numberCurrentWeeks;
	    Assert.assertEquals(difference, 1);
	}
//	
//	@Given("^There exists an orange question mark for individual feedback$")
//	public void there_exists_an_orange_question_mark_for_individual_feedback() throws Throwable {
//	    FBBtn = auditpage.getTraineeFBButton();
//	    String className = FBBtn.getAttribute("class");
//	    Assert.assertEquals(className, "fa fa-question-circle fa-2x pick");
//	}
//	@When("^I click the symbol twice$")
//	public void i_click_the_symbol_twice() throws Throwable {
//	    FBBtn.click();
//	    FBBtn.click();
//	}
//	@Then("^The symbol should be a green happy face$")
//	public void the_symbol_should_be_a_green_happy_face() throws Throwable {
//	    String className = FBBtn.getAttribute("class");
//	    Assert.assertEquals(className, expected);
//	}
	
//
//@Given("^I am on the Quality Audit Page$")
//public void i_am_on_the_Quality_Audit_Page() throws Throwable {
//
//    driver.get("https://dev-caliber.revature.tech/caliber/#/vp/audit");
//}
//
//@When("^I type \"([^\"]*)\" in Ians feedback box And I hit refresh$")
//public void i_type_in_Ians_feedback_box_And_I_hit_refresh(String arg1) throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//}
//
//@Then("^the feedback box should say \"([^\"]*)\"$")
//public void the_feedback_box_should_say(String arg1) throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//}

@Given("^I am on the Quality Audit Page And I have Week (\\d+) selected$")
public void i_am_on_the_Quality_Audit_Page_And_I_have_Week_selected(int arg1) throws Throwable {

    driver.get("https://dev-caliber.revature.tech/caliber/#/vp/audit");
    auditpage = new AuditPage(driver);
    System.out.println(auditpage.getWeeks());
    auditpage.getWeeks().get(arg1 - 1).click();
}

@When("^I click Positive Symbol And I type \"([^\"]*)\" in overall feedback And I click the Save button$")
public void i_click_Positive_Symbol_And_I_type_in_overall_feedback_And_I_click_the_Save_button(String arg1) throws Throwable {
    auditpage.getPositiveResponseButton().click();
    auditpage.getResponseTextArea().sendKeys(arg1);
    auditpage.getSaveButton().click();
    Thread.sleep(2000);
}

@Then("^after I move to home before going back to Quality Audit page And then go back to Week (\\d+), the Positive Symbol is highlighted And the overall feeback says \"([^\"]*)\"$")
public void after_I_move_to_home_before_going_back_to_Quality_Audit_page_And_then_go_back_to_Week_the_Positive_Symbol_is_highlighted_And_the_overall_feeback_says(int arg1, String arg2) throws Throwable {
    driver.get(props.getProperty("homeUrl"));
    Thread.sleep(2000);
    driver.get(props.getProperty("auditUrl"));
    auditpage.getWeeks().get(arg1 - 1).click();
    String posBtnClass = auditpage.getPositiveResponseButton().getAttribute("class");
    String value = auditpage.getResponseTextArea().getAttribute("value");
    //Assert.assertEquals(posBtnClass, "fa fa-smile-o fa-2x pick");
    Assert.assertEquals(value, arg2);
}

@After
public void ending() {
	driver.quit();
}
}
