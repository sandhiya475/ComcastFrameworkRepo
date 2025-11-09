package demoappsQspiders_Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://demowebshop.tricentis.com/");
     
     WebElement searchText = driver.findElement(By.id("small-searchterms"));
     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
     wait.until(ExpectedConditions.elementToBeClickable(searchText));
     searchText.click();
     driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     driver.quit();
}
}