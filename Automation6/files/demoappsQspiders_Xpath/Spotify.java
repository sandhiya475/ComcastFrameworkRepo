package demoappsQspiders_Xpath;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Spotify {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//span[text()='Fashion']")).click();
		
		WebElement menBtn = driver.findElement(By.xpath("//span[text()='Men']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(menBtn).perform();
		
		WebElement menCollection = driver.findElement(By.xpath("//a[@title='Footwear']/ancestor::div[@class='jzpKY6']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(menCollection));
		System.out.println(menCollection.getText());
		
		driver.findElement(By.xpath("(//a[text()='Casual Shirts'])[1]")).click();
		
		
		List<WebElement> DisProduct = driver.findElements(By.xpath(""));
		for(WebElement discount:DisProduct) {
		    System.out.println("76 % dicount products are:" + discount.getText());
		}

	}

}
