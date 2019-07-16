package com.framework.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.framework.pageObjects.HomePage;
import com.framework.pageObjects.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductSteps {

	private String cityName, itemName;

	HomePage hp = new HomePage(BaseSteps.getDriver());
	SearchResultPage srPage = new SearchResultPage(BaseSteps.getDriver());

	@Given("User is at homepage")
	public void user_is_at_homepage() {
		hp.navigateToHomePage();
		hp.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("User search item {string} with city {string}")
	public void user_search_item_with_city(String item, String city) {
		hp.setCityName(city);
		this.cityName = city;

		hp.inputSearchBar(item);
		this.itemName = item;

		hp.clickButton(hp.getSearchButtonElement());
	}

	@Then("User can see city, item and label text matched in search result page")
	public void user_can_see_city_item_and_label_text_matched_in_search_result_page() {
		Assert.assertEquals(srPage.new VerifyPage(), srPage.new VerifyPage(cityName, itemName));
	}

}
