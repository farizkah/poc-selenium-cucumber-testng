package com.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage{
	
	public SearchResultPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(driver, this);
	}

	public SearchResultPage(WebDriver webDriver, String url) {
		this(webDriver);
		driver.get(url);
	}
	
	@FindBy(id = "cityField")
	private WebElement cityElement;
	
	@FindBy(id = "search-text") 
	private WebElement searchBar;
	
	@FindBy(id = "search-submit") 
	private WebElement searchButton;
	
	@FindBy(xpath = "//*[@id=\"offersnav-container\"]/div/div[1]/div[1]/ul/li[2]/h1") 
	private WebElement searchBreadcrumb;
	
	
	
	public class VerifyPage{
		
		String cityValue, searchValue, breadcrumbValue;
		
		public VerifyPage() {
			this.cityValue = cityElement.getAttribute("value");
			this.searchValue = searchBar.getAttribute("value");
			this.breadcrumbValue = searchBreadcrumb.getText();
		}
		
		public VerifyPage(String city, String search) {
			this.cityValue = city;
			this.searchValue = search;
			this.breadcrumbValue = "OLX - Cara Tepat Jual Cepat - "+search;
		}
		
		@Override
	    public String toString() {
	        return "SearchResult{" +
	                "city='" + cityValue + '\'' +
	                ", item='" + searchValue + '\'' +
	                ", breadcrumb='" + breadcrumbValue + '\'' +
	                '}';
	    }
		
		@Override
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	        if (o == null || getClass() != o.getClass())
	            return false;

	        VerifyPage expectedObject = (VerifyPage) o;

	        if (!cityValue.equals(expectedObject.cityValue))
	            return false;
	        if (!searchValue.equals(expectedObject.searchValue))
	            return false;
	        return searchValue.equals(expectedObject.searchValue);
	    }
		
	}
}
