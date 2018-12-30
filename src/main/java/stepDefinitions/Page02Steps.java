package stepDefinitions;

import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class Page02Steps extends DriverFactory{
	
	@Given("^user navigates to \"([^\"]*)\" website$")
	public void user_navigates_to_website(String url) throws Throwable {
		getDriver().get(url);
	}

	@When("^the user click \"([^\"]*)\"$")
	public void the_user_click(String button) throws Throwable {
		basePage.WaitUntilWebElementIsVisibleUsingByLocator(By.xpath(button));
		getDriver().findElement(By.xpath(button)).click();
	}


}
