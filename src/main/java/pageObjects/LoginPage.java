package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

		WebDriver driver;
		
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css="[id='user_email']") WebElement emailaddress;
		@FindBy(css="[id='user_password']") WebElement password;
		@FindBy(xpath="//input[@type='submit']") WebElement login;
		By forgotpassword = By.cssSelector("[href*='password/new']");
		
		public ForgotPassword forgotpassword()
		{
			driver.findElement(forgotpassword).click();
			return new ForgotPassword(driver);
			
		}
		
		public WebElement emailaddress()
		{
			return emailaddress;
		}
		
		public WebElement password()
		{
			return password;
		}
		
		public WebElement login()
		{
			return login;
		}

}