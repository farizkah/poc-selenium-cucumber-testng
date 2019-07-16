package com.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	private WebElement emailInput;
	
	@FindBy(id = "userPass")
	private WebElement passInput;
	
	@FindBy(className = "f_checkbox")
	private WebElement rememberElement;
	
	@FindBy(id = "se_userLogin")
	private WebElement loginBtn;
	
	public void login(String email, String pass) {
		emailInput.sendKeys(email);
		passInput.sendKeys(pass);
	}
	
	public WebElement getLoginBtnElement() {
		return loginBtn;
	}
}
