package demoappsQspiders_Xpath;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQa {

	public static void main(String[] args) throws InterruptedException {
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
      
      driver.get("https://demoqa.com/browser-windows");
      JavascriptExecutor js=(JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,500)");
      driver.findElement(By.id("messageWindowButton")).click();


      String pID = driver.getWindowHandle();
      Set<String> allIds = driver.getWindowHandles();
      allIds.remove(pID);
      for (String id:allIds) {
      driver.switchTo().window(id);


     System.out.println(driver.findElement(By.tagName("body")).getText());
     driver.close();
      
      }
   
     
	}

}
