package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoansToAuditPage extends BasePage{
	
	public LoansToAuditPage(WebDriver driver)
	{
	 super(driver);
	}
	
	@FindBy(xpath="//table[@id='tblCategory' and @class='AQTTable1 table table-bordered']/thead/following-sibling::tbody/tr") 
	WebElement checklistCategory;
	
	@FindBy(xpath="//tr/td/table/tbody/tr/td[4]/div/select") 
	WebElement findingDropdown;
	
	@FindBy(xpath="//tr/td/table/tbody/tr/td[4]/div/select/option[3]") 
	WebElement passOptionFindingDropdown;
	

}
