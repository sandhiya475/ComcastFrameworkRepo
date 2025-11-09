package automation10TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoveProductsFromCart {
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
		
		driver.findElement(By.xpath("//a[text()=' Products']")).click();
		driver.findElement(By.xpath("(//h2[text()='Rs. 500']/../../..//a[@data-product-id='1'])[1]")).click();
        
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
		driver.findElement(By.xpath("//a[text()=' Cart']")).click();
		String expectedCartPage="Shopping Cart";
		String actualCartPage=driver.findElement(By.xpath("//li[text()='Shopping Cart']")).getText();		
        if(expectedCartPage.equals(actualCartPage)) {
        	System.out.println(" cart page is displayed");
        }
        else
        {
        	System.out.println(" cart page is not displayed");
        }
        driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
        String expected="Cart is empty!";
        String actual=driver.findElement(By.xpath("//b[text()='Cart is empty!']")).getText();
        if(expected.equals(actual)) {
        	System.out.println(" product is removed from the cart Successfully");
        }
        else {
        	System.out.println(" product is not removed from the cart");
        }
	}	
}
