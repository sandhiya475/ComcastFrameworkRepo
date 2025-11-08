package practice;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import elementRepository.CreateOrganizationPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.OrganizationInfoPage;
import elementRepository.OrganizationPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class Scenario4WithDDTandPOM {


public static void main(String[] args) throws IOException {
		
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//To read Data from property File
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		//To read Data from excel File
		String ORGANIZATIONNAME = eutil.toReadDataFromExcelFile("Organization", 1, 2);
		
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
	    
	    //Step 3:-  Navigation to Oraganization Link
	    HomePage hp=new HomePage(driver);
	    hp.getOrganizationslink().click();
	    
	    //Step 4:- Click on create Oraganization look up Image
	    OrganizationPage op=new OrganizationPage(driver);
	    op.getOrganizationLookUpImage().click();
	    
	    //Generate random values
	    Random r= new Random();
	    int randomvalue = r.nextInt(1000);
	    
	    //Step 5:- Create Organization With Mandatory Fields
	    CreateOrganizationPage cop=new CreateOrganizationPage(driver);
	    cop.getOrganizationNameTextfield().sendKeys(ORGANIZATIONNAME+randomvalue);
	    
	    //Step 6:- Select "Energy" in the Industry dropdown
	    WebElement inddropdown = cop.getIndustryDropdown();
	    wutil.toHandleDropdown(inddropdown, "Energy");
	    
	    //Step 7:- Select "Customer" in the Type dropdown
	    WebElement typedropdown = cop.getTypeDropdown();
	    wutil.toHandleDropdown(typedropdown, "Customer");
	    
	    //Step 8:-Save And Verify
	    cop.getSavebutton().click();
	    
	    OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	    String organizationname = oip.getOrganizationInfo().getText();
	    if(organizationname.contains(ORGANIZATIONNAME+randomvalue)) {
	    	System.out.println(organizationname+"----Passed");
	    }else {
	    	System.out.println(organizationname+"----Failed");
	    }
	    
	    //Step 9:- Logout of Application
	    WebElement logoutEle = hp.getLogoutEle();
	    wutil.toMouseHover(driver, logoutEle);
	    hp.getSignoutLink().click();
	    
	    //Step 10:- Close the browser
	    driver.quit();


}
}
