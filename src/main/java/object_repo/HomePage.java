package object_repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtils;

public class HomePage extends WebDriverUtils {
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement organization;
	
	@FindBy(linkText="Contacts")
	private WebElement contacts;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunity;
	
	@FindBy(linkText = "Products")
	private WebElement product;
	
	@FindBy(linkText ="More")
	private WebElement more;
	
	@FindBy(name="Vendors")
	private WebElement vendor;
	
	@FindBy(name="Invoice")
	private WebElement invoice;
	
	//logout elements
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(xpath="//a[contains(.,'Sign Out')]")
	private WebElement signoutBtn;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    //Utilization
	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getOpportunity() {
		return opportunity;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getVendor() {
		return vendor;
	}

	public WebElement getInvoice() {
		return invoice;
	}

	public WebElement getSignoutIcon() {
		return administrator;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}
	
	//business logic
	public void clickOnOrg() {
		organization.click();
	}	
	public void clickOnContacts() {
		contacts.click();
	}
	public void clickOnOpportunities() {
		opportunity.click();
	}
	public void clickOnProducts() {
		product.click();
	}
	public String clickOnProducts(WebDriver driver,String prod) {
		product.click();
		String qty = driver.findElement(By.xpath("//a[normalize-space()='"+prod+"']/ancestor::tr/td[6]")).getText();
		return qty;
	}
	public void clickOnVrndors(WebDriver driver) {
		clickOnElementUsingJSE(driver, more);
		clickOnElementUsingJSE(driver, vendor);
	}
	public void clickOnInvoice(WebDriver driver) {
		clickOnElementUsingJSE(driver, more);
		clickOnElementUsingJSE(driver, invoice);
	}
		
	public void signOut(WebDriver driver) {
		mouseHover(driver, administrator);
		clickOnElementUsingJSE(driver, signoutBtn);
	}

}
