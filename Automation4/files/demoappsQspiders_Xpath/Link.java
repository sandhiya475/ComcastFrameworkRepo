package demoappsQspiders_Xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Link {

	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		WebElement ele = driver.findElement(By.xpath("//section[text()='Web Elements']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	    driver.findElement(By.xpath("//a[@href='/ui/link']")).click();
	    driver.findElement(By.id("men")).click();
	    List<WebElement> linksAll = driver.findElements(By.tagName("a"));

	   
	  
	  for(WebElement links : linksAll) {
		    System.out.println(links.getAttribute("href"));
		    System.out.println(links.getText());
		      
		    }
	  System.out.println(linksAll.size());
	   		}

}
