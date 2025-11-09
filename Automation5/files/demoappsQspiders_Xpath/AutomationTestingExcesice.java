package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomationTestingExcesice {

	public static void main(String[] args) throws InterruptedException {
  WebDriver driver=new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  driver.get("https://testautomationpractice.blogspot.com/");
  
  WebElement ele = driver.findElement(By.xpath("//h2[text()='Pagination Web Table']"));
  JavascriptExecutor js=(JavascriptExecutor) driver;
  js.executeScript("arguments[0].scrollIntoView(true)",ele);
  String expectedData="Portable Charger";
 WebElement table=driver.findElement(By.xpath("//table[@id='productTable']"));
 //if(table==expectedData) {
	 
 //})
  driver.findElement(By.linkText("1")).click();
  driver.findElement(By.linkText("2")).click();
  driver.findElement(By.linkText("3")).click();
  driver.findElement(By.xpath("//table[@id='productTable']/descendant::td[text()='13']/..//input[@type='checkbox']")).click();
	
  
  
  }

}
