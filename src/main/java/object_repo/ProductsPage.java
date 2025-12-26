package object_repo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_utilities.WebDriverUtils;

public class ProductsPage extends WebDriverUtils {
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductIcon;
	
	@FindBy(name="search_text")
	private WebElement seachField;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[contains(.,'edit')]")
	private WebElement edit;
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateProductIcon() {
		return createProductIcon;
	}

	public WebElement getSeachField() {
		return seachField;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getEdit() {
		return edit;
	}
	
	public void clickOnCreateProductIcon() {
		createProductIcon.click();
	}
	
	public void searchProduct(String prod,String ddValue,WebDriver driver) throws InterruptedException {
		seachField.sendKeys(prod);
		dropdownUsingContainsVisibleText(searchDD,ddValue);
		try {
		searchBtn.click();
		}catch(Exception e) {
			acceptAlertPopup(driver);
		}
		Thread.sleep(5000);
		waitUntilTheElementIsClickable(driver, 5, edit);
		mouseHoverAndClickOnEle(driver, edit);
		
	}

	
	
	

}
