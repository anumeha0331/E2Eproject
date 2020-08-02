package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

	public WebDriver driver;
	By forgotpass= By.xpath("//a[@class='link-below-button']");
	By email=By.xpath("//input[@id='user_email']");
	By password=By.xpath("//input[@id='user_password']");
	By logIn=By.xpath("//input[@name='commit']");
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement getEmail()
	{
		
		return driver.findElement(email);
		
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
		
	}
	public WebElement getLogIn()
	{
		return driver.findElement(logIn);
				
	}
	public ForgotPassword Forgotpassword()
	{
		driver.findElement(forgotpass).click();
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;
	}
	
}
