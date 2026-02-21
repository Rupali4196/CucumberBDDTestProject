package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTest {
	WebDriver driver;
	WebDriverWait wait;

	public LoginTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(name = "username")
	WebElement txtUsername;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;

	public void setUsername(String uname) {
		wait.until(ExpectedConditions.visibilityOf(txtUsername));
		txtUsername.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		wait.until(ExpectedConditions.visibilityOf(txtPassword));
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
	}
}
