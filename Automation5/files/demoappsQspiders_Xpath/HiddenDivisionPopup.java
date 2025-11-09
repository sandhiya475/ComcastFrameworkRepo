package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HiddenDivisionPopup {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Hidden division']")).click();
		driver.findElement(By.xpath("//button[text()='Add Customer']")).click();
		driver.findElement(By.id("customerName")).sendKeys("sandy");
		driver.findElement(By.id("customerEmail")).sendKeys("sandy@gmail.com");
		WebElement dropdown = driver.findElement(By.id("prod"));
		Select ref=new Select(dropdown);
		ref.selectByVisibleText("Mobile");
		driver.findElement(By.id("message")).sendKeys("all types of branded mobile available");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.quit();
	}

}
