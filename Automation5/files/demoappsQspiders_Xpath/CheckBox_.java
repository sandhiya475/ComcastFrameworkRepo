package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CheckBox_ {
public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	    driver.findElement(By.xpath("//section[text()='Check Box']")).click();
	    driver.findElement(By.xpath("//span[text()='Email']/..//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//span[text()='Sandals']/..//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//span[text()='Regarding the same product']/..//input[@type='checkbox']")).click();
	    driver.findElement(By.id("mode_g")).click();
	    


}

}
