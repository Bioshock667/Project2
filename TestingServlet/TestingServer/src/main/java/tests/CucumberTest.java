package tests;

import org.testng.Assert;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberTest {
	
	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
	   System.out.println("setting given condition");
	}

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {
	    System.out.println("at when condition");
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
	   Assert.assertEquals(1, 1);
	}

}
