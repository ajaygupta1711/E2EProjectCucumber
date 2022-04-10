package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	WebDriver driver;
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By emailaddress = By.cssSelector("[id='user_email']");
	By forgotpassword = By.cssSelector("[href*='password/new']");
	By sendMeInstructions = By.cssSelector("[type='submit']");

	public WebElement emailaddress()
	{
		return driver.findElement(emailaddress);
	}

	public ForgotPassword forgotpassword()
	{
		driver.findElement(forgotpassword).click();
		return new ForgotPassword(driver);
	}
	
	public WebElement sendMeInstructions()
	{
		return driver.findElement(sendMeInstructions);
	}
	
}
