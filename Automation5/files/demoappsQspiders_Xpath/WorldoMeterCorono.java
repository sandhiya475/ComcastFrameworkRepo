package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorldoMeterCorono {
	public static void main(String[] args) throws InterruptedException {
	      WebDriver driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	      driver.get("https://www.worldometers.info/coronavirus/");
	      
	      Actions ref=new Actions(driver);
	      
	      WebElement graph = driver.findElement(By.xpath("//div[@id='graph-cases-daily']"));
	      ref.scrollToElement(graph).perform();
	      
	      
	}
}
