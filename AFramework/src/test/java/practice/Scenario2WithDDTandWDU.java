package practice;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;

public class Scenario2WithDDTandWDU {
	public static void main(String[] args) throws IOException {
	PropertyFileUtility putil=new PropertyFileUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	
	//To read Data from Property File
	String BROWSER = putil.toReadDataFromPropertyFile("browser");
	String URL = putil.toReadDataFromPropertyFile("url");
	String USERNAME = putil.toReadDataFromPropertyFile("username");
	String PASSWORD = putil.toReadDataFromPropertyFile("password");
	
	//To read Data from Excel File
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
	wutil.toMaximize(driver);//WebDriverUtility
	wutil.toImplicitlyWait(driver);//WebDriverUtility
					
		//Step 2:- Login to application with valid credentials
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//Step 3:- Navigation to Oraganization Link
    driver.findElement(By.linkText("Organizations")).click();
    
    //Step 4:- Click on create Oraganization look up Image
    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
    
    //Generate random values
    Random r= new Random();
    int randomvalue = r.nextInt(1000);
    
    //Step 5:- Create Organization With Mandatory Fields
    driver.findElement(By.name("accountname")).sendKeys(ORGANIZATIONNAME+randomvalue);
    
    //Step 6:-Save And Verify
    driver.findElement(By.name("button")).click();
    
    String organizationname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    if(organizationname.contains(ORGANIZATIONNAME+randomvalue)) {
    	System.out.println(organizationname+"----Passed");
    }else {
    	System.out.println(organizationname+"----Failed");
    }
    
    //Step 7:- Logout of Application
    WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    wutil.toMouseHover(driver, logoutEle);//WebDriverUtility
    driver.findElement(By.linkText("Sign Out")).click();
    
    //Step 8:- Close the browser
    driver.quit();

	
}
}
