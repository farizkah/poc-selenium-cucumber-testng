package com.framework.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {

	@Given("User is logged in with email {string} and password {string}")
	public void user_is_logged_in_with_email_and_password(String string, String string2) {
	}

	@Given("User is at homepage {string}")
	public void user_is_at_homepage(String string) {
	}

	@When("User input {string} in the search bar")
	public void user_input_in_the_search_bar(String string) {
	}

	@When("User click search button")
	public void user_click_search_button() {
	}

	@Then("User can see search result")
	public void user_can_see_search_result() {
	}


}
