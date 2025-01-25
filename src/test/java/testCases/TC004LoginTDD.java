package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.WorkflowPageORHomePage;
import utilities.DataProviders;

public class TC004LoginTDD extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")
	public void login_TDD(String username,String password,String exp) throws InterruptedException
	{
		try {	
		    LandingPage landingPage=new LandingPage(driver);
			logger.info("***Click on Login link***");
			landingPage.click_on_login_link();
			LoginPage lp=new LoginPage(driver);
			Assert.assertEquals(lp.loginTextValidation(), true);
			logger.info("***Clear user name field***");
			lp.userNameField.clear();
			logger.info("***Add Username***");
			lp.userNameField.sendKeys(username);
			logger.info("***Clear password field***");
			lp.passwordNameField.clear();
			logger.info("***Add Password***");
			lp.passwordNameField.sendKeys(password);
			logger.info("***Click on Login BTN***");
			lp.loginBTN.click();
			Thread.sleep(3000);
			WorkflowPageORHomePage whp=new WorkflowPageORHomePage(driver);
			
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(whp.getUserName().equals(username))
					{
						logger.info("***Click on toggle user dropdown***");
						whp.toggle_User_Dropdown.click();
						logger.info("***Click on logout button***");
						whp.btn_Logout.click();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);	
					}
				}
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(whp.getUserName().equals(p.getProperty("userName")))
					{
						logger.info("***Click on toggle user dropdown***");
						whp.toggle_User_Dropdown.click();
						logger.info("***Click on logout button***");
						whp.btn_Logout.click();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);	
					}
				}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
		
}


