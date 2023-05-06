package com.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on OMR Branch hotel login page")
	public void userIsOnOMRBranchHotelLoginPage() {
	}

	@When("User login {string},{string}")
	public void userLogin(String user, String pass) {

		pom.getLoginPage().login(user, pass);
	}

	@Then("User should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String success) {

		Assert.assertTrue("Success message after login", pom.getLoginPage().loginSuccessMessage().contains(success));
	}

	@When("User login using  keyboard actions {string},{string}")
	public void userLoginUsingKeyboardActions(String string, String string2) throws AWTException {

		pom.getLoginPage().loginWithRobotClass(string, string2);
	}

	@Then("User should verify error message {string}")
	public void userShouldVerifyErrorMessage(String error) {

		Assert.assertTrue("Veirfy error message", pom.getLoginPage().loginErrorMessage().contains(error));
	}

}
