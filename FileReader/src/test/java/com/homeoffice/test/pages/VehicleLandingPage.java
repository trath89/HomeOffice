package com.homeoffice.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VehicleLandingPage {
	
	public VehicleLandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this); 
    }

    @FindBy(how = How.CSS, using = "#get-started > a")
    private WebElement startNowButton;
    
    public void clickStartNowButton() {
    	startNowButton.click();
    }
	
}
