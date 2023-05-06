package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.baseclass.JvmReports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@BookHotelWithUpiId", features = "src\\test\\resources",stepNotifications= true, dryRun = !true,monochrome=true, 
snippets = SnippetType.CAMELCASE, glue = "com.stepdefinition",
plugin = {"pretty", "json:target\\OmrBranch.json" ,"html:target-output\\index.html"})
public class TestRunnerClass {

	@AfterClass
	public static void afterExecution() {

		JvmReports.generateJvmReports(System.getProperty("user.dir") + ("\\target\\OmrBranch.json"));
	}

}
