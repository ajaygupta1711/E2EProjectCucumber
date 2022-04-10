package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By jonpopup = By.xpath("//div[@class='listbuilder-popup-scale']//button[contains(text(), 'NO THANKS')]");
	By loginlink = By.xpath("//span[contains(text(), 'Login')]");
	By featuredcourses = By.cssSelector("section[id='content'] h2"); // .text-center>h2 - new way to identify the webelement
	By navigationbar = By.cssSelector("[class='navbar-collapse collapse'] li");
	By header = By.cssSelector("[id='banner'] h3");
	
	public WebElement jonpopup()
	{
		return driver.findElement(jonpopup);
	}
	
	public List<WebElement> getPopUpSize()
	{
		return driver.findElements(jonpopup);
	}
	
	public LoginPage loginlink()
	{
		driver.findElement(loginlink).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public WebElement featuredcourses()
	{
		System.out.println("Try to identify the navigation bar");
		return driver.findElement(featuredcourses);
	}
	
	public WebElement navigationbar()
	{
		return driver.findElement(navigationbar);
	}
	
	public WebElement header()
	{
		return driver.findElement(header);
	}
	
}