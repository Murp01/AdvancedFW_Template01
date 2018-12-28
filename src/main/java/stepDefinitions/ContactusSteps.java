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
		getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		
	}

	@When("^I enter a valid firstname$")
	public void i_enter_a_valid_firstname() throws Throwable {
		Thread.sleep(3000);
		getDriver().findElement(By.cssSelector("input[name='first_name']")).sendKeys("Paul");
	}

	@When("^I enter a valid lastname$")
	public void i_enter_a_valid_lastname(DataTable dataTable) throws Throwable {
		List<List<String>> data = dataTable.raw();
		
		getDriver().findElement(By.cssSelector("input[name='last_name']")).sendKeys(data.get(0).get(1));
		
	}

	@When("^I enter a valid email address$")
	public void i_enter_a_valid_email_address() throws Throwable {
		getDriver().findElement(By.cssSelector("input[name='email']")).sendKeys("webdriveruniversity@hotmail.com");
	}

	@When("^I enter comments$")
	public void i_enter_comments(DataTable dataTable) throws Throwable {
		List<List<String>> data = dataTable.raw(); 
		getDriver().findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(0).get(0));
		getDriver().findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(0).get(1));
	}

	@When("^I click on the submit button$")
	public void i_click_on_the_submit_button() throws Throwable {
		getDriver().findElement(By.cssSelector("input[value='SUBMIT']")).click();
	}

	@Then("^the information will successfully be submitted via the contact us form$")
	public void the_information_will_successfully_be_submitted_via_the_contact_us_form() throws Throwable {
		WebElement thanksContactPage = getDriver().findElement(By.xpath("//div[@id='contact_reply']"));		
		Thread.sleep(3000);
		//value after replace all is a regex value, removes spaces or digits with "" - no space
		Assert.assertEquals("thankyouforyourmessage!", thanksContactPage.getText().toLowerCase()
				.replaceAll("[ ()0-9]", ""));
		System.out.println(thanksContactPage);
	}
	

}
