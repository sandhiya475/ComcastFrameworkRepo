package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login2 {
	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//section[text()='X Path']")).click();
	driver.findElement(By.xpath("//section[text()='Login 2.0']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Username:']")).sendKeys("sandhiya");
    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345");
    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    driver.findElement(By.xpath("//input[@type='radio']")).click();
    driver.quit();
}
}