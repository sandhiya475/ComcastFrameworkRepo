package demoappsQspiders_Xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
	public static void main(String[] args)  {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/radio?sublist=0");
	    driver.findElement(By.xpath("//a[text()='Default']")).click();
	    
		driver.findElement(By.xpath("//span[text()='UPI']/..//input[@type='radio']")).click();
		driver.findElement(By.xpath("//span[text()='Office delivery']/..//input[@type='radio']")).click();
		
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println(radioButtons.size());
		driver.findElement(By.xpath("//a[text()='Disabled']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//span[text()='UPI']/..//input[@type='radio']"));
	    WebElement ele2 = driver.findElement(By.xpath("//span[text()='Office delivery']/..//input[@type='radio']"));
	    WebElement ele3 = driver.findElement(By.id("btn"));
	    JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele1);
		js.executeScript("arguments[0].click()", ele2);
		js.executeScript("arguments[0].click()", ele3);
}
}