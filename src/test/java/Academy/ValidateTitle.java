package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base {
	
	public WebDriver driver;
	public LandingPage l;

	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());  
	
		@BeforeTest
		public void initialize() throws IOException
		{
			driver=initializeDriver();
			log.info("Driver is initialized");
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			log.info("Navigated to Home page");
		}
	
		@Test
		public void validateAppTitle() throws IOException
		{
			// One is inheritance
			// Creating object to that class and invoke methods of it.
			l = new LandingPage(driver);
			l.jonpopup();
			
			Assert.assertEquals(l.featuredcourses().getText(), "FEATURED COURSES");
				
			// Compare the text from the browser with actual test - ERROR..
			log.info("Successfully validated Text message");
			System.out.println("Test Completed");
		}
		
		@Test
		public void validateheader()
		{
			Assert.assertEquals(l.header().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		}
		
		
		@AfterTest
		public void  teardown()
		{
			driver.close();
		}
		
}