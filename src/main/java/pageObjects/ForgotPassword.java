package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ForgotPassword {

	public WebDriver driver;
	
	By emailid=By.xpath("//input[@id='user_email']");
	By submit = By.xpath("//input[@name='commit']");
	public ForgotPassword(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement getEmail()
	{
		
		return driver.findElement(emailid);
		
	}
	public WebElement submitButton()
	{
		return driver.findElement(submit);
		
	}
		
	
}
