package object_repo;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage {
	
	@FindBy(name="productname")
	private WebElement prodName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="my_file_element")
	private WebElement fileUpload;
	
	public CreateProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getFileUpload() {
		return fileUpload;
	}
	
	public void createProduct(String prod) {
		prodName.sendKeys(prod);
		saveBtn.click();
	}
	
	public void editProduct() {
		fileUpload.sendKeys("C:\\Users\\hp\\Downloads\\WhatsApp Image 2025-11-25 at 12.37.19 PM.jpeg");
		saveBtn.click();
	}

}
