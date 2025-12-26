package generic_utilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import object_repo.HomePage;
import object_repo.LoginPage;

public class BaseClass {
	
	public DataBaseUtils dbLib=new DataBaseUtils();
	public JavaUtils jLib=new JavaUtils();
	public FileUtility fLib=new FileUtility();
	public ExcelUtils eLib=new ExcelUtils();
	public WebDriverUtils wLib=new WebDriverUtils();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException {
		dbLib.connectToDB();
		System.out.println("--connect to DB--");
	}
	
	@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome")String BROWSER) throws IOException {
	//	String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);

			driver = new FirefoxDriver(options);
			
		}
		else if(BROWSER.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		sdriver = driver;
		
		//maximize window
		wLib.maximizeWindow(driver);
		
		//page load
		wLib.waitForPageLoad(driver, 10);
		
		driver.get(URL);
		
		System.out.println("--Browser lauched sucessfully--");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("--logged into application--");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
		System.out.println("--Logged out from application--");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBroser() {
		driver.quit();
		System.out.println("--Browser closed--");
	}

	@AfterSuite(alwaysRun = true)
	public void diconnectDB() throws SQLException {
		dbLib.disconnectDB();
		System.out.println("--Disconnect to DB--");
	}
}
