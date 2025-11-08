package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario4 {
public static void main(String[] args) {
		
		//Step 1:-Launch Browser
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        //Step 2:- Login to application with valid credentials
        driver.get("http://localhost:8888/");
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("password");
        driver.findElement(By.id("submitButton")).click();
        
        //Step 3:- Navigate to Organization link
        driver.findElement(By.linkText("Organizations")).click();
        
        //Step 4:- Click on create Organization look up image
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        
      //Generate Random Number
        Random r=new Random();
        int randomvalue = r.nextInt(1000);
        
        //Step 5:- Create Organization with mandatory fields
        driver.findElement(By.name("accountname")).sendKeys("TCS"+randomvalue);
        
        //Step 6:- Select "Energy" in the industry dropdown
        WebElement indDropDown = driver.findElement(By.name("industry"));
        Select energy=new Select(indDropDown);
        energy.selectByValue("Energy");
        
        //Step 7:- Select "Customer" in the type dropdown
        WebElement typeDropDown = driver.findElement(By.name("accounttype"));
        Select customer=new Select(typeDropDown);
        customer.selectByValue("Customer");
        
        
        //Step 6:- Save and Verify
        driver.findElement(By.name("button")).click();
        String organizationname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(organizationname.contains("TCS"+randomvalue)) {
        	System.out.println(organizationname +"------Passed");
        }else {
        	System.out.println(organizationname +"------Failed");
        }
        
        //Step 7:- Logout of Application
        WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions action=new Actions(driver);
        action.moveToElement(logoutEle).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        
        // Step 8:- Close Browser
        driver.quit();
        
        }



}
