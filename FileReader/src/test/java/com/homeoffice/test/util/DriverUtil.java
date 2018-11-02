package com.homeoffice.test.util;


import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.homeoffice.test.configs.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverUtil {
	
	public static WebDriver driver;
	
	static String workingDir = System.getProperty("user.dir");
	
	public static final String ConfigurationPath = workingDir + "//src//test//resources//ChromeDriver//chromedriver.exe";
	
    private static final ChromeOptions options = new ChromeOptions();

    @Before
    public static void driverSetup() throws IOException {
    	
    	Config config= new Config(ConfigurationPath);
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win")) {
            System.setProperty("webdriver.chrome.driver",workingDir+config.getObject("ChromeDriverPath"));
        }
        options.addArguments("--start-maximized");
        options.addArguments("--disable-geolocation");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public static void driverClose() {
        driver.quit();
    }

	public static WebDriver initialize(String browser) throws IOException
	{
		Config config= new Config(ConfigurationPath);

		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",workingDir+config.getObject("ChromeDriverPath"));
			driver= new ChromeDriver();

		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static void quitDriver(WebDriver driver)
	{
		driver.quit();
	}



}
