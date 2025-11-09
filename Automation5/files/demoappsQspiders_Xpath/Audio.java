package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Audio {
public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	WebElement ele = driver.findElement(By.xpath("//section[text()='Web Elements']"));
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	
	driver.findElement(By.xpath("//section[text()='Audio']")).click();
	driver.findElement(By.xpath("//audio[@src='/assets/audiofile-CgEkKftg.mp3']")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//audio[@src='/assets/audiofile-CgEkKftg.mp3']")).click();
}
}