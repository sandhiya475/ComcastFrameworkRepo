package assignment;

import java.time.Duration;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Automation_Testing_Practice {

@Test
public void dragAndDropTest() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://testautomationpractice.blogspot.com/");
	
	WebElement ele = driver.findElement(By.xpath("//h2[text()='Drag and Drop']"));
	Actions action= new Actions(driver);
	action.scrollToElement(ele).perform();
	WebElement dragEle = driver.findElement(By.id("draggable"));
	WebElement dropEle = driver.findElement(By.id("droppable"));
	action.dragAndDrop(dragEle, dropEle).perform();
	System.out.println("Drag and droped successfully");
	driver.quit();
}

@Test
public void sliderTest() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://testautomationpractice.blogspot.com/");
	
	Actions action=new Actions(driver);
	action.scrollByAmount(0, 1800).perform();
	WebElement startScrollEle = driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
	WebElement endScrollEle = driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
	action.dragAndDropBy(startScrollEle, 9, 0).perform();
	action.dragAndDropBy(endScrollEle, -57, 0).perform();
	System.out.println("slider value fixed successfully");
}


@Test
public void dynamicWebTableTest() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://testautomationpractice.blogspot.com/");
	
	//WebElement table = driver.findElement(By.xpath("//h2[text()='Dynamic Web Table']"));
	Actions action=new Actions(driver);
	action.scrollByAmount(0, 2100).perform();
	
    WebElement firefoxEle = driver.findElement(By.xpath("//td[text()='Firefox']/.."));
    System.out.println(firefoxEle.getText()); 
}

@Test
public void uploadSingleFile() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://testautomationpractice.blogspot.com/");
	Actions action=new Actions(driver);
	action.scrollByAmount(0, 1800).perform();
	driver.findElement(By.xpath("(//input[@type='file' ])[1]")).sendKeys("C:\\Users\\DELL\\Downloads\\PDF Scanner 07-10-25 8.48.56.pdf");
    System.out.println("file uploaded successfully");
	driver.quit();
}

@Test
public void paginationWebTableTest() {
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