package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://testautomationpractice.blogspot.com/");
	
	WebElement ele = driver.findElement(By.xpath("//h2[text()='Drag and Drop']"));
	Actions action= new Actions(driver);
	action.scrollToElement(ele).perform();
	WebElement dragEle = driver.findElement(By.id("draggable"));
	WebElement dropEle = driver.findElement(By.id("droppable"));
	action.dragAndDrop(dragEle, dropEle).perform();
	System.out.println("Drag and droped successfully");
	driver.quit();
}
}