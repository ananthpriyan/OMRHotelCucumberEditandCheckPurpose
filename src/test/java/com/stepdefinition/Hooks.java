package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@Before
	public void beforeEachScenario()  {

	    getDriver("chrome");
		openUrl(getPropertyfileValue("url"));
		maximizeWindow();
	}

	@After
	public void afterEachScenario(Scenario scenario) {

		boolean failed = scenario.isFailed();
		System.out.println("is Failed      :" + failed);

		if (failed) {

			scenario.attach(screenShot(), "image/png", "screenshot");

		}
		// closeBrowser();

	}

}
