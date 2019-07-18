package com.framework.stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class executes driver initialization with help of Cucumber Hooks (before and
 * after). Hence, this class can't be extend by any step defs class because
 * cucumber won't you allowed it. Therefore, let driver variable set as static,
 * so step defs can access it to
 * 
 * @author farizkahfi
 *
 */
public class BaseSteps {

	private static WebDriver driver;
	private Properties config;

	@Before
	public void beforetest() throws IOException {
		configureDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	private void configureDriver() throws IOException {
		config = new Properties();
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(System.getProperty("user.dir")+"/resources/configuration.properties");
			 config.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found : "+e.getMessage());
		}
		
		if(config.getProperty("com.framework.properties.browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			
		}else if(config.getProperty("com.framework.properties.browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
