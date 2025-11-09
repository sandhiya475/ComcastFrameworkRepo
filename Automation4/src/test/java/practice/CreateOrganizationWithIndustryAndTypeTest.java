package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.PropertiesFileUtility;
import com.crm.generic.webdriverUtility.JavaUtility;
import com.crm.generic.webdriverUtility.WebDriverUtility;
import com.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.LoginPage;
import com.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.crm.objectRepositoryUtility.OrganizationsPage;

public class CreateOrganizationWithIndustryAndTypeTest {
public static void main(String[] args) throws Throwable {
		
		//Read the data from property file
		System.setProperty("webdriver.edge.driver","C:\\Users\\SANDHIYA\\eclipse-workspace\\Automation\\msedgedriver.exe");
		PropertiesFileUtility putil=new PropertiesFileUtility();
		String BROWSER=putil.getDataFromPropertiesFile("browser");
		String URL = putil.getDataFromPropertiesFile("url");
		String USERNAME =putil.getDataFromPropertiesFile("username");
		String PASSWORD = putil.getDataFromPropertiesFile("password");
		
		JavaUtility java=new JavaUtility();
		int rno = java.toGenerateRandomNumber();
		//Read testscript data from Excel file
		ExcelUtility eutil=new ExcelUtility();
		String Organization = eutil.getDataFromExcel("Organization",1,3)+rno;
		String type= eutil.getDataFromExcel("Organization",4,4);	
		String industry = eutil.getDataFromExcel("Organization",4,3);
		
		
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

		//BusinesMethod To Login
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);
		
		//Step 2 :Navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		//Step 3 : Click on create organixzation link
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getOrgLookupimgIconBtn().click();
		
		//Step 4 :Enter all details and create new organization 
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.getOrgNameTextfield().sendKeys(Organization);
        WebElement indus = cnop.getIndustryDropdownElement();
        Select select=new Select(indus);
        select.selectByValue(industry);
        WebElement typedd=cnop.getTypeDropdownElement();
        Select ref=new Select(typedd);
        ref.selectByValue(type);
		
        cnop.getSaveButton().click();
		System.out.println("Organization created with industry and type dropdown");
		
		//Verify industry and type info
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actIndus = oip.getIndustryDropdowninfo().getText();
		if(actIndus.equals(industry)) {
			System.out.println(industry+ " is verified==PASS");
		}else {
			System.out.println(industry+ " is not verified==FAIL");
		}
		
		String actType = oip.getTypeDropdowninfo().getText();
		if(actType.equals(type)) {
			System.out.println(type+ " is verified==PASS");
		}else {
			System.out.println(type+ " is not verified==FAIL");
		}
		
		//Step 5 :Logout 
		WebElement ele =hp.getAdministrationLink();
		wutil.toMousehover(driver, ele);
		hp.getSignoutLink().click();
		driver.quit();
		 
	}

	
}
