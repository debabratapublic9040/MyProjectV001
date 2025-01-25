package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class WorkflowPageORHomePage extends BasePage{

	public WorkflowPageORHomePage(WebDriver driver)
	{
	super(driver);
	}
	
	@FindBy(xpath="//li//h1//b") 
	public WebElement userName;
	@FindBy(xpath="//a[@class='dropdown-toggle user']//span[@class='caret']") 
	public WebElement toggle_User_Dropdown;
	@FindBy(xpath="//a[normalize-space()='Logout']") 
	public WebElement btn_Logout;
	@FindBy(xpath="//a[normalize-space()='Change Password']") 
	public WebElement btn_ChangePassword;
	
	public String getUserName()
	{
		String name=userName.getText();
		return name;
	}

}
