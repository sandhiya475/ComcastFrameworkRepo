package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FileUploadPopup {

	public static void main(String[] args) {
		
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get("https://demoapps.qspiders.com/ui/");
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			driver.findElement(By.xpath("//section[text()='Popups']")).click();
			driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
			
			driver.findElement(By.id("fullName")).sendKeys("Sandhiya S");
			driver.findElement(By.id("emailId")).sendKeys("sandhiya@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.id("mobile")).sendKeys("9876543210");
			WebElement dropDownEle = driver.findElement(By.id("city"));
			Select ref=new Select(dropDownEle);
			ref.selectByVisibleText("Bangalore");
			driver.findElement(By.id("resume")).sendKeys("C:\\Users\\SANDHIYA\\eclipse-workspace\\Automation\\files\\Resume.pdf");
			
			WebElement multidropdownEle = driver.findElement(By.xpath("//select[@aria-invalid='false']"));
			Select ref1=new Select(multidropdownEle);
			if(ref1.isMultiple()) 
			{
				ref1.selectByVisibleText("HTML");
				ref1.selectByIndex(1);
				ref1.selectByValue("Javascript");
			}
			driver.findElement(By.id("alert")).click();
			driver.findElement(By.xpath("//button[text()='Create Profile']")).click();
	}

}
