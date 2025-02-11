package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BasePage;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	
	@FindBy (xpath="//i[@class='zmdi zmdi-search zmdi-hc-fw']")
	WebElement search_menu;
	//public WebElement search_menu=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='zmdi zmdi-search zmdi-hc-fw']")));
	
	@FindBy (xpath="//input[@id='txtSearchText']")
	WebElement search_field;
	//public WebElement search_field=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='txtSearchText']")));
	
	@FindBy (xpath="//button[@id='btnSearchLoan']")
	public WebElement search_btn;
	//public WebElement search_btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSearchLoan']")));
	
	@FindBy(xpath="//td[@id='tdorderNo']") 
	public WebElement loanNumberSearchPage;
	//public WebElement loanNumberSearchPage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='tdorderNo']")));
	
	public void search_loan(String loanNumber)
	{
		search_menu.click();
		search_field.sendKeys(loanNumber);
		search_btn.click();
	}
}
