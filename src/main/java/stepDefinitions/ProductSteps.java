package stepDefinitions;

import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ProductSteps extends DriverFactory{
	
	@Given("^user navigates to \"([^\"]*)\" website$")
	public void user_navigates_to_website(String url) throws Throwable {
		getDriver().get(url);
	}

	@When("^the user click \"([^\"]*)\"$")
	public void the_user_click(String button) throws Throwable {
		basePage.WaitUntilWebElementIsVisibleUsingByLocator(By.cssSelector(button));
		getDriver().findElement(By.cssSelector(button)).click();
	}

	@Then("^the user will be presented with a promo alert$")
	public void the_user_will_be_presented_with_a_promo_alert() throws Throwable {
		productsPage.printSpecialOfferVoucherCode();
		productsPage.clickOnProceedButton_PopUp();
	}

}
