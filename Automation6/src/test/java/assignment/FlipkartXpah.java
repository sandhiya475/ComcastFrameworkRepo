package assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;


public class FlipkartXpah {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@alt='Fashion']")).click();
		
		Actions action=new Actions(driver);
		WebElement menEle = driver.findElement(By.xpath("//span[text()='Men']"));
		action.moveToElement(menEle).perform();
		
		//WebElement ele = driver.findElement(By.xpath("//span[text()='Men']/following-sibling::span[text()='Women']/following::span[text()='Ethnic Wear']/following-sibling::a[text()='Kurtas & Kurtis']"));

		driver.findElement(RelativeLocator.with(By.tagName("span")).near(menEle)).click();
		driver.findElement(By.linkText("Kurtas & Kurtis")).click();

		System.out.println("Successfully navigated to Kurtas & Kurtis collections");
		driver.quit();
}
}