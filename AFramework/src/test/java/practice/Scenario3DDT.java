package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario3DDT {
	public static void main(String[] args) throws IOException {
		//Read the Data from properties File
		FileInputStream pfis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop=new Properties();
		prop.load(pfis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USENAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		//Read the Data From Excel File
		FileInputStream efis=new FileInputStream(".\\src\\test\\resources\\TestDataAF.xlsx");
		Workbook wb=WorkbookFactory.create(efis);
		String ORGANIZATIONNAME = wb.getSheet("Organization").getRow(1).getCell(2).toString();
		
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
		
		//Step 2:- Login to application with valid credentials
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USENAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		 //Step 3:- Navigate to Organization link
        driver.findElement(By.linkText("Organizations")).click();
        
        //Step 4:- Click on create Organization look up image
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        
        //Generate Random Number
        Random r=new Random();
        int randomvalue = r.nextInt(1000);
        
        //Step 5:- Create Organization with mandatory fields
        driver.findElement(By.name("accountname")).sendKeys(ORGANIZATIONNAME+randomvalue);
        
        //Step 6:- Select "Chemicals" in the industry dropdown
        WebElement dropDown = driver.findElement(By.name("industry"));
        Select chemical=new Select(dropDown);
        chemical.selectByValue("Chemicals");
        
        //Step 7:- Save and Verify
        driver.findElement(By.name("button")).click();
        String organizationname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(organizationname.contains(ORGANIZATIONNAME+randomvalue)) {
        	System.out.println(organizationname +"------Passed");
        }else {
        	System.out.println(organizationname +"------Failed");
        }
        
        //Step 8:- Logout of Application
        WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions action=new Actions(driver);
        action.moveToElement(logoutEle).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        
        // Step 9:- Close Browser
        driver.quit();
        
        }




		
}
