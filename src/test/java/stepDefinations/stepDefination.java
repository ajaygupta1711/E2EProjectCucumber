package stepDefinations;

import java.io.IOException;

import org.junit.runner.RunWith;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import junit.framework.Assert;
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
		
		@Given("Navigate to \"([^\"]*)\" Site$")
		public void navigate_to_site(String arg1) throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			driver.get(arg1);
			
		}
		
		@Given("Click on Login link in homw page to land on signin page")
		public void click_on_login_link_in_homw_page_to_land_on_signin_page() {
			// Write code here that turns the phrase above into concrete actions
			LandingPage l = new LandingPage(driver);
			LoginPage popup = l.jonpopup();
		}
		
		@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
		public void user_enters_and_and_logs_in(String arg1, String arg2) {
			// Write code here that turns the phrase above into concrete actions
			LandingPage l = new LandingPage(driver);
			LoginPage lp = l.loginlink();
			lp.emailaddress().sendKeys(arg1);
			lp.password().sendKeys(arg2);
			lp.emailaddress().sendKeys(arg1);
			lp.password().sendKeys(arg2);
			lp.login().click();
		}
		
		@SuppressWarnings("deprecation")
		@Then("Verify the user is successfully logged in")
		public void verify_the_user_is_successfully_logged_in() {
			// Write code here that turns the phrase above into concrete actions
			PortalHomePage p = new PortalHomePage(driver);
			Assert.assertTrue(p.searchbox().isDisplayed());
		}

}