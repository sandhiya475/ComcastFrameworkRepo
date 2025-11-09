package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NotificationsPopup {

	public static void main(String[] args) {
		ChromeOptions ref=new ChromeOptions();
		ref.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(ref);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
        
		driver.findElement(By.xpath("//section[text()='Notifications']")).click();
		driver.findElement(By.id("browNotButton")).click();
	}

}
