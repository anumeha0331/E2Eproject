package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By signIn=By.xpath("//span[contains(text(),'Login')]");
	By Featured=By.xpath("//h2[contains(text(),'Featured Courses')]");
	By Contact=By.xpath("//a[contains(text(),'Contact')]");
	By header= By.xpath("////h3[contains(text(),'An Academy to learn Everything about Testing')]");
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	public WebElement getFeTURED()
	{
		return driver.findElement(Featured);
		
	}

	public WebElement getContact()
	{
		return driver.findElement(Contact);
		
	}
	
	public WebElement getheader()
	{
		return driver.findElement(header);
		
	}
	public WebElement getLogIn()
	{
		return driver.findElement(signIn);
		
	}
	/*public LoginPage getLogIn()
	{
		driver.findElement(signIn).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
		
	}*/
}
