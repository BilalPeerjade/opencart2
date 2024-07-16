package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{

	
	@Test (groups= {"regression","master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccountLogo();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on Registration link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
	    
//   IT WILL GENERATE EVERY TIME NEW DATA FOR REGISTRATION PAGE:-
		
		regpage.setFirstName(randomeString().toUpperCase() +" TEST");
		Thread.sleep(500);
		regpage.setLastName(randomeString().toUpperCase() + " TEST");
		Thread.sleep(500);
		regpage.setEmail(randomeString().toLowerCase()+"test@gamil.com");
		Thread.sleep(500);
		regpage.setTelephone(randomeNumber());
		Thread.sleep(500);
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		Thread.sleep(500);
		regpage.clickPrivicyPolicyChk();
		Thread.sleep(500);
	    regpage.clickContinueButton();
	    logger.info("Clicked On Continue");
	    
	    String confmesg = regpage.getConfirmationMsg();
	    logger.info("Validation Expeted Message...");
		Assert.assertEquals(confmesg , "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Fail");
			Assert.fail();
		}
		logger.info("***Finished TC_001_AccountRegistrationTest ***");
	}
	
}
