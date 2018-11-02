package com.homeoffice.test.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src//test//resources//features//VerifyVehicleDetails.feature",
		glue = "com.homeoffice.test.stepDefinition" ,
		plugin="html:target//cucumber_html_Report/"
		)

public class VerifyVehicleDetailsRunner {

}
