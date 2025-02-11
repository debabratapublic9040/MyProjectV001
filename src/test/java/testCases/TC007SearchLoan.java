package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.WorkflowPageORHomePage;

public class TC007SearchLoan extends BaseClass{
	
	@Test(groups="Master")
	public void loanSearchTest()
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
			Thread.sleep(2000);
			System.out.println(whp.getWorkflowName());	
			logger.info("***Validate the workflow name***");
			Assert.assertEquals(whp.getWorkflowName().equals("Luminate CDW"),true);
			logger.info("***Click on the workflow menu***");
			Thread.sleep(2000);
			whp.click_on_workflowMenu();
			logger.info("***Create the object***");
			SearchPage sp=new SearchPage(driver);
			logger.info("***Object created***");
			logger.info("***Search the loan***");
			sp.search_loan(p.getProperty("loanNumber"));
			logger.info("***Validate the serched loan in the search page***");
			Assert.assertEquals(sp.loanNumberSearchPage.getText().equals(p.getProperty("loanNumber")),true);
			System.out.println(sp.loanNumberSearchPage.getText());
			
			logger.info("***Click on toggle user dropdown***");
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
