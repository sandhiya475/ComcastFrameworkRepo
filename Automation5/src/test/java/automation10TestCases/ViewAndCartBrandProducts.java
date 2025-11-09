package automation10TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewAndCartBrandProducts {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://automationexercise.com/");
		
		driver.findElement(By.xpath("//a[text()=' Products']")).click();
		
		String exp="BRANDS";
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		WebElement brandEle = driver.findElement(By.xpath("//h2[text()='Brands']"));
		String actual = brandEle.getText();
		if(exp.equals(actual)) {
			System.out.println("Brands are visible on left side bar");
		}else {
			System.out.println("Brands are not visible on left side bar");
		}
		driver.findElement(By.xpath("//a[text()='Polo']")).click();
		String expb="BRAND - POLO PRODUCTS";
		String actb = driver.findElement(By.xpath("//h2[text()='Brand - Polo Products']")).getText();
		if(expb.equals(actb)) {
			System.out.println("user is navigated to brand page and brand products are displayed");
		}
		else {
			System.out.println("user is not navigated to brand page and brand products are not displayed");
		}
		
		driver.findElement(By.xpath("//a[text()='H&M']")).click();
		String expbr="BRAND - H&M PRODUCTS";
		String actbr=driver.findElement(By.xpath("//h2[text()='Brand - H&M Products']")).getText();
		if(expbr.equals(actbr)) {
			System.out.println("user is navigated to that brand page and can see products");
		}else {
			System.out.println("user is not navigated to that brand page and cannot see products");
		}
	}
}
