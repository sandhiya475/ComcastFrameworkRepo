package automation10TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewCategoryProducts {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://automationexercise.com/");
		
		String expca1="WOMEN";
		String expca2="MEN";
		String expca3="KIDS";
		String actualca1 = driver.findElement(By.xpath("//a[@href='#Women']")).getText();
		String actualca2 = driver.findElement(By.xpath("//a[@href='#Men']")).getText();
		String actualca3 = driver.findElement(By.xpath("//a[@href='#Kids']")).getText();
		if(expca1.equals(actualca1)) {
			System.out.println(" women categories are visible on left side bar");
		}else
		{
			System.out.println("Women categories are not visible on left side bar");
		}
		if(expca2.equals(actualca2)) {
			System.out.println("Men categories are visible on left side bar");
		}else
		{
			System.out.println("Men categories are not visible on left side bar");
		}
		if(expca3.equals(actualca3)) {
			System.out.println("Kids categories are visible on left side bar");
		}else
		{
			System.out.println(" Kids categories are not visible on left side bar");
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("(//a[@data-toggle='collapse'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Dress '])[1]")).click();
		
		String exp="WOMEN - DRESS PRODUCTS";
		String act = driver.findElement(By.xpath("//h2[text()='Women - Dress Products']")).getText();
		if(exp.equals(act)) {
			System.out.println("category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'");
		}else
		{
			System.out.println("category page is not displayed and confirm text 'WOMEN - TOPS PRODUCTS'");
		}
		driver.findElement(By.xpath("(//a[@data-toggle='collapse'])[2]")).click();
		
		String expe="MEN - TSHIRTS PRODUCTS";
		driver.findElement(By.xpath("//A[@href='/category_products/3']")).click();
		String actu = driver.findElement(By.xpath("//h2[text()='Men - Tshirts Products']")).getText();
		if(expe.equals(actu)) {
			System.out.println("user is navigated to that category page");
		}else {
			System.out.println("user is not navigated to that category page");
		}
	}
}
