package com.crm.basetest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.crm.generic.databaseutility.DataBaseUtility;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertiesFileUtility;
import com.crm.generic.webdriverUtility.JavaUtility;
import com.crm.generic.webdriverUtility.WebDriverUtility;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.LoginPage;

public class BaseClass {
	public DataBaseUtility dutil=new DataBaseUtility();
	public PropertiesFileUtility putil=new PropertiesFileUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public JavaUtility jutil=new JavaUtility();
	public WebDriver driver=null;
	
	@BeforeSuite
	public void configBS() throws Throwable {
		System.out.println("---Connect to DB,Report config---");
		dutil.getDBconnection();
	}
	@BeforeTest(alwaysRun = true)
	public void configBT() throws Throwable {
		System.out.println("---Before Test executed---");
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	            //String browser
	public void configBC() throws Throwable {
		System.out.println("---Launch the Browser---");
		String BROWSER =putil.getDataFromPropertiesFile("browser");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		System.out.println("---Login to the Application---");
		String URL = putil.getDataFromPropertiesFile("url");
		String USERNAME = putil.getDataFromPropertiesFile("username");
		String PASSWORD = putil.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);
		wutil.toimplicitWait(driver);
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM() {
		System.out.println("---Logout the Application---");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("---Close the Brower---");
		driver.quit();
	}
	
	@AfterTest(alwaysRun = true)
	public void configAT() throws Throwable {
		System.out.println("---Before Test executed---");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable {
		System.out.println("---Close DB,Report Backup---");
		dutil.closeDBconnection();
	}

}
