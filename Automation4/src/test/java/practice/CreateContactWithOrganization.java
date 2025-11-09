package practice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertiesFileUtility;
import com.crm.generic.webdriverUtility.WebDriverUtility;
import com.crm.objectRepositoryUtility.ContactInfoPage;
import com.crm.objectRepositoryUtility.ContactsPage;
import com.crm.objectRepositoryUtility.CreateContactWithOrgPage;
import com.crm.objectRepositoryUtility.CreateNewContactPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.LoginPage;

public class CreateContactWithOrganization {
public static void main(String[] args) throws Throwable {
		
		//Read the data from property file
		PropertiesFileUtility putil=new PropertiesFileUtility();
		String BROWSER=putil.getDataFromPropertiesFile("browser");
		String URL = putil.getDataFromPropertiesFile("url");
		String USERNAME =putil.getDataFromPropertiesFile("username");
		String PASSWORD = putil.getDataFromPropertiesFile("password");
		
		//Read testscript data from Excel file
	    ExcelUtility eutil=new ExcelUtility();
		String contactName = eutil.getDataFromExcel("Contacts",1,3);
		String childWindow = eutil.getDataFromExcel("Contacts",7,3);
		String parrentWindow = eutil.getDataFromExcel("Contacts",7,4);
		String orgName1 = eutil.getDataFromExcel("Contacts",7,2);
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();	
			}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		WebDriverUtility wutil=new WebDriverUtility();
	    wutil.toimplicitWait(driver);
	    driver.get(URL);
	    LoginPage lp=new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
  		ContactsPage cp=new ContactsPage(driver);
	    cp.getCreateContactLookupimgIcon().click();
	    CreateNewContactPage cncp=new CreateNewContactPage(driver);
	    cncp.getLastnameTextfield().sendKeys(contactName);
	    cncp.getCreateContactWithOrgIcon().click();
	    wutil.toHandleWindowByTitle(driver, childWindow);
	    CreateContactWithOrgPage ccwop=new CreateContactWithOrgPage(driver);
	    ccwop.getSearchTextfield().click();
	    ccwop.getSearchTextfield().sendKeys(orgName1);
	    ccwop.getSearchButton().click();
	    ccwop.getOrgNameClickBtn().click();
	    wutil.toHandleWindowByTitle(driver, parrentWindow);
	    cncp.getSaveButton().click();
	    System.out.println("Contact name with organization created successfully");
	
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actContactsName1 = cip.getContactInfo().getText();
		if(actContactsName1.contains(contactName)) {
			System.out.println("Contact name "+contactName+" is verified==PASS");
		}else {
			System.out.println("Contact name "+contactName+" is not verified==FAIL");
		}
		
		//Step 5 :Logout 
		WebElement ele =hp.getAdministrationLink();
		wutil.toMousehover(driver, ele);
		hp.getSignoutLink().click();
		driver.quit();
		}
}
