package object_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement createInvoiceIcon;
	
	public InvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateInvoiceIcon() {
		return createInvoiceIcon;
	}
	public void clickOnCreateInvoiceIcon() {
		createInvoiceIcon.click();
	}

}
