package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.WorkflowPageORHomePage;

public class TC005SwitchToLuminateCDWWorkflowTest extends BaseClass{
	
	@Test(groups="Master")
	public void switchWorkflowTest() throws InterruptedException
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
		lp.userNameField.sendKeys(p.getProperty("userName"));
		logger.info("***Clear password field***");
		lp.passwordNameField.clear();
		logger.info("***Add Password***");
		lp.passwordNameField.sendKeys(p.getProperty("password"));
		logger.info("***Click on Login BTN***");
		lp.loginBTN.click();
		Thread.sleep(2000);
		
		WorkflowPageORHomePage whp=new WorkflowPageORHomePage(driver);
		logger.info("***Validate the username in the home page***");
		Assert.assertEquals(whp.getUserName().equals(p.getProperty("userName")),true);
		System.out.println(whp.getUserName());
		logger.info("***Switch to the workflow***");
		whp.switchWorkflow();
		Thread.sleep(1000);
		System.out.println(whp.getWorkflowName());
				
		Assert.assertEquals(whp.getWorkflowName().equals("Luminate CDW"),true);
		logger.info("***Click on toggle user dropdown***");
		Thread.sleep(2000);
		whp.toggle_User_Dropdown.click();
		logger.info("***Click on logout button***");
		Thread.sleep(2000);
		whp.btn_Logout.click();
			
		}
		catch(Exception e)
		{
		   // logger.error("***Test Failed***");
		    logger.info("***Test Case Failed***");
			Assert.fail(e.getMessage());
		}
	   
	}

}
