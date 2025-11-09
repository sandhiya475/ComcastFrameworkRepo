package demoappsQspiders_Xpath;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindows {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']")).click();
		driver.findElement(By.xpath("//h2[text()='Watches']/../..//button[text()='view more']")).click();
		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		allIds.remove(parentId);
		for (String id:allIds) {
			driver.switchTo().window(id);
		}
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		driver.findElement(By.xpath("//*[local-name()='svg']")).click();
		driver.switchTo().window(parentId);
		driver.quit();
		
	}

}
