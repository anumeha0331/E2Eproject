package stepDefinations;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination extends base{

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		driver = initializationDriver();
	}

	@Given("^click on the \"([^\"]*)\" site$")
	public void click_on_the_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		driver.get(arg1);
	}

	@Given("^click on the login link on HomePage to land on Secure sign in page$")
	public void click_on_the_login_link_on_HomePage_to_land_on_Secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		LandingPage l = new LandingPage(driver);
		
		l.getLogIn().click();
		//LoginPage lp=l.getLogIn(); 
	}

	
		
		@When("^User enters (.+) and (.+) 	and logsIn$")
	    public void user_enters_and_and_logsin(String username, String password) throws Throwable {
	        //throw new PendingException();
			//LandingPage l = new LandingPage(driver);
			//LoginPage lp=l.getLogIn(); 
			//l.getLogIn().click();
			LoginPage lp= new LoginPage(driver);
	    
		//
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	Actions action = new Actions(driver);
	//action.moveToElement(lp.getEmail()).click().sendKeys(username).perform();
	//action.moveToElement(lp.getPassword()).click().sendKeys(Password).perform();
			lp.getEmail().sendKeys(username);
			lp.getPassword().sendKeys(password);
			lp.getLogIn().click();
	}

	@Then("^Verify that user is successfully logIn$")
	public void verify_that_user_is_successfully_logIn() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		portalHomePage p= new portalHomePage(driver);
		Assert.assertTrue(p.getSearchBox().isDisplayed());
	}
	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	       // throw new PendingException();
		 driver.quit();
	    }

   
}