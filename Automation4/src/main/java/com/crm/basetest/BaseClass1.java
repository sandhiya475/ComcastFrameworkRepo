package com.crm.basetest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.generic.databaseutility.DataBaseUtility;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertiesFileUtility;
import com.crm.generic.webdriverUtility.JavaUtility;
import com.crm.generic.webdriverUtility.UtilityClassObject;
import com.crm.generic.webdriverUtility.WebDriverUtility;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.LoginPage;

public class BaseClass1 {
	public DataBaseUtility dutil=new DataBaseUtility();
	public PropertiesFileUtility putil=new PropertiesFileUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public JavaUtility jutil=new JavaUtility();
	public WebDriver driver=null;
	//public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		Reporter.log("---Connect to DB,Report config---",true);
		dutil.getDBconnection();
	}
	
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
		UtilityClassObject.SetDriver(driver);
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
		Reporter.log("---Logout the Application---",true);
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		Reporter.log("---Close the Brower---",true);
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable {
		Reporter.log("---Close DB,Report Backup---",true);
		dutil.closeDBconnection();
	}
}
