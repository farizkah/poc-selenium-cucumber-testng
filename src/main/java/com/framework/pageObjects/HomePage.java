package com.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(driver, this);
	}

	public HomePage(WebDriver webDriver, String url) {
		this(webDriver);
		driver.get(url);
	}
	
	@FindBy(id = "cityField")
	private WebElement cityElement;
	
	@FindBy(id = "filterCities") //
	private WebElement cityInput;
	
	@FindBy(xpath = "//*[@id=\"filterCitiesAutosuggest\"]/li[1]/a")
	private WebElement cityPick;
	
	@FindBy(id = "headerSearch")
	private WebElement searchBar;
	
	@FindBy(id = "submit-searchmain")
	private WebElement searchButton;
	
	public WebElement getSearchButtonElement() {
		return searchButton;
	}
	
	public void setCityName(String cityToSelected) {
		cityElement.click();
		cityInput.sendKeys(cityToSelected);
		cityPick.click();
	}
	
	public void inputSearchBar(String item) {
		searchBar.sendKeys(item);
	}
	
}
