package com.framework.stepDefinitions;

import org.testng.Assert;

import com.framework.helper.TestRunner;
import com.framework.pageObjects.HomePage;
import com.framework.pageObjects.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {

	private String cityName, itemName;
	
	HomePage hp = new HomePage(TestRunner.getDriver());
	SearchResultPage srPage = new SearchResultPage(TestRunner.getDriver());
	SearchResultPage srPages = srPage;
	
	
	@Given("User is logged in with email {string} and password {string}")
	public void user_is_logged_in_with_email_and_password(String string, String string2) {
		
	}

	@Given("User is at homepage")
	public void user_is_at_homepage() {
		hp.navigateToHomePage();
	}
	
	@When("User choose city {string}")
	public void user_choose_city(String city) {	
		hp.setCityName(city);
		this.cityName = city;
	}

	@When("User input {string} in the search bar")
	public void user_input_in_the_search_bar(String item) {
		hp.inputSearchBar(item);
		this.itemName = item;
	}

	@When("User click search button")
	public void user_click_search_button() {
		hp.clickButton(hp.getSearchButtonElement());
	}

	@Then("User can see search result")
	public void user_can_see_search_result() {	 
		Assert.assertEquals(srPage.new SearchResult(), srPage.new SearchResult(cityName, itemName));
	}


}
