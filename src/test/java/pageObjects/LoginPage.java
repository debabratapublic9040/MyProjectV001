package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
	 super(driver);
	}
	
	@FindBy (xpath="//h4[text()='Login']")
	public WebElement loginText;
	@FindBy(xpath="//input[@id='UserName']")
	public WebElement userNameField;
	@FindBy(xpath="//input[@id='txtPwd']")
	public WebElement passwordNameField;
	@FindBy(xpath="//input[@value='Log in']")
	public WebElement loginBTN;
	@FindBy(xpath="//div[normalize-space()='You have already logged into AuditGenius."
			+ " Would you like to close the existing session and continue with this new session ?']") 
	WebElement msg_Confirmation;
	@FindBy(xpath="//button[normalize-space()='OK']") 
	WebElement ok_btn;
	@FindBy(xpath="//button[normalize-space()='Cancel']") 
	WebElement cancel_btn;
	@FindBy(xpath="//li[normalize-space()='User id or password is invalid.']") 
	WebElement loginFailedMSG;
	
	
	public boolean loginTextValidation()
	{
		boolean status1=loginText.isDisplayed();
		return status1;
	}
	
	public boolean confirmationMSGValidation()
	{
		boolean status2=msg_Confirmation.isDisplayed();
		return status2;
	}
	public void clickOnOkBTN()
	{
		ok_btn.click();
	}
	public boolean loginFailedMSGTest()
	{
		boolean status3=loginFailedMSG.isDisplayed();
		return status3;
	}

	

}
