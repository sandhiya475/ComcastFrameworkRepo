package automation10TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AddToCart {

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
		
		Actions ref=new Actions(driver);
		WebElement hoverEle = driver.findElement(By.xpath("(//p[text()='Men Tshirt'])[1]"));
		ref.moveToElement(hoverEle).perform();
		driver.findElement(By.xpath("((//p[text()='Men Tshirt'])[1]/../..//a[text()='Add to cart'])[1]")).click();
		driver.findElement(By.xpath("//u[text()='View Cart']")).click();
		
		String expectedPro1="Blue Top";
		String expectedPro2="Men Tshirt";
		String actualPro1=driver.findElement(By.linkText("Blue Top")).getText();
		String actualPro2=driver.findElement(By.linkText("Men Tshirt")).getText();
		
		 
		if(expectedPro1.equals(actualPro1) ) {
			System.out.println("Product1 added");
		}
		else {
			System.out.println("Product1 not added");
		}
		if(expectedPro2.equals(actualPro2) ) {
			System.out.println("Product2 added");
		}
		else {
			System.out.println("Product2 not added");
		}
		String expectedPricePro1="Rs. 500";
		String expectedQuantityPro1="1";
		String expectedTotalPricePro1="Rs. 500";
		
		String expectedPricePro2="Rs. 400";
		String expectedQuantityPro2="1";
		String expectedTotalPricePro2="Rs. 400";
		
		String actualPricePro1 = driver.findElement(By.xpath("(//p[text()='Rs. 500'])[1]")).getText();
		String actualQuantityPro1=driver.findElement(By.xpath("(//button[text()='1'])[1]")).getText();
		String actualTotalPricePro1=driver.findElement(By.xpath("(//p[text()='Rs. 500'])[1]")).getText();
	
		String actualPricePro2 = driver.findElement(By.xpath("(//p[text()='Rs. 400'])[1]")).getText();
		String actualQuantityPro2=driver.findElement(By.xpath("(//button[text()='1'])[1]")).getText();
		String actualTotalPricePro2=driver.findElement(By.xpath("(//p[text()='Rs. 400'])[1]")).getText();
	

		Assert.assertEquals(expectedPricePro1, actualPricePro1);
		Assert.assertEquals(expectedQuantityPro1, actualQuantityPro1);
		Assert.assertEquals(expectedTotalPricePro1, actualTotalPricePro1);
		
		Assert.assertEquals(expectedPricePro2, actualPricePro2);
		Assert.assertEquals(expectedQuantityPro2, actualQuantityPro2);
		Assert.assertEquals(expectedTotalPricePro2,actualTotalPricePro2 );
		driver.quit();
	}
	

}

