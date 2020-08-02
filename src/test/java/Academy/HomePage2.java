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

public class HomePage2 extends base  {
	public WebDriver driver;
	LandingPage l;
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
	public void ValidateTitleAPP() throws IOException
	{
		 l = new LandingPage(driver);
		
		Assert.assertEquals(l.getFeTURED().getText(), "FEATURED COURSES123");
		log.info("data compared sucessfully");
	
	}
	@Test
	public void ValidateHeader() throws IOException
	{
		//LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getheader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
		log.info("data compared sucessfully");
	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	
}
