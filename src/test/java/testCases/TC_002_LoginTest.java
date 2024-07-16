package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{

	@Test(groups= {"sanity","master"})
	public void verify_login()
	{
		logger.info("***Starting TC_002_LoginTest ***");
	
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccountLogo();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
	    lp.setPassword(p.getProperty("password"));
	    lp.clickLogin();
	    
	    MyAccountPage macc=new MyAccountPage(driver);
	    
	    boolean targetPage = macc.isMyAccountPageExists();
	    if(targetPage==true)
	    {
	    	logger.info("Login test passed...");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	logger.info("login test fail");
	    	Assert.fail();
	    }
		}
		catch(Exception e)
		{
	        Assert.fail();
		}
		logger.info("***TC_002_LoginTest finished***");
	}
	
	
	
	
}




