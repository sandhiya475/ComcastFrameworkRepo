package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;

public class Scenario2WithDDTandGU {

	public static void main(String[] args) throws IOException {
		//To read data from Property File
		PropertyFileUtility pfis=new PropertyFileUtility();
		String BROWSER = pfis.toReadDataFromPropertyFile("browser");
		String URL = pfis.toReadDataFromPropertyFile("url");
		String USERNAME = pfis.toReadDataFromPropertyFile("username");
		String PASSWORD = pfis.toReadDataFromPropertyFile("password");
		
		//To read data from Excel File
		ExcelFileUtility efis=new ExcelFileUtility();
	    String ORGANIZATIONNAME = efis.toReadDataFromExcelFile("Organization", 1, 2);
	    
	    //Step 1:- Launch Browser
	    WebDriver driver=null;
	    if(BROWSER.equals("chrome")) {
	    	driver=new ChromeDriver();
	    }else if(BROWSER.equals("edge")) {
	    	driver=new EdgeDriver();
	    }else if(BROWSER.equals("firefox")) {
	    	driver=new FirefoxDriver();
	    }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	    //Login to application with valid credentials
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
	    Actions action=new Actions(driver);
	    action.moveToElement(logoutEle).perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	    
	    //Step 8:- Close the browser
	    driver.quit();
	   
	}

}
