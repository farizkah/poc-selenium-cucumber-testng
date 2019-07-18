package com.framework.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.framework.pageObjects.LoginPage;
import com.framework.pageObjects.MyAdPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginUserSteps {

	LoginPage lp = new LoginPage(BaseSteps.getDriver());
	MyAdPage map = new MyAdPage(BaseSteps.getDriver());

	@When("User is logged in with email {string} and password {string}")
	public void user_is_logged_in_with_email_and_password(String email, String pass) {
		lp.navigateToHomePage();
		lp.getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		lp.clickButton(lp.getLoginLinkElement());
		lp.login(email, pass);
		lp.clickButton(lp.getLoginBtnElement());
	}

	@Then("User can see account profile page")
	public void user_can_see_account_profile_page() {
		Assert.assertEquals(map.new VerifyPage().toString(),
				map.new VerifyPage("https://www.olx.co.id/iklanku/", "bonekaomkecil", "Iklan Saya", true).toString());

	}
}
