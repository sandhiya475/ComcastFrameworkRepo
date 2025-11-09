package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PaginationWebTable {
	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://testautomationpractice.blogspot.com/");
	
	Actions action=new Actions(driver);
	action.scrollByAmount(0, 2800).perform();
	WebElement table = driver.findElement(By.xpath("//div[@class='table-container']"));
	String expectedValue="Router";
	
	List<WebElement> num = driver.findElements(By.xpath("//ul[@class='pagination']/descendant::a[@href='#']"));
	for (WebElement numbers : num) {
		String tablevalue = table.getText();
		if(tablevalue.contains(expectedValue)) {
			System.out.println("Router is present");
			break;
		}
		else {
			numbers.click();
		}
		}
	driver.findElement(By.xpath("(//table[@id='productTable']/descendant::td[text()='12']/following::input[@type='checkbox'])[1]")).click();
	String routerPrice = driver.findElement(By.xpath("//td[text()='$30.99']")).getText();
	System.out.println("Router Price is "+routerPrice);
	driver.quit();
}
}