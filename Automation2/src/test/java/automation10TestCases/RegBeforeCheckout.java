package automation10TestCases;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class RegBeforeCheckout {
	public static void main(String[] args) {
		ChromeOptions ref=new ChromeOptions();
		ref.addArguments("--disabled-notifications");
		
		WebDriver driver=new ChromeDriver(ref);
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
		
		
		driver.findElement(By.xpath("(//h2[text()='Rs. 500']/../../..//a[@data-product-id='1'])[1]")).click();
        
		driver.findElement(By.xpath("//u[text()='View Cart']")).click(); 
		
		String expectedCartPage="Shopping Cart";
		String actualCartPage=driver.findElement(By.xpath("//li[text()='Shopping Cart']")).getText();		
        if(expectedCartPage.equals(actualCartPage)) {
        	System.out.println(" cart page is displayed");
        }
        else
        {
        	System.out.println(" cart page is not displayed");
        }
	
        driver.findElement(By.linkText("Proceed To Checkout")).click();
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();
        
        driver.findElement(By.name("name")).sendKeys("Sandhiya");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("saawHHHaeandhiya@gmail.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        driver.findElement(By.id("password")).sendKeys("12345");
        
        WebElement dayDropdown = driver.findElement(By.id("days"));
        WebElement monthDropdown = driver.findElement(By.id("months"));
        WebElement yearDropdown = driver.findElement(By.id("years"));
        
        Select day=new Select(dayDropdown);
        Select month=new Select(monthDropdown);
        Select year=new Select(yearDropdown);
        
        day.selectByIndex(24);
        month.selectByValue("5");
        year.selectByValue("1996");
        
        driver.findElement(By.id("first_name")).sendKeys("Sandhiya");
        driver.findElement(By.id("last_name")).sendKeys("S");
        driver.findElement(By.id("company")).sendKeys("Tek Pyramid");
        driver.findElement(By.id("address1")).sendKeys("123,kopalan workspace,tekpyramid");
        driver.findElement(By.id("address2")).sendKeys("111,Qspiders Marathahalli");
        
        driver.findElement(By.id("state")).sendKeys("Karnataka");
        driver.findElement(By.id("city")).sendKeys("KR Puram");
        driver.findElement(By.id("zipcode")).sendKeys("560035");
        driver.findElement(By.id("mobile_number")).sendKeys("9876543210");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
          
         String expecData="ACCOUNT CREATED!";
         String actuaData=driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
         if(expecData.contains(actuaData)) {
         	System.out.println("Account Created successfully");
         	}
         else {
         	System.out.println("Account not Created ");
         }
         
         driver.findElement(By.xpath("//a[text()='Continue']")).click();
         
         String ex="Logged in as Sandhiya";
         String ac = driver.findElement(By.xpath("//b[text()='Sandhiya']")).getText();
         if(ex.contains(ac)) {
         	System.out.println("Verified Logged in as Sandhiya");
         }
         else {
         	System.out.println("Not Verified Logged in as Sandhiya");
         }
         driver.findElement(By.xpath(" //a[text()=' Cart']")).click();
         driver.findElement(By.linkText("Proceed To Checkout")).click();
         
         String expectedAddress="123,kopalan workspace,tekpyramid";
         String actualAddress = driver.findElement(By.xpath("(//li[text()='123,kopalan workspace,tekpyramid'])[1]")).getText();
 	    if(expectedAddress.contains(actualAddress)) {
 	    	System.out.println("address verified");
 	    }
 	    else {
 	    	System.out.println("address verified failed");
 	    }
 	   String expectedpro = "Blue Top";
 		String actualpro = driver.findElement(By.linkText("Blue Top")).getText();
 		if(expectedpro.equals(actualpro)) {
 			System.out.println("product is reviewed in cart page with exact quantity ");
 		}else {
 			System.out.println("product is not displayed in cart page with exact quantity ");
 		}
 	    driver.findElement(By.name("message")).sendKeys("product quality good");
 	    
 		driver.findElement(By.linkText("Place Order")).click();
 		driver.findElement(By.name("name_on_card")).sendKeys("Rupay");
 		driver.findElement(By.name("card_number")).sendKeys("123");
 		driver.findElement(By.name("cvc")).sendKeys("111");
 		driver.findElement(By.name("expiry_month")).sendKeys("08");
 		driver.findElement(By.name("expiry_year")).sendKeys("2026");
 		driver.findElement(By.id("submit")).click();
 		
 		String exp="ORDER PLACED!";
 		String act = driver.findElement(By.xpath("//b[text()='Order Placed!']")).getText();
 		if(exp.equals(act)) {
 			System.out.println(" order has been placed successfully");
 		}
 		else {
 			System.out.println(" order not placed ");
 		}
 		driver.findElement(By.xpath(" //a[text()=' Delete Account']")).click();
 		String expe="ACCOUNT DELETED!";
 		String actu = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
 	if(expe.equals(actu)) {
 		System.out.println("account deleted successfully");
 	}
 	else {
 		System.out.println("Account not deleted");
 	}
 	driver.findElement(By.linkText("Continue")).click();
 	driver.quit();
	}
}
