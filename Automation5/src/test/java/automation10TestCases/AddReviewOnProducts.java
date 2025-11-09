package automation10TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddReviewOnProducts {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://automationexercise.com/");
		
		driver.findElement(By.xpath("//a[text()=' Products']")).click();
		String exp="ALL PRODUCTS";
		String act = driver.findElement(By.xpath("//h2[text()='All Products']")).getText();
		if(exp.equals(act)) {
			System.out.println("user is navigated to ALL PRODUCTS page successfully");
		}else {
			System.out.println("user is not navigated to ALL PRODUCTS page successfully");
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
		
		String expe="WRITE YOUR REVIEW";
		String actu = driver.findElement(By.xpath("//a[@href='#reviews']")).getText();
		if(expe.equals(actu)) {
			System.out.println(" 'Write Your Review' is visible");
		}else {
			System.out.println(" 'Write Your Review' is not visible");
		}
		driver.findElement(By.id("name")).sendKeys("sandhiya");
		driver.findElement(By.id("email")).sendKeys("sandy@gmail.com");
		driver.findElement(By.name("review")).sendKeys("happy...");
		driver.findElement(By.id("button-review")).click();
		
		WebElement thanksEle = driver.findElement(By.xpath("//span[text()='Thank you for your review.']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		if((wait.until(ExpectedConditions.visibilityOf(thanksEle)).isDisplayed())){
			System.out.println("Verified successful message  ---'Thank you for your review.'");
		}else {
			System.out.println("successful message not received ---'Thank you for your review.'");
		}
		driver.quit();
	}
}
