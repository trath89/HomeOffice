package com.homeoffice.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class VehicleDetailsPage {

	@FindBy(how = How.CSS, using = "#pr3 > div > ul > li:nth-child(2) > span:nth-child(2) > strong")
    private WebElement makeElement;

    @FindBy(how = How.CSS, using = "#pr3 > div > ul > li:nth-child(3) > span:nth-child(2) > strong")
    private WebElement colorElement;

    @FindBy(how = How.CSS, using = "#proposition-name")
    private WebElement searchAgain;

    public VehicleDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void validate(String make, String color) {
        assertEquals("Vehicle details does not match or Vehicle details could not be found", make.toUpperCase(), makeElement.getText());
        assertEquals("Vehicle details does not match or Vehicle details could not be found", color.toUpperCase(), colorElement.getText());
    }

    public void searchAgain() {
        searchAgain.click();
    }
}
