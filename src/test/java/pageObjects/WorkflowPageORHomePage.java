package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BasePage;

public class WorkflowPageORHomePage extends BasePage{

	public WorkflowPageORHomePage(WebDriver driver)
	{
	super(driver);
	}
	
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	
    public WebElement userName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//h1//b"))); 
	//@FindBy(xpath="//li//h1//b") 
	//public WebElement userName;
    
    public WebElement toggle_User_Dropdown=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li//h1//b"))); 
	//@FindBy(xpath="//a[@class='dropdown-toggle user']//span[@class='caret']") 
	//public WebElement toggle_User_Dropdown;
	
	//public WebElement btn_Logout=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li//h1//b"))); 
	@FindBy(xpath="//a[normalize-space()='Logout']") 
	public WebElement btn_Logout;
	
	
	@FindBy(xpath="//a[normalize-space()='Change Password']") 
	public WebElement btn_ChangePassword;
	@FindBy(xpath="//span[@title='Switch Workflow']") 
	public WebElement switch_workflow;
	
	@FindBy(xpath="//li/a/span[text()='Luminate CDW']") 
	public WebElement drp_workflow;
	@FindBy(xpath="//div/button[text()='OK']") 
	public WebElement ok_workflowSwitchConfMessage;
	
	//@FindBy(xpath="//span[@class='filter-option pull-left']") 
	//public WebElement workflow_HomePage;
	public WebElement workflow_HomePage=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='filter-option pull-left']"))); 
	
	@FindBy(xpath="//a[normalize-space()='Set Priority']") 
	public WebElement setPriority_link;
	//public WebElement setPriority_link=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Set Priority']")));
	
	//@FindBy(xpath="//a[normalize-space()='Workflow']") 
	//public WebElement workflow_menu;
	public WebElement workflow_menu=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Workflow']")));
	
	@FindBy(xpath="//p[normalize-space()='Loans to Audit']") 
	public WebElement loansToAudit_queue;
	//public WebElement loansToAudit_queue=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Loans to Audit']")));
	
	//@FindBy(xpath="//p[normalize-space()='Send to iQA']") 
	//public WebElement sendToIQA_queue;
	public WebElement sendToIQA_queue=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Send to iQA']")));
	
	@FindBy(xpath="//table//tr[8]//td[1]") 
	public WebElement loanNumber7;
	@FindBy(xpath="//table//tr[7]//td[1]") 
	public WebElement loanNumber6;
	@FindBy(xpath="//table//tr[6]//td[1]") 
	public WebElement loanNumber5;
	@FindBy(xpath="//table//tr[5]//td[1]") 
	public WebElement loanNumber4;
	@FindBy(xpath="//table//tr[4]//td[1]") 
	public WebElement loanNumber3;
	@FindBy(xpath="//table//tr[3]//td[1]") 
	public WebElement loanNumber2;
	@FindBy(xpath="//table//tr[2]//td[1]") 
	public WebElement loanNumber1;
	@FindBy(xpath="//input[@id='fromDate']") 
	public WebElement fromDateFiled;
	@FindBy(xpath="//input[@id='toDate']") 
	public WebElement toDateFiled;
	@FindBy(xpath="//a[normalize-space()='Go']") 
	public WebElement dateFilterGoBTN;
	
	
	
	
	
	public void click_on_workflowMenu() throws InterruptedException
	{
		workflow_menu.click();
		Thread.sleep(1000);
	}
	public void click_on_setPriority() throws InterruptedException
	{
		setPriority_link.click();
		Thread.sleep(1000);
	}
	public String getWorkflowName()
	{
		String workflowName=workflow_HomePage.getText();
		return workflowName;
	}
	public String getUserName()
	{
		String name=userName.getText();
		return name;
	}
	public void switchWorkflow() throws InterruptedException
	{
		switch_workflow.click();
		Thread.sleep(2000);
		drp_workflow.click();
		Thread.sleep(2000);
		ok_workflowSwitchConfMessage.click();
	}

}
