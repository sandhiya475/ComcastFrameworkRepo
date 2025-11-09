package assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicWebTable {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//WebElement table = driver.findElement(By.xpath("//h2[text()='Dynamic Web Table']"));
		Actions action=new Actions(driver);
		action.scrollByAmount(0, 2100).perform();
		
	    WebElement firefoxEle = driver.findElement(By.xpath("//td[text()='Firefox']/.."));
	    System.out.println(firefoxEle.getText()); 
		
	}

}
