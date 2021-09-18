package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;

import pageObjectModelsPackage.Home;
import pageObjectModelsPackage.SearchResults;
//test guthub
public class TestClass {
	private WebDriver driver;
	private Home homePage;
	private SearchResults resultsPage;

	@Test(description = "Given the browser is open, When I navigate to Google Home, Then Google logo will be displayed")
	public void checkThatGoogleLogoIsDisplayed() {
		Assert.assertTrue(homePage.isGoogleLogoImageDisplayed());
	}

	@Test
	public void checkThatPageTitleIsCorrect() {
		Assert.assertEquals(homePage.getPageTitle(), "Google");
	}

	@Test(description = "Given the browser is open, And I navigate to Google.com, When I search for 'Selenium WebDriver', Then The Result Stats will not be empty.")
	public void searchForSeleniumWebDriverAndCheckThatTheResultStatsAreNotEmpty() {
		homePage.search("Selenium WebDriver");
		Assert.assertTrue(!resultsPage.getResultStatsText().isEmpty());
	}

//	@BeforeClass
//	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//	}

	@BeforeMethod
	public void beforeMethod() {
		
		driver = DriverFactory.getDriver();
		//WebDriver driver = BrowserFactory.getBrowser();
		driver.manage().window().maximize();
		
		homePage = new Home(driver);
		resultsPage = new SearchResults(driver);
		
		homePage.navigate();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
