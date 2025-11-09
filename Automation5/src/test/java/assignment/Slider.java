package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions action=new Actions(driver);
		action.scrollByAmount(0, 1800).perform();
		WebElement startScrollEle = driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
		WebElement endScrollEle = driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
		action.dragAndDropBy(startScrollEle, 9, 0).perform();
		action.dragAndDropBy(endScrollEle, -57, 0).perform();
		System.out.println("Slider value fixed successfully");
	}

}
