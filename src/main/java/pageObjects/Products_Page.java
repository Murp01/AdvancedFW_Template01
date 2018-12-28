package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page extends BasePage{
	
	public @FindBy(css = "#container-special-offers") WebElement button_SpecialOffers;
	public @FindBy(css = "#container-product2") WebElement button_Laptops;
	public @FindBy(xpath = "//button[text()='Proceed']") WebElement button_Proceed_Popup;	
	public @FindBy(xpath = "//div[@class='modal-body']//b[contains(text(), 'NEWCUSTOMER')]") WebElement voucherNumber;

	public Products_Page() throws IOException {
		super();

	}

}
//div[@class='modal-body']//b[contains(text(), 'NEWCUSTOMER')]