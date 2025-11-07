package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import elementRepository.ContactInfoPage;
import elementRepository.ContactsPage;
import elementRepository.CreateContactPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class Scenario5WithDDTandPOM {
	public static void main(String[] args) throws InterruptedException, IOException {
		
	PropertyFileUtility putil=new PropertyFileUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	
	//To read data from property file
	String BROWSER = putil.toReadDataFromPropertyFile("browser");
	String URL = putil.toReadDataFromPropertyFile("url");
	String USERNAME = putil.toReadDataFromPropertyFile("username");
	String PASSWORD = putil.toReadDataFromPropertyFile("password");
	
	//To read data from Excel File
	String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
	
	//Step 1:- Launch Browser
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
	wutil.toMaximize(driver);
	wutil.toImplicitlyWait(driver);
	
	//Step 2:- Login to application with valid credentials
    driver.get(URL);
    LoginPage lp=new LoginPage(driver);
    lp.getUsernameTextfield().sendKeys(USERNAME);
    lp.getPasswordTextfield().sendKeys(PASSWORD);
    lp.getLoginButton().click();
    
    //Step 3:- Navigate to contacts link
    HomePage hp=new HomePage(driver);
    hp.getContactsLink().click();
    
    //Step 4:- Click on create look up image
    ContactsPage cp=new ContactsPage(driver);
    cp.getContactLookupImageIcon().click();
    
    //Step 5:- Create contact with mandatory fields
    CreateContactPage ccp=new CreateContactPage(driver);
    ccp.getLastnameTextfield().sendKeys(LASTNAME);
    
    //Step 6:- Select the Organization from Organization look up image
    cp.getOrganizationLookUpImage().click();
	WebDriverUtility wutil1=new WebDriverUtility();
	wutil1.toSwitchWindow(driver, "accounts");
	ccp.getOrganizationName().click();
	wutil1.toSwitchWindow(driver, "Contacts");
	
    //Step 6 :- Save and Verify
    ccp.getSavebutton().click();
    
    ContactInfoPage cip=new ContactInfoPage(driver);
    String lastname = cip.getContactInfonfo().getText();
    if(lastname.contains(LASTNAME)) {
    	System.out.println(lastname+"-----Passed");
    }else {
    	System.out.println(lastname+"----Failed");
    }
    
    //Step 7:- Logout of application
    wutil.toMouseHover(driver, hp.getLogoutEle());
    hp.getSignoutLink().click();
    
    //Step 8:- Close Browser
    driver.quit();

}

}
