package assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotOfAnElement {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);

		WebElement textField = driver.findElement(By.id("twotabsearchtextbox"));
		textField.sendKeys("mobiles");
		Thread.sleep(3000);
		File tempfile = textField.getScreenshotAs(OutputType.FILE);
        File destfile=new File("./Screenshots.element.jpeg");
        FileHandler.copy(tempfile, destfile);
        
        Thread.sleep(3000);
        driver.quit();
}
}