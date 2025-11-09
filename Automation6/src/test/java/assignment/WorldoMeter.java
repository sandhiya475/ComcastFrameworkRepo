package assignment;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorldoMeter {
	public static void main(String[] args) {
		
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
         driver.get("https://www.worldometers.info/coronavirus/");
		  
         
         Actions a = new Actions(driver);
         WebElement div = driver.findElement(By.xpath("//div[@id='coronavirus-cases-daily']"));

		  

		  a.scrollToElement(div).perform();
		  a.moveToElement(div).perform();
		  List<WebElement> ele = driver.findElements(By.xpath("//div[@id= 'coronavirus-cases-daily']/descendant :: *[name()='svg']/ descendant ::* [name()='rect' and @class='highcharts-point']"));
		  Set<String> tooldata = new LinkedHashSet<String>();
		  for (WebElement each : ele) {
		  WebElement data = driver.findElement(By.xpath("(//*[name()='svg']/descendant :: *[name()='path' and @class-'highcharts-label-box highcharts-tooltip-box']/following-sibling :: *[name()-'text'])[1]"));
		  a.moveToElement(each).perform();


		  String newdata = data.getText();
		  
		  if(!newdata.isEmpty()) 
		  tooldata.add(newdata);
		  
		  for (String lastdata : tooldata) {
		  System.out.println(lastdata);
		  }
		  }
		  driver.quit();
		  }
	
}
