package demoappsQspiders_Xpath;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleMWDemowebshop {

	public static void main(String[] args) throws InterruptedException {
  
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		String pId = driver.getWindowHandle();
		driver.findElement(By.linkText("Facebook")).click();
		Set<String> allIds = driver.getWindowHandles();
		for(String id :allIds) {
			driver.switchTo().window(id);
			if(driver.getTitle().contains("Facebook")) {
				driver.findElement(By.name("email")).sendKeys("sandy@gmail.com");
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(pId);
		driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		driver.quit();
	}

}
