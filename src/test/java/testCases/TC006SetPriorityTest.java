package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SetPriority;
import pageObjects.WorkflowPageORHomePage;

public class TC006SetPriorityTest extends BaseClass{
	
	@Test(groups="Master")
	public void setPriorityTest()
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
			logger.info("***Click On Set Priority Link***");
			whp.click_on_setPriority();
			Thread.sleep(2000);
			
			SetPriority sp=new SetPriority(driver);
			logger.info("***Enter the loa number***");
			sp.loanNumber_field.sendKeys(p.getProperty("loanNumber"));
			logger.info("***Click on setpriority BTN***");
			sp.setPriority_btn.click();
			Thread.sleep(2000);
			logger.info("***Validate the order***");
			Assert.assertEquals(sp.setPriority_cofmsg.getText().equals(p.getProperty("loanNumber")+" has been set as Rush order."),true);
			whp.click_on_workflowMenu();
			Thread.sleep(2000);
			logger.info("***Click on loans to audit queue***");
			//whp.loansToAudit_queue.click();sendToIQA_queue
			whp.loansToAudit_queue.click();
			Thread.sleep(2000);
			//System.out.println(whp.loanNumber1.getText());
			logger.info("***get the priority/rush loan number and validate the priority***");
			if(p.getProperty("loanNumberSetPriority").equals(whp.loanNumber1.getText()))
			{
				Assert.assertTrue(true);
			}
			else if(p.getProperty("loanNumberSetPriority").equals(whp.loanNumber2.getText()))
			{
				Assert.assertTrue(true);
			}
			else if(p.getProperty("loanNumberSetPriority").equals(whp.loanNumber3.getText()))
			{
				Assert.assertTrue(true);
			}
			else if(p.getProperty("loanNumberSetPriority").equals(whp.loanNumber4.getText()))
			{
				Assert.assertTrue(true);
			}
			else if(p.getProperty("loanNumberSetPriority").equals(whp.loanNumber5.getText()))
			{
				Assert.assertTrue(true);
			}
			else if(p.getProperty("loanNumberSetPriority").equals(whp.loanNumber6.getText()))
			{
				Assert.assertTrue(true);
			}
			else if(p.getProperty("loanNumberSetPriority").equals(whp.loanNumber7.getText()))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
				
			}
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
