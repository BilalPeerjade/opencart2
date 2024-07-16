package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage (WebDriver driver)
	{
		super (driver);
	}
	@FindBy(xpath="//h2[text()='My Account']")WebElement msgHeadline;
	@FindBy(xpath="//a[@class='list-group-item' and text()='Logout']")WebElement lnkLogout;
	

	
	
	
	public boolean isMyAccountPageExists()  //MyAccount Page Heading display status
	{
		try
		{
			return(msgHeadline.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}

	public void clickLogout()
	{
		lnkLogout.click();
	}
}
