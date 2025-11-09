package assignment;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationTestExcersize {
	public static void main(String[] args) throws InterruptedException {
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://testautomationpractice.blogspot.com/");
		  
		  WebElement ele = driver.findElement(By.xpath("//h2[text()='Pagination Web Table']"));
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView(true)",ele);
		
		 String expectedData="Portable Charger";
	     List<WebElement> num = driver.findElements(By.xpath("//ul[@class='pagination']/descendant::a[@href='#']"));
	     for(WebElement button:num) {
	    	     String tableValue1 = driver.findElement(By.xpath("//div[@class='columns fauxcolumns']/descendant::div[@class='table-container']")).getText();
	    		 if(tableValue1.contains(expectedData)) {	
	               System.out.println("Portable Charger is available");
				  break;
	    		 }
				  
				  else {
					  button.click();	 
	             }
	     }
	    		 driver.findElement(By.xpath("(//div[@class='table-container']/descendant::td[text()='13']/following::input[@type='checkbox'])[1]")).click();
	    		 //driver.quit();
	}
}



