package com.homeoffice.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VehicleCheckPage {
    public String button = "#content > form > div > div > div.form-group.no-bottom > fieldset > button";

    @FindBy(how = How.CSS, using = "#Vrm")
    private WebElement regNo;

    @FindBy(how = How.CSS, using = "#content > form > div > div > div.form-group.no-bottom > fieldset > button")
    private WebElement continueButton;

    public VehicleCheckPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void enterRegNumber(String registrationNumber) {
        regNo.sendKeys(registrationNumber);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
