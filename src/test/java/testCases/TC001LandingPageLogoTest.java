package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.LandingPage;

public class TC001LandingPageLogoTest extends BaseClass{
	
	@Test(groups={"Saity","Master"})
	public void logo_test() throws InterruptedException
	{
		try {
		LandingPage lp=new LandingPage(driver);
		logger.info("***Validate the logo***");
		Assert.assertEquals(lp.logoTest(), true);
		//Assert.assertEquals(lp.logoTest(), true,"Login Failed");
		//Assert.assertTrue(lp.logoTest());
		logger.info("***click on the login link***");
		lp.click_on_login_link();
		Thread.sleep(1000);
		}
		
		catch(Exception e)
		{
			//logger.error("***Test Failed***");
			//logger.debug("***Debug logs***");
			logger.info("***Test Failed***");
			Assert.fail(e.getMessage());
		}
	}
	
	
	
}
