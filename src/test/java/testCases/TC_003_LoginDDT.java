package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{

	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String res)
	{
		logger.info("*** Starting TC_003_LoginDDT ***");
		try
		{
		//home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccountLogo();
		hp.clickLogin();
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		//My Account Page  
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		if(res.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(res.equals("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
//				macc.clickLogout();
				Assert.assertTrue(true);
			}
		}
		
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finish TC_003_LoginDDT ***");
	}
}
