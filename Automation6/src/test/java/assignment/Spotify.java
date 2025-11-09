package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Spotify {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://open.spotify.com/track/2uqXfUERVBLa1heEoUTBlO");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		driver.findElement(By.xpath("//input[@id='username' or @placeholder='Email or username']")).sendKeys("sandhiyasekar25@gmail.com");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		
		Thread.sleep(10000);
				
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		WebElement song = driver.findElement(By.xpath("//img[@src='https://i.scdn.co/image/ab67616d00001e0253d2e893acf43d05c2ffa216']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(song));
		song.click();
		
		js.executeScript("window.scrollBy(0,600)");
		WebElement song2 = driver.findElement(By.xpath("//button[@aria-label='Play Oru Maalai by Karthik']"));
		wait.until(ExpectedConditions.elementToBeClickable(song2));
		song2.click();
	
	    List<WebElement> ele = driver.findElements(By.xpath("//div[@class='T5vvc_kifMxkybDQV9Hi']/descendant::a[@class='wNvLD2rkUKfjZYESYCX2']"));
	    for(WebElement title: ele) {
	    	System.out.println(title.getText());
	    }
		List<WebElement> ele2 = driver.findElements(By.xpath("//div[@class='T5vvc_kifMxkybDQV9Hi']/descendant::div[@class='e-91000-text encore-text-body-small htbmhRXsxePzCR3HsX0V']"));
		 for(WebElement viewers: ele2) {
		System.out.println(viewers.getText());
		 }
		Thread.sleep(3000);
		driver.quit();
}
}