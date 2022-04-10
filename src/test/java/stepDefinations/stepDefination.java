package stepDefinations;

import java.io.IOException;
import org.junit.Assert;
import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.base;

@RunWith(Cucumber.class)
	public class stepDefination extends base {

		@Given("Initialize the browser with chrome")
		public void initialize_the_browser_with_chrome() throws IOException {
			// Write code here that turns the phrase above into concrete actions
			driver=initializeDriver();
		}
					
		@And("^Navigate to \"([^\"]*)\" site$")
		public void navigate_to_something_site(String strArg1) throws Throwable {
			driver.get(strArg1);
		}
			
		@And("Click on Login link in homw page to land on signin page")
		public void click_on_login_link_in_homw_page_to_land_on_signin_page() {
			// Write code here that turns the phrase above into concrete actions
			// IsDisplayed() will not work as this popup is always showing on DOM but sometimes, not on application
			LandingPage l = new LandingPage(driver);
			if(l.getPopUpSize().size()>0)
			{
				l.jonpopup().click();
			}
			driver.manage().window().maximize();
//			LoginPage popup = l.jonpopup();
			
		}
		
/*		@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
		public void user_enters_and_and_logs_in(String arg1, String arg2) throws InterruptedException {

			driver.findElement(By.xpath("//span[contains(text(), 'Register')]")).click();
			driver.findElement(By.cssSelector("[class='bodyMain text-center-xs m-b-5-xs'] a")).click();
			LandingPage l = new LandingPage(driver);
			Thread.sleep(2000);
			LoginPage lp = l.loginlink();
			lp.emailaddress().sendKeys(arg1);
			lp.password().sendKeys(arg2);
			lp.login().click();
		}  */
		
		@When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
			
			LandingPage l = new LandingPage(driver);
			Thread.sleep(2000);
			LoginPage lp = l.loginlink();
			lp.emailaddress().sendKeys(username);
			lp.password().sendKeys(password);
			lp.login().click();
			
	    }
		
		
		@Then("Verify the user is successfully logged in")
		public void verify_the_user_is_successfully_logged_in() {
			// Write code here that turns the phrase above into concrete actions
			PortalHomePage p = new PortalHomePage(driver);
			Assert.assertTrue(p.textverification().isDisplayed());
			System.out.println(p.textverification().getText());
		}
		
		@And("^Close browsers$")
	    public void close_browser() throws Throwable {
			driver.quit();
	    }

}