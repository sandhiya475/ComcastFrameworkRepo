package practice;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.WebDriverUtility;

public class Scenario5 {

	public static void main(String[] args) throws InterruptedException {
		//Step 1:- Launch Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Step 2:- Login to application with valid credentials
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3:- Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4:- Click on Create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 5:- Create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("sandhiya s");
		
		//Step 6:- Select the Organization from Organization look up image
        driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
  		
  		WebDriverUtility wutil1=new WebDriverUtility();
  		wutil1.toSwitchWindow(driver, "accounts");
  		driver.findElement(By.linkText("TCS")).click();
  		wutil1.toSwitchWindow(driver, "Contacts");
  		
		//Step 7:- Save and Verify
		driver.findElement(By.name("button")).click();
		
		String lastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(lastName.contains("divya1")) {
			System.out.println(lastName+"----Passed");
		}else {
			System.out.println(lastName+"----Failed");
		}
		
		
		//Step 8:- Logout of application
		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(logoutEle);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step 9:- Close Browser
		driver.quit();
		
	}

	}

