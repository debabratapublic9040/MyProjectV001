package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BasePage;

public class SetPriority extends BasePage{
	
	public SetPriority(WebDriver driver)
	{
		super(driver);
	}
   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	
    public WebElement loanNumber_field=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//h1//b")));
	//@FindBy(xpath="//input[@id='loanNo']") 
	//public WebElement loanNumber_field;
	
	//@FindBy(xpath="//a[@class='btn btn-primary btn-sm']") 
	//public WebElement setPriority_btn;
	public WebElement setPriority_btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-primary btn-sm'")));
	
	//@FindBy(xpath="//label[@id='lblMessage']") 
	//public WebElement setPriority_cofmsg;
	public WebElement setPriority_cofmsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='lblMessage']")));
	
	
	
}
