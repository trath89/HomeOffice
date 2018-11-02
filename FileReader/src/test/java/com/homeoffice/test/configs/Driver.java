package com.homeoffice.test.configs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver
{
	public static WebDriver driver;
	static String workingDir = System.getProperty("user.dir");


	public static final String ConfigurationPath = workingDir + "//Configproperties//config.properties";

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
