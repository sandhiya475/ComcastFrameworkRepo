package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
    WebElement ele = driver.findElement(By.xpath("(//*[name()='svg'])[1]"));
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	driver.findElement(By.xpath("//div[text()='29']")).click();
	
	driver.findElement(By.xpath("//a[text()='Dropdown DatePicker']")).click();
   try {
	driver.findElement(By.xpath("(//*[name()='svg'])[1]")).click();
	
   }
   catch(StaleElementReferenceException e) {
	   driver.findElement(By.xpath("(//*[name()='svg'])[1]")).click();
   }
	for(;;) {
		try {
		 driver.findElement(By.xpath("//div[text()='September 1996']/../..//div[text()='25']")).click();
		break;
		}
		catch(Exception e) {
			driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		}
	}
	
	}

}
