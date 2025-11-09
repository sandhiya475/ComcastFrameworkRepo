package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://demoapps.qspiders.com/ui/frames/nestedWithMultiple?sublist=3");

		WebElement frame0=driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
		driver.switchTo().frame(frame0);
		WebElement frame2 = driver.findElement(By.xpath("//div[@class='form_container']//iframe"));
		driver.switchTo().frame(frame2);
		WebElement frame3 = driver.findElement(By.xpath("(//div[@class='form-group']//iframe)[1]"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.switchTo().parentFrame();
		WebElement frame4 = driver.findElement(By.xpath("(//div[@class='form-group'])[2]//iframe"));
		driver.switchTo().frame(frame4);
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.switchTo().parentFrame();
		WebElement frame5 = driver.findElement(By.xpath("(//div[@class='form-group'])[3]//iframe"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.id("confirm")).sendKeys("Admin@1234");
		driver.switchTo().parentFrame();
		WebElement frame6 = driver.findElement(By.xpath("(//div[@class='form-group'])[4]//iframe"));
		driver.switchTo().frame(frame6);
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().parentFrame();
	
}

	}

