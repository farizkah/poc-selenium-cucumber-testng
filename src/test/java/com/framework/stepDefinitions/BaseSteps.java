package com.framework.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * This class executes driver initialization with help of Hooks (before and
 * after). Hence, this class can't be extend by any step defs class because
 * cucumber won't you allowed it. Therefore, let driver variable set as static,
 * so step defs can access it to
 * 
 * @author farizkahfi
 *
 */
public class BaseSteps {

	static WebDriver driver;

	@Before
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.close();
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
