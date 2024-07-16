package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email' and @id='input-email']")WebElement txtEmailAddress ;
	@FindBy(xpath="//input[@name='password' and @id='input-password']")WebElement txtPassword;
	@FindBy(xpath="//input[@value='Login' and @class='btn btn-primary']")WebElement btnLogin;
	
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	public void setPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
	

}
