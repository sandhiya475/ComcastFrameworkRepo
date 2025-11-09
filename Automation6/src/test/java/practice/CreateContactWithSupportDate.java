package practice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertiesFileUtility;
import com.crm.generic.webdriverUtility.JavaUtility;
import com.crm.generic.webdriverUtility.WebDriverUtility;
import com.crm.objectRepositoryUtility.ContactInfoPage;
import com.crm.objectRepositoryUtility.ContactsPage;
import com.crm.objectRepositoryUtility.CreateNewContactPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.LoginPage;

public class CreateContactWithSupportDate {
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
		
		//Step 1 : Login to application
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
		
		JavaUtility jutil=new JavaUtility();
		String currentDate = jutil.currentDate();
		String dateAfter30days = jutil.requriredDate(30);

		cncp.getContactsupportstartdateTextfield().clear();
		cncp.getContactsupportstartdateTextfield().sendKeys(currentDate);
		cncp.getContactsupportenddateTextfield().clear();
		cncp.getContactsupportenddateTextfield().sendKeys(dateAfter30days);
		cncp.getSaveButton().click();	
		System.out.println("Contact created with support Date successfully");
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actContactsName =cip.getContactInfo().getText();
		if(actContactsName.contains(contactName)) {
			System.out.println(contactName+" is verified==PASS");
		}else {
			System.out.println(contactName+" is not verified==FAIL");
		}
		
		String actualcurrentDate = cip.getSupportStartDateInfo().getText();
		if(currentDate.equals(actualcurrentDate)) {
			System.out.println("actualcurrentDate "+currentDate+"is verified===Pass");
		}else {
			System.out.println("actualcurrentDate "+currentDate+"is not verified===Fail");
		}
        
		String actdateAfter30days=cip.getSupportEndDateInfo().getText();
		if(dateAfter30days.equals(actdateAfter30days)) {
			System.out.println("dateAfter30days "+dateAfter30days+" is verified===Pass");
		}else {
			System.out.println("dateAfter30days "+dateAfter30days+" is not verified===Fail");
		}
		
		//Step 5 :Logout 
		WebElement ele =hp.getAdministrationLink();
		wutil.toMousehover(driver, ele);
		hp.getSignoutLink().click();
		driver.quit();
		 
	}

}
