package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {
	public static void main(String[] args) throws InterruptedException    {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		WebElement ele = driver.findElement(By.xpath("//section[text()='Web Elements']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		WebElement yesEle = driver.findElement(By.id("btn"));
		yesEle.click();
		WebElement noEle = driver.findElement(By.id("btn_two"));
		noEle.click();
		Actions ref=new Actions(driver);
		
		
		driver.findElement(By.xpath("//a[text()='Right Click']")).click();
		WebElement sEle = driver.findElement(By.id("btn_a"));
		ref.contextClick(sEle).perform();
		driver.findElement(By.xpath("//div[text()='Yes']")).click();
		
		driver.findElement(By.xpath("//a[text()='Double Click']")).click();
		WebElement yesElee = driver.findElement(By.xpath("//button[text()='Yes']"));
		ref.doubleClick(yesElee).perform();
		
		driver.findElement(By.xpath("//a[text()='Submit Click']")).click();
		driver.findElement(By.xpath("(//label[text()='Yes']/../..//input[@type='radio'])[1]")).click();
		driver.findElement(By.id("btn_abh")).click();
		
		driver.findElement(By.xpath("//a[text()='Disabled']")).click();	
		driver.findElement(By.id("btn_abc")).click();
		WebElement disEle = driver.findElement(By.id("submit"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", disEle);
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();
}
}