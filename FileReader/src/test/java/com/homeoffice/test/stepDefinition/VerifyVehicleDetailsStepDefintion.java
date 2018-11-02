package com.homeoffice.test.stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.junit4.SpringRunner;

import com.homeoffice.test.configs.Config;
import com.homeoffice.test.configs.Driver;
import com.homeoffice.test.pages.VehicleCheckPage;
import com.homeoffice.test.pages.VehicleDetailsPage;
import com.homeoffice.test.pages.VehicleLandingPage;
import com.homeoffice.test.util.DriverUtil;
import com.homeoffice.test.util.ServiceReader;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class VerifyVehicleDetailsStepDefintion {
	
	private List<String[]> vehicleList;
	
    WebDriver driver;
    
    private final ServiceReader serviceReader = new ServiceReader();
    
    VehicleLandingPage vehicleLandingPage;
    
    VehicleCheckPage vehicleCheckPage;
    
    VehicleDetailsPage vehicleDetailsPage;
	
	
	@Given("^User has access to \"([^\"]*)\" files from \"([^\"]*)\" directory$")
	public void user_has_access_to_files_from_directory(String fileType, String directory) throws Throwable {
		vehicleList = serviceReader.getVehicleInfo(fileType, directory);
        Assert.assertFalse("Vehice details missing", vehicleList.size() < 1);
	}

	@When("^User opens the webpage \"([^\"]*)\"$")
	public void user_opens_the_webpage(String url) throws Throwable {
		driver= Driver.initialize("chrome");
		driver.get(url);
	}

	@When("^User hit the startnow button$")
	public void user_hit_the_startnow_button() throws Throwable {
		vehicleLandingPage = new VehicleLandingPage(driver);
		vehicleLandingPage.clickStartNowButton();
	}

	@Then("^User veriy vehicle details with excel data on the vehicle details page$")
	public void user_veriy_vehicle_details_with_excel_data_on_the_vehicle_details_page() throws Throwable {
		vehicleCheckPage = new VehicleCheckPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
        for (String[] vehcileInfo : vehicleList) {
        	vehicleCheckPage.enterRegNumber(vehcileInfo[0]);
        	vehicleCheckPage.clickContinue();
            vehicleDetailsPage.validate(vehcileInfo[1], vehcileInfo[2]);
            vehicleDetailsPage.searchAgain();
        }
	}
	
}
