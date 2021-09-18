package pageObjectModelsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Home {
	
	//variables
	private WebDriver driver;
	private String url = "https://www.google.com/";
	
	//locators
	By googleLogo_image = By.tagName("img"); // img
	By search_textBox = By.name("q"); // *[@name='q']

	//constructor
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	//keywords / actions
	public void navigate() {
		driver.navigate().to(url);
	}
	
	public boolean isGoogleLogoImageDisplayed() {
		return driver.findElement(googleLogo_image).isDisplayed();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void search(String query) {
		driver.findElement(search_textBox).sendKeys(query + Keys.ENTER);
	}
}
