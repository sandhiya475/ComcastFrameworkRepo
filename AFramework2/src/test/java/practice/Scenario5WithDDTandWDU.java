package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import elementRepository.CreateContactPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class Scenario5WithDDTandWDU {
public static void main(String[] args) throws IOException, InterruptedException {
	PropertyFileUtility putil=new PropertyFileUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	
	//To read the Data from Property File
	String BROWSER = putil.toReadDataFromPropertyFile("browser");
	String URL = putil.toReadDataFromPropertyFile("url");
	String USERNAME = putil.toReadDataFromPropertyFile("username");
	String PASSWORD = putil.toReadDataFromPropertyFile("password");
	
	//To read the Data from property file
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
	wutil.toMaximize(driver);//WebDriverUtility
	wutil.toImplicitlyWait(driver);//WebDriverUtility
	
	//Step 2:- Login to application with valid credentials
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//Step 3:- Navigate to contacts link
	driver.findElement(By.linkText("Contacts")).click();
	
	//Step 4:- Click on create contact look up image
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	//Step 5:- Create contact with mandatory fields
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
	//Step 6:- Select the Organizationfrom Oraganization look up image
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	
	
	WebDriverUtility wutil1=new WebDriverUtility();
	wutil1.toSwitchWindow(driver, "accounts");
	//driver.findElement(By.linkText("TCS")).click();
	CreateContactPage ccp=new CreateContactPage(driver);
	ccp.getOrganizationName().click();
	wutil1.toSwitchWindow(driver, "Contacts");
	
	//Step 7:- Save and Verify
	driver.findElement(By.name("button")).click();
	
	String lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(lastname.contains(LASTNAME)) {
		System.out.println(LASTNAME+"----Passed");
	}else {
		System.out.println(LASTNAME+"----Failed");
	}
	
	//Step 8:- Logout of an application
	WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wutil1.toMouseHover(driver, logoutEle);//WebDriverUtility
	driver.findElement(By.linkText("Sign Out")).click();
	
	//Step 9:- Close Browser
	driver.quit();
	}
}
