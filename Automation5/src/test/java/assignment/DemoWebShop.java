package assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoWebShop {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demowebshop.tricentis.com/");
		Actions act=new Actions(driver);
		act.scrollByAmount(0, 600).perform();
		driver.findElement(By.xpath("//a[text()='$25 Virtual Gift Card']/../..//input[@value='Add to cart']")).click();
		driver.findElement(By.id("giftcard_2_RecipientName")).sendKeys("XYZ");
		driver.findElement(By.id("giftcard_2_RecipientEmail")).sendKeys("XYZ@gmail.com");
		driver.findElement(By.id("giftcard_2_SenderName")).sendKeys("sandhiya");
		driver.findElement(By.id("giftcard_2_SenderEmail")).sendKeys("sandhiya@gmail.com");
		driver.findElement(By.id("giftcard_2_Message")).sendKeys("Happy birthday");
		driver.findElement(By.id("add-to-cart-button-2")).click();
		
		File temp = driver.findElement(By.xpath("//p[@class='content']")).getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/ele1.png");
		FileHandler.copy(temp, dest);
		
		WebElement books = driver.findElement(By.xpath("(//a[contains(text(),'Books')])[3]"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(books));
		books.click();
		driver.findElement(By.xpath("//a[text()='Computing and Internet']/../..//input[@value='Add to cart']")).click();
		WebElement scart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		wait.until(ExpectedConditions.elementToBeClickable(scart));
		scart.click();
		WebElement ele2 = driver.findElement(By.xpath("//table[@class='cart-total']"));
		act.scrollToElement(ele2).perform();
		

		File temp1 = driver.findElement(By.xpath("//table[@class='cart-total']")).getScreenshotAs(OutputType.FILE);
		File dest1=new File("./Screenshots/ele2.png");
		FileHandler.copy(temp1, dest1);
		
		//driver.quit();
		}

}
