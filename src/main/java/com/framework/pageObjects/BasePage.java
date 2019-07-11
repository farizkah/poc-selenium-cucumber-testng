package com.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	protected WebDriver driver;
	private final String urlHomePage = "https://olx.co.id";
	
	public BasePage(WebDriver webDriver) {
		driver = webDriver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void navigateToHomePage() {
		driver.get(urlHomePage);
	}
	
	public void navigateToPage(String url) {
		driver.get(url);
	}
	
	public void clickButton(WebElement buttonElement) {
		buttonElement.click();
	}
	
}
