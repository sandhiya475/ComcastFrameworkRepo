package automation10TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProductsandVerifyCartAfterLogin {
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
		WebElement searchTextField = driver.findElement(By.id("search_product"));
		searchTextField.click();
		searchTextField.sendKeys("saree");
		driver.findElement(By.id("submit_search")).click();
	    WebElement searchedEle = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
	    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
	    if(wait.until(ExpectedConditions.visibilityOf(searchedEle)).isDisplayed()) {
	    	System.out.println(" 'SEARCHED PRODUCTS' is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	    WebElement pro1 = driver.findElement(By.xpath("(//p[text()='Cotton Silk Hand Block Print Saree'])[1]"));
	    WebElement pro2= driver.findElement(By.xpath("(//p[text()='Rust Red Linen Saree'])[1]"));
	    WebElement pro3= driver.findElement(By.xpath("(//p[text()='Beautiful Peacock Blue Cotton Linen Saree'])[1]"));
	    if(wait.until(ExpectedConditions.visibilityOf(pro1)).isDisplayed()) {
	    	System.out.println(" 'SEARCHED PRODUCTS1' is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	    if(wait.until(ExpectedConditions.visibilityOf(pro2)).isDisplayed()) {
	    	System.out.println(" 'SEARCHED PRODUCTS2' is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	    if(wait.until(ExpectedConditions.visibilityOf(pro3)).isDisplayed()) {
	    	System.out.println(" 'SEARCHED PRODUCTS3' is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	    driver.findElement(By.xpath("((//p[text()='Cotton Silk Hand Block Print Saree'])[1]/../../..//a[text()='Add to cart'])[1]")).click();
	    driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	    driver.findElement(By.xpath("((//p[text()='Rust Red Linen Saree'])[1]/../../..//a[text()='Add to cart'])[1]")).click();
	    driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	    driver.findElement(By.xpath("((//p[text()='Beautiful Peacock Blue Cotton Linen Saree'])[1]/../../..//a[text()='Add to cart'])[1]")).click();
	    driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	    
	    driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
	    WebElement proEle1 = driver.findElement(By.xpath("(//p[text()='Women > Saree'])[1]"));
	    WebElement proEle2 = driver.findElement(By.xpath("(//p[text()='Women > Saree'])[1]"));
	    WebElement proEle3= driver.findElement(By.xpath("(//p[text()='Women > Saree'])[1]"));
	    if(wait.until(ExpectedConditions.visibilityOf(proEle1)).isDisplayed()) {
	    	System.out.println(" product1 is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	    if(wait.until(ExpectedConditions.visibilityOf(proEle2)).isDisplayed()) {
	    	System.out.println("product2 is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	    if(wait.until(ExpectedConditions.visibilityOf(proEle3)).isDisplayed()) {
	    	System.out.println("product3 is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	    driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
	    driver.findElement(By.name("name")).sendKeys("sandhiya");
	    driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("sandy@gmail.com");
	    driver.findElement(By.xpath("//button[text()='Signup']")).click();
	    driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
	    WebElement proElew1 = driver.findElement(By.xpath("(//p[text()='Women > Saree'])[1]"));
	    WebElement proElew2 = driver.findElement(By.xpath("(//p[text()='Women > Saree'])[1]"));
	    WebElement proElew3= driver.findElement(By.xpath("(//p[text()='Women > Saree'])[1]"));
	    if(wait.until(ExpectedConditions.visibilityOf(proElew1)).isDisplayed()) {
	    	System.out.println("after login product1 is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	    if(wait.until(ExpectedConditions.visibilityOf(proElew2)).isDisplayed()) {
	    	System.out.println("after login product2 is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	    if(wait.until(ExpectedConditions.visibilityOf(proElew3)).isDisplayed()) {
	    	System.out.println("after login product3 is visible");
	    }else {
	    	System.out.println(" 'SEARCHED PRODUCTS' is not  visible");
	    }
	}
}
