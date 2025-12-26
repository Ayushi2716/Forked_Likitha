package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
	
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement createOpportunityIcon;
	
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateOpportunityIcon() {
		return createOpportunityIcon;
	}
	
	public void clickOnOpportunity() {
		createOpportunityIcon.click();
	}


}
