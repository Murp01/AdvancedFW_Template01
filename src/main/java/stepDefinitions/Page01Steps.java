package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class Page01Steps extends DriverFactory{	
	
	@Given("^I access the BBC news homepage$")
	public void i_access_the_BBC_news_homepage() throws Throwable {
		page01Page.getBBCHomepage();
	}
	
	@Given("^I click on the searchbar$")
	public void i_click_on_the_searchbar() throws Throwable {
		page01Page.clickOnSearchBar();
	}

	@Given("^I enter \"([^\"]*)\" into the searchbar textfield$")
	public void i_enter_into_the_searchbar_textfield(String searchTerm) throws Throwable {
		page01Page.sendKeysToWebElement(page01Page.textField_SearchBar, searchTerm);
	}

	@When("^I click on the search icon$")
	public void i_click_on_the_search_icon() throws Throwable {

	}

	@Then("^the search results will retrieve results matching the \"([^\"]*)\" search term$")
	public void the_search_results_will_retrieve_results_matching_the_search_term(String arg1) throws Throwable {

	}
}
	

