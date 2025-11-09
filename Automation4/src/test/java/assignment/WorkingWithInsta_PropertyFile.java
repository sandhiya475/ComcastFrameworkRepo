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

public class WorkingWithInsta_PropertyFile {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.edge.driver","C:\\Users\\SANDHIYA\\eclipse-workspace\\Automation\\msedgedriver.exe");
		FileInputStream fis=new FileInputStream("./testData/commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		String Url = prop.getProperty("instaurl");
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
		driver.findElement(By.name("username")).sendKeys(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//div[text()='Log in']")).click();
		//Thread.sleep(10000);
		//driver.quit();
		
	}

}
