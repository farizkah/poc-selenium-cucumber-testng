package com.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAdPage extends BasePage{

	public MyAdPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"topLoginLink\"]/span[2]/strong")
	private WebElement usernameElement;
	
	@FindBy(xpath = "//*[@id=\"usertabs\"]/div[1]/h2")
	private WebElement tabTitleElement;
	
	@FindBy(xpath = "//*[@id=\"usertabs\"]/ul/li[1]/span")
	private WebElement tabLabelElement;
	
	public class VerifyPage{
		String url, username, tabTitle;
		boolean tabElement;
		
		public VerifyPage(){
			this.url = driver.getCurrentUrl();
			this.username = usernameElement.getText();
			this.tabTitle = tabTitleElement.getText();
			this.tabElement = tabLabelElement.getAttribute("class").contains("selected");
		}
		
		public VerifyPage(String url, String username, String tabTitle, Boolean tabElement){
			this.url = url;
			this.username = username;
			this.tabTitle = tabTitle;
			this.tabElement = tabElement;
		}
		
		@Override
	    public String toString() {
	        return "SearchResult{" +
	                "url='" + url + '\'' +
	                ", username='" + username + '\'' +
	                ", tabTitle='" + tabTitle + '\'' +
	                ", tabElement='" + tabElement + '\'' +
	                '}';
	    }
		
		@Override
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	        if (o == null || getClass() != o.getClass())
	            return false;

	        VerifyPage expectedObject = (VerifyPage) o;

	        if (!url.equals(expectedObject.url))
	            return false;
	        if (!username.equals(expectedObject.username))
	            return false;
	        if (!tabTitle.equals(expectedObject.tabTitle))
	            return false;
	        return tabElement;
	    }
	}
	
}
