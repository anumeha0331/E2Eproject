package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitleContact extends base  {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
@BeforeTest
public void initialize() throws IOException
{
	driver = initializationDriver();
	log.info("driver is initialised");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
 driver.get(prop.getProperty("url"));
 log.info("driver Navigate to home page");
	
}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		LandingPage l = new LandingPage(driver);
		//l.getLogIn().click();
		
		Assert.assertTrue(l.getContact().isDisplayed());
		log.info("data is displayed successfully");
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
