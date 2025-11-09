package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimePicker {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		driver.get("https://demoapps.qspiders.com/ui/timePick?sublist=0");
		
	    driver.findElement(By.xpath("(//*[name()='svg'])[1]")).click();
	    driver.findElement(By.xpath("(//li[text()='10'])[1]")).click();
	    driver.findElement(By.xpath("(//li[text()='10'])[2]")).click();
	    driver.findElement(By.xpath("//li[text()='AM']")).click();
}
}