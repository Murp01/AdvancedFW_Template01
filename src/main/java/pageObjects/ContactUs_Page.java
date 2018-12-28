package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs_Page extends BasePage {
	public @FindBy(xpath = "//input[@name='first_name']") WebElement textField_FirstName;
	public @FindBy(xpath = "//input[@name='last_name']") WebElement textField_LastName;
	public @FindBy(xpath = "//input[@name='email']") WebElement textField_EmailAddress;
	public @FindBy(xpath = "//input[@name='message']") WebElement textField_Message;
	public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement button_Submit;

	public ContactUs_Page() throws IOException {
		super();

	}

}
