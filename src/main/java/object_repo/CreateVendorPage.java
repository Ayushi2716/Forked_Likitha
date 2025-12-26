package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
	
	@FindBy(name="vendorname")
	private WebElement vName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getvName() {
		return vName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createVendor(String name) {
		vName.sendKeys(name);
		saveBtn.click();
	}
	
}
