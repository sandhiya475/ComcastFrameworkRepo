package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Textfield {

	public static void main(String[] args) throws InterruptedException   {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		WebElement ele = driver.findElement(By.xpath("//section[text()='Web Elements']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		driver.findElement(By.xpath("//section[text()='Text Field']")).click();
		WebElement nameTF = driver.findElement(By.id("name"));
		nameTF.sendKeys("Sandhiya S");
		nameTF.getAttribute("value");
		String exp="Sandhiya S";
		String act = driver.findElement(By.xpath("//input[@value='Sandhiya S']")).getText();
		if(exp.contains(act)) {
			System.out.println("Verified value is present");
		}else {
			System.out.println("Verified value is not present");
		}
		driver.findElement(By.id("email")).sendKeys("sandhiya@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//h1[text()='Register']")).click();
		
	    driver.findElement(By.xpath("(//*[name()='svg'])[1]")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[name()='svg'])[1]")).click();
		
		driver.findElement(By.xpath("//li[text()='Disabled']")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement nameF = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].value='sandhiya'",nameF);
	}

}
