package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class Fluent {

	public static void main(String[] args) throws InterruptedException {
     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://demowebshop.tricentis.com/");
     Thread.sleep(5000);
     
     FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
     wait.pollingEvery(Duration.ofSeconds(1));
     wait.withTimeout(Duration.ofSeconds(15));
     
     
     WebElement searchText = driver.findElement(By.id("small-searchterms"));
     wait.until(ExpectedConditions.elementToBeClickable(searchText));
     searchText.click();
     
     driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     driver.quit();
}
}
