package pageObjects;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page01_Page extends BasePage {
	public @FindBy(xpath = "//input[@id='orb-search-q']") WebElement textField_SearchBar;


	public Page01_Page() throws IOException {
		super();
	}
	
	public Page01_Page getBBCHomepage() throws IOException {
		getDriver().get("https://www.bbc.co.uk/news");
		return new Page01_Page();		
	}
	
	public Page01_Page clickOnSearchBar() throws IOException {
		textField_SearchBar.click();
		return new Page01_Page();		
	}
	


}
