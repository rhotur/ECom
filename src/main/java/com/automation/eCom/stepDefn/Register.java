package com.automation.eCom.stepDefn;

import org.openqa.selenium.By;

import com.automation.eCom.commonlibrary.CommonLib;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Register extends CommonLib{
	@When("^I click on Register$")
	public void i_click_on_Register() throws Throwable {
		//driver.findElement(By.linkText("Register")).click();
	}

	@Then("^I verify Register Label dislayed$")
	public void i_verify_Register_Label_dislayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^I click on male Radio button$")
	public void i_click_on_male_Radio_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^I enter \"([^\"]*)\"$")
	public void i_enter(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^I select \"([^\"]*)\"$")
	public void i_select(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^I will close browser for iteration$")
	public void i_will_close_browser_for_iteration() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}
}
