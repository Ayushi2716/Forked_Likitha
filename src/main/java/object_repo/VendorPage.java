package object_repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriverUtils;

public class VendorPage extends WebDriverUtils {
	
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVendorIcon;
	
	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//a[@title='Vendors']")
	private List<WebElement> vendors;
	
	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateVendorIcon() {
		return createVendorIcon;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public List<WebElement> getVendors() {
		return vendors;
	}
	
	public void clickOnCreateVendorIcon() {
		createVendorIcon.click();	
	}
	
	public void deleteVendor(WebDriver driver,String vName) {
		List<WebElement> vendorNames = vendors;
		for(WebElement names:vendorNames) {
			String name = names.getText();
		System.out.println(name);
			if(name.equals(vName)) {
				driver.findElement(By.xpath("//a[text()='" + vName + "']/ancestor::tr/td/input[@type='checkbox']")).click();
				deleteBtn.click();
				acceptAlertPopup(driver);
				System.out.println("Vendor is deleted");
			}
			else {
				System.out.println("Vendor not matched");
			}
		}
		
	}

}
