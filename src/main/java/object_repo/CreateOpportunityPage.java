package object_repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtils;

public class CreateOpportunityPage extends WebDriverUtils {
	
	@FindBy(name="potentialname")
	private WebElement oppName;
	
	@FindBy(id="related_to_type")
	private WebElement relatedTo;
	
	@FindBy(xpath ="(//td[contains(.,'Related To')]/following::td/img)[1]")
	private WebElement selectRlatedTo;
	
	@FindBy(name="search_text")
	private WebElement searchField;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(id="jscal_trigger_closingdate")
	private WebElement calender;
	
	@FindBy(name="sales_stage")
	private WebElement sales;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOppName() {
		return oppName;
	}

	public WebElement getRelatedTo() {
		return relatedTo;
	}

	public WebElement getSelectRlatedTo() {
		return selectRlatedTo;
	}
	
	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getCalender() {
		return calender;
	}

	public WebElement getSales() {
		return sales;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOpportunity(String opp,WebDriver driver,String org,String orgName,String salesStageValue) {
		oppName.sendKeys(opp);
		dropdownUsingContainsVisibleText(relatedTo, org);
		selectRlatedTo.click();
		switchToWindow(driver, "Accounts&action");
		searchField.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[contains(.,'"+orgName+"')]")).click();
		switchToWindow(driver, "Potentials&action");
		calender.click();
		driver.findElement(By.xpath("//td[.='10']")).click();
		dropdownUsingContainsVisibleText(sales, salesStageValue);
		saveBtn.click();
	}
	
	public void createOpportunity(WebDriver driver,String opp,String cont,String contName,String salesStageValue) {
		oppName.sendKeys(opp);
		dropdownUsingContainsVisibleText(relatedTo, cont);
		selectRlatedTo.click();
		switchToWindow(driver, "Accounts&action");
		searchField.sendKeys(contName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[contains(.,'"+contName+"')]")).click();
		switchToWindow(driver, "Potentials&action");
		calender.click();
		driver.findElement(By.xpath("//td[.='10']")).click();
		dropdownUsingContainsVisibleText(sales, salesStageValue);
		saveBtn.click();
	}

	
	
	
	
	

}
