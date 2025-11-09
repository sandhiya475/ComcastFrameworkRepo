package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		driver.findElement(By.id("deleteButton")).click();
		
		Alert popup = driver.switchTo().alert();
		popup.accept();
		driver.quit();

	}

}
