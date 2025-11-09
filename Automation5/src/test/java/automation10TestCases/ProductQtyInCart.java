package automation10TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductQtyInCart {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://automationexercise.com/");
		String expectedData="Automation Exercise";
		String actualData = driver.getTitle();
		 
		if(expectedData.equals(actualData)) {
			System.out.println("Homepage visibile successfully");
		}
		else {
			System.out.println("Homepage not visible");
		}
		
		driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();
		
		String expectedPage = "Blue Top";
		String actualPage = driver.findElement(By.xpath("//h2[text()='Blue Top']")).getText();
		if(expectedPage.equals(actualPage)) {
			System.out.println("Product page displayed");
		}else {
			System.out.println("Product page is not displayed");
		}
		
		WebElement quantityTextfield = driver.findElement(By.id("quantity"));
		quantityTextfield.clear();
		quantityTextfield.sendKeys("4");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("//u[text()='View Cart']")).click();
		
		String expectedProduct="Blue Top";
		String actualProduct=driver.findElement(By.linkText("Blue Top")).getText();
		if(expectedProduct.equals(actualProduct)) {
			System.out.println("product is displayed in cart page  ");
		}else {
			System.out.println("product is not displayed in cart page  ");
		}
		String expectedQuantity = "4";
		String actualQuantity = driver.findElement(By.xpath("//button[text()='4']")).getText();
		if(expectedQuantity.equals(actualQuantity)) {
			System.out.println("product is displayed in cart page with exact quantity ");
		}else {
			System.out.println("product is not displayed in cart page with exact quantity ");
		}
		
		driver.quit();
		
	}
}