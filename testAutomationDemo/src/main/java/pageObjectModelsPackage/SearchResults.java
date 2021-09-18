package pageObjectModelsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {
	//variables
	private WebDriver driver;
	
	//locators
	private By resultStats_label = By.id("result-stats");		

	
	//constructor
	public SearchResults(WebDriver driver) {
		this.driver = driver;
	}
	
	//keywords
	public String getResultStatsText() {
		return driver.findElement(resultStats_label).getText();
	}
}
