package assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UploadSingleFile {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		Actions action=new Actions(driver);
		action.scrollByAmount(0, 1800).perform();
		driver.findElement(By.xpath("(//input[@type='file' ])[1]")).sendKeys("C:\\Users\\DELL\\Downloads\\PDF Scanner 07-10-25 8.48.56.pdf");
        driver.quit();
	}
}