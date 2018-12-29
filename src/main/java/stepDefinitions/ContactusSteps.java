package stepDefinitions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ContactusSteps extends DriverFactory{	
	
	@Given("^I access webdriveruniversity contact us form$")
	public void i_access_webdriveruniversity_contact_us_form() throws Throwable {
		contactUsPage.getContactUsPage();	
	}

	@When("^I enter a valid firstname$")
	public void i_enter_a_valid_firstname() throws Exception {
		contactUsPage.enterFirstName();
	}

	@When("^I enter a valid lastname$")
	public void i_enter_a_valid_lastname(DataTable dataTable) throws Exception {
		contactUsPage.enterLastname(dataTable, 0, 1);	
	}

	@When("^I enter a valid email address$")
	public void i_enter_a_valid_email_address() throws Exception {
		contactUsPage.enterEmailAddress("webdriveruniversity@hotmail.com");
	}

	@When("^I enter comments$")
	public void i_enter_comments(DataTable dataTable) throws Exception {
		contactUsPage.enterMessage(dataTable, 0, 1);
	}

	@When("^I click on the submit button$")
	public void i_click_on_the_submit_button() throws Exception {
		contactUsPage.clickOnSubmitButton();
	}

	@Then("^the information will successfully be submitted via the contact us form$")
	public void the_information_will_successfully_be_submitted_via_the_contact_us_form() throws Exception {
		contactUsPage.confirmContactFormSubmissionWasSuccessful();
	}
	

}
