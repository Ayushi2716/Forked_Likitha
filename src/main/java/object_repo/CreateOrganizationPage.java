package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtils;

public class CreateOrganizationPage extends WebDriverUtils {
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrganization(String organizeName) {
		orgName.sendKeys(organizeName);
		saveBtn.click();
	}

	public void createOrganization(String organizeName,String industryDDValue,WebDriver driver) {
		waitUntilTheElementIsClickable(driver, 5, orgName);
		orgName.sendKeys(organizeName);
		dropdownUsingContainsVisibleText(industryDD, industryDDValue);
		saveBtn.click();
	}
}
