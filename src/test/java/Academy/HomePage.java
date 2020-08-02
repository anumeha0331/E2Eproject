package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base  {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializationDriver();
		log.info("driver is initialised");
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	
	@Test(dataProvider = "getdata")
	public void basePageNavigation(String username,String Password,String text) throws IOException
	{
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("driver Navigate to home page");
		LandingPage l = new LandingPage(driver);
		//LoginPage lp=l.getLogIn(); 
		l.getLogIn().click();
		LoginPage lp= new LoginPage(driver);
		
		
		//
		
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	Actions action = new Actions(driver);
	//action.moveToElement(lp.getEmail()).click().sendKeys(username).perform();
	//action.moveToElement(lp.getPassword()).click().sendKeys(Password).perform();
	lp.getEmail().sendKeys(username);
	lp.getPassword().sendKeys(Password);
			log.info(text);
			//action.moveToElement(lp.getLogIn()).click();
			
		log.info("test data printed successfully");
		lp.getLogIn().click();
		ForgotPassword fp=lp.Forgotpassword();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fp.getEmail().sendKeys("xyz@gmail.com");
		fp.submitButton().click();
		
		
		

	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	
	}
	
	@DataProvider
	public  Object[][] getdata()
	{
		Object[][] data= new Object[2][3];
		data[0][0]="abcd@gmail.com";
		data[0][1]="1234";
		data[0][2]="Restricted user";
		
		data[1][0]= "efgh@rediffmail.com";
		data[1][1]="5678";
		data[1][2]="NON-Restricted user";
		
		return data;
	}
	
}
