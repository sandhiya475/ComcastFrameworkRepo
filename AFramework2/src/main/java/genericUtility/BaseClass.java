package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Parameters;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class BaseClass {

	PropertyFileUtility putil=new PropertyFileUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver;  //listeners
	
	
	
	@BeforeSuite(groups= {"Smoke","Regression"})
	public void befoeSuiteConfig() {
		System.out.println("---DataBase Connection Established---");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups= {"Smoke","Regression"})
	public void beforeClassConfig(/*String BROWSER*/) throws IOException {//String BROWSER
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		sDriver=driver; //listeners
		System.out.println("Browser got launched");
		wutil.toMaximize(driver);
		System.out.println("Browser got maximized");
		wutil.toImplicitlyWait(driver);
		driver.get(URL);
	}
		
	@BeforeMethod(groups= {"Smoke","Regression"})
	public void beforeMethodConfig() throws IOException {
	String USERNAME = putil.toReadDataFromPropertyFile("username");
	String PASSWORD = putil.toReadDataFromPropertyFile("password");
	LoginPage lp=new LoginPage(driver);
	lp.getUsernameTextfield().sendKeys(USERNAME);
	lp.getPasswordTextfield().sendKeys(PASSWORD);
	lp.getLoginButton().click();
	System.out.println("Logged in to vtiger successfully");
	}
	
	@AfterMethod(groups= {"Smoke","Regression"})
	public void afterMethodConfig() {
		HomePage hp=new HomePage(driver);
		WebElement logoutEle = hp.getLogoutEle();
		wutil.toMouseHover(driver, logoutEle);
		hp.getSignoutLink().click();
		System.out.println("Logged out from vtiger successfully");
	}
		
    @AfterClass(groups= {"Smoke","Regression"})
    public void afterClassConfig() {
    	driver.quit();
    }
	
    @AfterSuite(groups= {"Smoke","Regression"})
    public void afterSuiteConfig() {
    	System.out.println("---DataBase Connection Disconnected---");
    }
	}
	
	
	
	
	
			
	

