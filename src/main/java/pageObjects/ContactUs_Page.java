package pageObjects;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import cucumber.api.DataTable;

public class ContactUs_Page extends BasePage {
	public @FindBy(xpath = "//input[@name='first_name']") WebElement textField_FirstName;
	public @FindBy(xpath = "//input[@name='last_name']") WebElement textField_LastName;
	public @FindBy(xpath = "//input[@name='email']") WebElement textField_EmailAddress;
	public @FindBy(xpath = "//textarea[@name='message']") WebElement textField_Message;
	public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement button_Submit;

	public ContactUs_Page() throws IOException {
		super();
	}
	
	public ContactUs_Page getContactUsPage() throws IOException {
		getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		return new ContactUs_Page();		
	}
	
	public ContactUs_Page enterFirstName() throws Exception {
		sendKeysToWebElement(textField_FirstName, "Paul");
		return new ContactUs_Page();		
	}
	
	public ContactUs_Page enterLastname(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textField_LastName, data.get(row).get(column));
		return new ContactUs_Page();		
	}
	
	public ContactUs_Page enterEmailAddress(String email) throws Exception {
		sendKeysToWebElement(textField_EmailAddress, email);
		return new ContactUs_Page();		
	}
	
	public ContactUs_Page enterMessage(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textField_Message, data.get(row).get(column));
		return new ContactUs_Page();		
	}
	
	public ContactUs_Page clickOnSubmitButton() throws Exception {
		waitAndClickElement(button_Submit);
		return new ContactUs_Page();
	}
	
	public ContactUs_Page confirmContactFormSubmissionWasSuccessful() throws IOException {
		WebElement thanksContactUsPage = getDriver().findElement(By.xpath("//div[@id='contact_reply']"));
		WaitUntilWebElementIsVisible(thanksContactUsPage);
		Assert.assertEquals("thankyouforyourmessage!5", thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
		return new ContactUs_Page();
	}

}
