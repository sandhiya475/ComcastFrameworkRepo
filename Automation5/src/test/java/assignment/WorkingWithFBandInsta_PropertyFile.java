package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WorkingWithFBandInsta_PropertyFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.edge.driver","C:\\Users\\SANDHIYA\\eclipse-workspace\\Automation\\msedgedriver.exe");
		FileInputStream fis=new FileInputStream("./testData/commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		String Url = prop.getProperty("fburl");
		String Email = prop.getProperty("email");
		String Password = prop.getProperty("password");
		WebDriver driver=null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(Url);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.findElement(By.name("login")).click();
		//driver.close();
		
		
		String Url1 = prop.getProperty("instaurl");
		driver.get(Url1);
		driver.findElement(By.name("username")).sendKeys(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//div[text()='Log in']")).click();
		//driver.close();
		
	}

}
