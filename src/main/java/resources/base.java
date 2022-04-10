package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{	
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
//mvn test -Dbrowser-chrome
		
//		String browserName = System.getProperty("browser");	// It is working fine with Jenkins Run
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.equals("chrome"))
		{
			// Execute in chrome browser
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium with Java\\Software Installs_IMP\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("edge"))
		{
			// Execute in edge browser
			System.setProperty("webdriver.edge.driver", "E:\\Selenium with Java\\Software Installs_IMP\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			// Execute in edge browser
			System.setProperty("webdriver.gecko.driver", "E:\\Selenium with Java\\Software Installs_IMP\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".jpg";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	
}
