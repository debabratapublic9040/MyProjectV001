package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
	 super(driver);
	}
	
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	
    public WebElement loginText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Login']"))); 
	//@FindBy (xpath="//h4[text()='Login']")
	//public WebElement loginText;
	
	public WebElement userNameField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='UserName']")));
	//@FindBy(xpath="//input[@id='UserName']")
	//public WebElement userNameField;
	
	public WebElement passwordNameField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtPwd']")));
	//@FindBy(xpath="//input[@id='txtPwd']")
	//public WebElement passwordNameField;
	
	public WebElement loginBTN=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Log in']")));
	//@FindBy(xpath="//input[@value='Log in']")
	//public WebElement loginBTN;
	
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
