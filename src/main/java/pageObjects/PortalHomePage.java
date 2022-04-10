package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortalHomePage {

		WebDriver driver;
		
		public PortalHomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(css="[id='hero'] h1") WebElement textverification;
		
		public WebElement textverification()
		{
			return textverification;
		}
		
//		@FindBy(name="query") WebElement searchbox;
		
		
/*		public WebElement searchbox()
		{
			return searchbox;
		} */

}