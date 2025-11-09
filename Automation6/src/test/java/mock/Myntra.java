package mock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Myntra {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.myntra.com/");

		WebElement searchEle = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		searchEle.click();
		searchEle.sendKeys("furniture", Keys.ENTER);

		List<WebElement> productsName = driver.findElements(By.xpath(
				"//li[@class='product-base'][number(translate(.//span[@class='product-discountedPrice'],'Rs. ',''))<20000]//h4[@class='product-product']"));

		try {
			for (WebElement pname : productsName) {
				System.out.println(pname.getText());
			}
		} catch (Exception e) {

		}
	}

}
