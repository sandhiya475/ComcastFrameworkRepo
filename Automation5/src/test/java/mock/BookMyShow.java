package mock;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookMyShow {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://in.bookmyshow.com/");

		driver.findElement(By.xpath("//p[text()='Bengaluru']")).click();
		driver.findElement(By.xpath("//div[text()='Dies Irae']")).click();
		driver.findElement(By.xpath("(//span[text()='Book tickets'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Continue']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Set<String> theaterNames = new LinkedHashSet<>();

		for (int i = 0; i >= 0; i++) {
			List<WebElement> theater = driver.findElements(By.xpath(
					"//div[@class='ReactVirtualized__Grid__innerScrollContainer']/descendant::div[@class='sc-1h5m8q1-2 hXDCNp']"));
			int count = theaterNames.size();

			for (WebElement w : theater) {
				theaterNames.add(w.getText());
			}

			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);
			if (theaterNames.size() == count) {
				break;
			}

			for (String s : theaterNames) {
				System.out.println(s);
			}
		}
	}
}
