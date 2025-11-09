package crmApplicationAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class OrganizationModuleTest {

	public static void main(String[] args) throws IOException {
		
		//Read the data from property file
		System.setProperty("webdriver.edge.driver","C:\\Users\\SANDHIYA\\eclipse-workspace\\Automation\\msedgedriver.exe");
		FileInputStream fis=new FileInputStream("./comData/commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		//Generate Random Numbers
		Random r=new Random();
		int rno = r.nextInt(1000);
		
		//Read testscript data from Excel file
		FileInputStream fis1=new FileInputStream("./testData\\Book1.xlsx");
		//Open the workbook
		Workbook wb=WorkbookFactory.create(fis1);
		//Get the control of the "org" sheet
		Sheet sh = wb.getSheet("Organization");
		//Get the control of the "first" row 
		Row row = sh.getRow(1);
		//Get the control of the "second" cell $ read the string data
		String data = row.getCell(2).toString();
		System.out.println(data);
		//Close the workbook
		wb.close();
		
		
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
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
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 2 :Navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 3 : Click on create organixzation link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 4 :Enter all details and create new organization 
		driver.findElement(By.name("accountname")).sendKeys(data+rno);
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		//Step 5 :Logout
		Actions action=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
