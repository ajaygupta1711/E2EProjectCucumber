package Academy;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

// Adding Logs
// Generate HTML Report
// Screenshot on Failure
// Jenkins Integration


public class ValidateNavigationBar extends base {
	
	public WebDriver driver;
	
	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());  

	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void basePageNavigation()
	{		
		LandingPage l = new LandingPage(driver);
		LoginPage popup = l.jonpopup();
		Assert.assertTrue(l.navigationbar().isDisplayed());
		log.info("Successfully validated Text message");
	}	
	
	
	@AfterTest
	public void  teardown()
	{
		driver.close();
	}
	
}