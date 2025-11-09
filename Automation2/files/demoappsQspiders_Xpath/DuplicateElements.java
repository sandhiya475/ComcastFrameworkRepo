package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateElements {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		driver.findElement(By.xpath("//section[text()='X Path']")).click();
		driver.findElement(By.xpath("//section[text()='Duplicate Elements ']")).click();
		driver.findElement(By.xpath("//label[text()='Iphone']/..//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//label[text()='Samsung']/..//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//label[text()=' RedMi ']/..//input[@type='checkbox']")).click();
	}

}
