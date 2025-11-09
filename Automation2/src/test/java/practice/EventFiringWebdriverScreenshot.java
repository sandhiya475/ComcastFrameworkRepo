package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EventFiringWebdriverScreenshot {
public static void main(String[] args) {
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://www.amazon.in/");
	EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	File temp = edriver.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Screenshots/error1.png");
	try {
		FileUtils.copyFile(temp, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}
}
