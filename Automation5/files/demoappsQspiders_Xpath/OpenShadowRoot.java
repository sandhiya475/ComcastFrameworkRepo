package demoappsQspiders_Xpath;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenShadowRoot {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://demoapps.qspiders.com/ui/");
		
		driver.findElement(By.xpath("(//section[contains(text(),'Shadow')])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//section[contains(text(),'Shadow')])[2]")).click();
        Thread.sleep(2000);
		SearchContext textFieldEle = driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
		textFieldEle.findElement(By.cssSelector("//input[placeholder='Enter your username']")).sendKeys("Sandhiya");
		Thread.sleep(1000);
	    SearchContext passEle = driver.findElement(By.xpath("//form/div[2]")).getShadowRoot();
	    passEle.findElement(By.cssSelector("//input[placeholder='Enter your password']")).sendKeys("123456");
	    driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

}
