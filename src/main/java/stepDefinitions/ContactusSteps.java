package stepDefinitions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactusSteps {
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
	
	
	@Given("^I access webdriveruniversity contact us form$")
	public void i_access_webdriveruniversity_contact_us_form() throws Throwable {
		driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		
	}

	@When("^I enter a valid firstname$")
	public void i_enter_a_valid_firstname() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Paul");
	}

	@When("^I enter a valid lastname$")
	public void i_enter_a_valid_lastname(DataTable dataTable) throws Throwable {
		List<List<String>> data = dataTable.raw();
		
		driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys(data.get(0).get(1));
		
	}

	@When("^I enter a valid email address$")
	public void i_enter_a_valid_email_address() throws Throwable {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("webdriveruniversity@hotmail.com");
	}

	@When("^I enter comments$")
	public void i_enter_comments(DataTable dataTable) throws Throwable {
		List<List<String>> data = dataTable.raw(); 
		driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(0).get(0));
		driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(0).get(1));
	}

	@When("^I click on the submit button$")
	public void i_click_on_the_submit_button() throws Throwable {
		driver.findElement(By.cssSelector("input[value='SUBMIT']")).click();
	}

	@Then("^the information will successfully be submitted via the contact us form$")
	public void the_information_will_successfully_be_submitted_via_the_contact_us_form() throws Throwable {
		WebElement thanksContactPage = driver.findElement(By.xpath("//div[@id='contact_reply']"));		
		Thread.sleep(3000);
		//value after replace all is a regex value, removes spaces or digits with "" - no space
		Assert.assertEquals("thankyouforyourmessage!", thanksContactPage.getText().toLowerCase()
				.replaceAll("[ ()0-9]", ""));
		System.out.println(thanksContactPage);
	}
	

}
