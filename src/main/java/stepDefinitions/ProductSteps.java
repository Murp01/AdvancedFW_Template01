package stepDefinitions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductSteps {
	WebDriver driver;
	
	@Before()
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir"))
				.toRealPath() + "\\src\\test\\java\\resources\\other\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(123, TimeUnit.SECONDS);
	}
	
	@After
	public void teardown() throws InterruptedException{
		Thread.sleep(4000);
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
	}
	
	@Given("^user navigates to \"([^\"]*)\" website$")
	public void user_navigates_to_website(String url) throws Throwable {
		driver.get(url);
		Thread.sleep(3000);
	}

	@When("^the user click \"([^\"]*)\"$")
	public void the_user_click(String button) throws Throwable {
		driver.findElement(By.cssSelector(button)).click();
		Thread.sleep(3000);
	}

	@Then("^the user will be presented with a promo alert$")
	public void the_user_will_be_presented_with_a_promo_alert() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(3000);
	}

}
