package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	WebDriver driver ;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//i[@class='fa fa-user']") WebElement lnkMyAccountLogo ;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister ;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']") WebElement lnkLogin;
	
	
	public void clickMyAccountLogo()
	{
		lnkMyAccountLogo.click();
	}
	public void clickRegister()
	{
		lnkRegister.click();
	}
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	
}
