package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BasePage;

public class LandingPage extends BasePage{
	
	public LandingPage(WebDriver driver)
	{
	 super(driver);
	}
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	
	public WebElement login_link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#loginModal']")));
	//@FindBy(xpath="//a[@href='#loginModal']")
	//WebElement login_link;
	
	//public WebElement auditgeniue_logo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/AuditGenius_External_UAT/Assets/Img/Audit-Genius-Logo_whiteletters.png']")));
	@FindBy(xpath="//img[@src='/AuditGenius_External_UAT/Assets/Img/Audit-Genius-Logo_whiteletters.png']")
	WebElement auditgeniue_logo;
	
	@FindBy(xpath="//*[contains(text(),'Copyright')]")
	WebElement copyright_year;
	@FindBy(xpath="//a[normalize-space()='Learn More']")
	WebElement learnmore_link;
	@FindBy(xpath="//a[normalize-space()='Indecomm Global Services']")
	WebElement indecommglobalsevices_link;
	@FindBy(xpath="//h2[text()='AuditGenius']")
	WebElement landing_page_text1;
	@FindBy(xpath="//p[text()='KAIZEN is now AUDITGENIUS']")
	WebElement landing_page_text2;
	@FindBy(xpath="//p[text()='Your QC platform - Enhanced with new product features, improved performance and stability, and enhanced reporting capabilities.']")
	WebElement landing_page_text3;
	@FindBy(xpath="//p[text()='Introducing Automated Loan Audits and Reviews and Business Intelligence and Analytics. ']")
	WebElement landing_page_text4;
	
	
	public void click_on_login_link()
	{
		login_link.click();
	}
	public boolean logoTest()
	{
		boolean logoStatus=auditgeniue_logo.isDisplayed();
		
		return logoStatus;
	}
			
	
	

}
