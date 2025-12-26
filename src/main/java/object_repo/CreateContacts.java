package object_repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtils;

public class CreateContacts extends WebDriverUtils {
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//td[contains(.,'Organization Name')]/following-sibling::td[@class='dvtCellInfo']/img")
	private WebElement selectOrgIcon;
	
	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;
	
	public CreateContacts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSelectOrgIcon() {
		return selectOrgIcon;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContacts(String contName) {
		lastName.sendKeys(contName);
		saveBtn.click();
	}
	
	public void createContacts(String contName,String org,WebDriver driver) {
		lastName.sendKeys(contName);
		selectOrgIcon.click();
		switchToWindow(driver, "Accounts&action");
		waitUntilTheElementIsClickable(driver, 5, searchBtn);
		searchText.sendKeys(org);
		searchBtn.click();
		driver.findElement(By.xpath("//a[contains(.,'"+org+"')]")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
	}
}
