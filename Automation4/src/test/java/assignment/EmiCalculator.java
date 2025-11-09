package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EmiCalculator {
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    
	driver.get("https://emicalculator.net/");
	
	Actions act = new Actions(driver);
    act.scrollByAmount(0, 1300).perform();

	WebElement main = driver.findElement(By.xpath("//div[@class='hidden-ts highcharts-container']"));
	List<WebElement> chartPoints = driver.findElements(By.xpath("//div[@class='hidden-ts highcharts-container']/descendant ::* [name()='svg']/descendant :: *[name()='g' and @class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker']/*[name()='path' and @class='highcharts-point']"));
	
	act.moveToElement(main).perform();
	
	for (WebElement each : chartPoints) {
	act.moveToElement(each).perform();
	WebElement data = driver.findElement(By.xpath("//div[@class='hidden-ts highcharts-container']/descendant ::* [name()='svg']/descendant :: *[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']/child::*[name()='text']"));
	String pointvalue = data.getText();
	System.out.println(pointvalue);
	driver.quit();
  }

}
}