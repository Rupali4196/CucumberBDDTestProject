package StepDefination;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.LoginTest;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class StepDef {

	WebDriver driver;
	LoginTest loginPage;
	WebDriverWait wait;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Given("user is on OrangeHRM login page")
	public void user_is_on_OrangeHRM_login_page() {
		// Page already opened in @Before
	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String uname, String pwd) {
		loginPage = new LoginTest(driver);
		loginPage.setUsername(uname);
		loginPage.setPassword(pwd);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		loginPage.clickLogin();

		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")),
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']"))));
	}

	@Then("user should see {string}")
	public void user_should_see(String result) {

		if (result.equalsIgnoreCase("dashboard")) {

			WebElement dashboard = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

			assertTrue("Dashboard is not displayed", dashboard.isDisplayed());

		} else if (result.equalsIgnoreCase("Invalid credentials")) {

			WebElement errorMsg = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']")));

			assertTrue("Error message not displayed", errorMsg.isDisplayed());
		}
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
