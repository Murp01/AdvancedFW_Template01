package utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import pageObjects.BasePage;
import pageObjects.Page01_Page;
import pageObjects.Page02_Page;

public class DriverFactory {

	public static WebDriver driver;
	public static BasePage basePage;
	public static Page01_Page page01Page;
	public static Page02_Page page02Page;

	public WebDriver getDriver() {

		try {
			Properties p = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + 
					"\\src\\main\\java\\properties\\config.properties");
			p.load(fi);
			String browserName = p.getProperty("browser");


			switch (browserName) {

			case "firefox":
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			case "chrome":
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					// ChromeOptions options = new ChromeOptions();
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;

			case "ie":
				if (null == driver) {
					// DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
					// caps.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
				}
			}

		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			page01Page = PageFactory.initElements(driver, Page01_Page.class);
			page02Page = PageFactory.initElements(driver, Page02_Page.class);
			basePage = PageFactory.initElements(driver, BasePage.class);
			
		}
		return driver;

	}

}
