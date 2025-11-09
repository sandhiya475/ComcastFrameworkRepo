package crmApplicationAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class DDTFromJSONFileTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException  {
		JSONParser par=new JSONParser();
		Object obj = par.parse(new FileReader("./comData/commonData.json"));
		JSONObject map=(JSONObject) obj;
		String BROWSER = map.get("browser").toString();
		String URL = map.get("url").toString();
		String USERNAME = map.get("username").toString();
		String PASSWORD = map.get("password").toString();
		
		Random r=new Random();
		int rno = r.nextInt(1000);
		
		//Read testscript data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\SANDHIYA\\eclipse-workspace\\Automation\\testData\\Book1.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis1);
		
		String data = wb.getSheet("Organization").getRow(1).getCell(2).toString();
		System.out.println(data);
		wb.close();
		
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
		driver.findElement(By.name("accountname")).sendKeys("Tek Pyramid"+rno);
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		//Step 5 :Logout
		Actions action=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
		
	}

}
