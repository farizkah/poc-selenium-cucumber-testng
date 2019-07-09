package com.framework.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	features = "src/test/resources/features", 
					glue = "com.framework.stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests{

	static WebDriver driver;
	
	@BeforeTest
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.get("https://olx.co.id/#");
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
