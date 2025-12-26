package object_repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtils;

public class CreateInvoicePage extends WebDriverUtils {
	@FindBy(name="subject")
	private WebElement invoiceName;

	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement selectSalesOrder;

	@FindBy(xpath="(//img[@title='Select'])[3]")
	private WebElement selectOrgName;

	@FindBy(name="bill_street")
	private WebElement billingAdd;

	@FindBy(xpath="//b[.='Copy Billing address']/ancestor::td[@class='detailedViewHeader']/input")
	private WebElement copyBillingAdd;

	@FindBy(id="searchIcon1")
	private WebElement searchIcon;

	@FindBy(name="search_text")
	private WebElement searchField;

	@FindBy(name="search")
	private WebElement searchBtn;

	@FindBy(id="qty1")
	private WebElement qty;

	@FindBy(id="listPrice1")
	private WebElement price;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getInvoiceName() {
		return invoiceName;
	}

	public WebElement getSelectSalesOrder() {
		return selectSalesOrder;
	}

	public WebElement getSelectOrgName() {
		return selectOrgName;
	}

	public WebElement getBillingAdd() {
		return billingAdd;
	}

	public WebElement getCopyBillingAdd() {
		return copyBillingAdd;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getQty() {
		return qty;
	}

	public WebElement getPrice() {
		return price;
	}

	public void createInvoice(String inName,WebDriver driver,String sOrder,String org,String bill) throws InterruptedException{
		invoiceName.sendKeys(inName);
		selectOrgName.click();
		switchToWindow(driver,"Accounts&action");
		waitUntilTheElementIsClickable(driver, 5, searchBtn);
		searchField.sendKeys(org);
		searchBtn.click();
		driver.findElement(By.xpath("//a[contains(.,'"+org+"')]")).click();
		acceptAlertPopup(driver);
		switchToWindow(driver, "Invoice&action");
		selectSalesOrder.click();
		switchToWindow(driver, "SalesOrder&action");
		searchField.sendKeys(sOrder);
		searchBtn.click();
		try {
			driver.findElement(By.xpath("//a[contains(.,'"+sOrder+"')]")).click();
		}catch(Exception e)
		{
			acceptAlertPopup(driver);
		}
		switchToWindow(driver,"Invoice&action");
		Thread.sleep(5000);
		billingAdd.sendKeys(bill);
		copyBillingAdd.click();
		saveBtn.click();	

	}

	public void createInvoice(WebDriver driver,String inName,String prod,String org,String bill,String quantity,String amount) throws InterruptedException {
		invoiceName.sendKeys(inName);
		selectOrgName.click();
		switchToWindow(driver,"Accounts&action");
		waitUntilElementToBeVisible(driver, 5, searchField);
		searchField.sendKeys(org);
		searchBtn.click();
		driver.findElement(By.xpath("//a[contains(.,'"+org+"')]")).click();
		acceptAlertPopup(driver);
		switchToWindow(driver, "Invoice&action");
		billingAdd.sendKeys(bill);
		copyBillingAdd.click();
		searchIcon.click();
		switchToWindow(driver, "Products&action");
		waitUntilTheElementIsClickable(driver, 5, searchBtn);
		searchField.sendKeys(prod);
		searchBtn.click();
		driver.findElement(By.xpath("//a[contains(.,'"+prod+"')]")).click();
		switchToWindow(driver,"Invoice&action");
		qty.sendKeys(quantity);
		price.sendKeys(amount);
		Thread.sleep(3000);
		saveBtn.click();	

	}




}
