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
	
	public Products_Page clickOnProceedButton_PopUp() throws InterruptedException, IOException{
		waitAndClickElement(button_Proceed_Popup);
		return new Products_Page();
	}
	
	public String printSpecialOfferVoucherCode(){
		WaitUntilWebElementIsVisible(voucherNumber);
		String voucherCode = voucherNumber.getText();
		System.out.println("Voucher Code: " + voucherCode);
		return voucherCode;
	}

}
