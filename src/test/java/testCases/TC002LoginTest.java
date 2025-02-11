package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.WorkflowPageORHomePage;

public class TC002LoginTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void loginTest() throws InterruptedException
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
			
			
		
			if(lp.confirmationMSGValidation()==true)
				{
					logger.info("***Click on ok BTN***");
					lp.clickOnOkBTN();
					Thread.sleep(2000);
				}
			
			else {
				logger.info("No Current session");
			    }
			WorkflowPageORHomePage whp=new WorkflowPageORHomePage(driver);
		    logger.info("***Validate the username in the home page***");
				if(whp.getUserName().equals(p.getProperty("userName")))
				{
					System.out.println(whp.getUserName());
					logger.info("***Click on toggle user dropdown***");
					whp.toggle_User_Dropdown.click();
					logger.info("***Click on logout button***");
					whp.btn_Logout.click();
				}
				Assert.assertEquals(landingPage.logoTest(), true);
			
            }
		
		
		catch(Exception e)
			{
			   // logger.error("***Test Failed***");
			    logger.info("***Test Case Failed***");
				Assert.fail(e.getMessage());
			}
	}

}
