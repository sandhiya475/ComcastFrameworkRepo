package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CloseShadowRoot {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");

		driver.findElement(By.xpath("//a[text()='Close Shadow Root']")).click();
		try {
		driver.findElement(By.xpath("//h1[text()='Login']")).click();
		
		}
		catch(Exception e) {
			driver.findElement(By.xpath("//h1[text()='Login']")).click();
		}
		Actions ref=new Actions(driver);
		ref.sendKeys(Keys.TAB).perform();
		ref.sendKeys("Sandhiya").perform();
		ref.sendKeys(Keys.TAB).perform();
		ref.sendKeys("12345").perform();
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
}
}