package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of methods related to WebDriver
 * It is used to maximize,minimize,implicit wait,explicit wait,to handle dropdown,
 * to handle frames, to handle mouse actions,to handle popup,to switch between windows and
 * to take screenshot
 * 
 * 
 */
public class WebDriverUtility {
	
	/**
	 * This method is used to maximize browser provided driver
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize browser provided driver
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to wait until element loaded in Webpage (Implicit wait)
	 * @param driver
	 */
	public void toImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	
	/**
	 * This method will wait until the element is clickable provided driver and element
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * This method will wait until the visiblity of element provided driver and element
	 * @param driver
	 * @param element
	 */
	public void visiblityOfElement(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*public void visiblityOfElement(WebDriver driver,WebElement element,String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.titleIs(title));
	}*/
	
	/**
	 * This method is used to handle dropdown using index provided with dropdown element 
	 * and index 
	 * @param element
	 * @param index
	 */
	public void toHandleDropdown(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method is used to handle dropdown using value provided with dropdown element
	 * and value
	 * @param element
	 * @param value
	 */
	public void toHandleDropdown(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method is used to handle dropdown using VisibleText provided with dropdown element
	 * and VisibleText
	 * @param text
	 * @param element
	 */
	public void toHandleDropdown(String text,WebElement element) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	/**
	 * This method is used to Switch driver control to frame using index
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 *  This method is used to Switch driver control to frame using name or Id
	 * @param driver
	 * @param name_id
	 */
	public void toHandleFrame(WebDriver driver,String name_id) {
		driver.switchTo().frame(name_id);
	}
	
	/**
	 *  This method is used to Switch driver control to frame using Webelement
	 */
	public void toHandleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to Switch driver control back to main page
	 * @param driver
	 */
	public void toBackMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to perform mouse hover on element provided with driver and element
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to perform Right Click on element provided with driver and element
	 */
	public void toRightClick(WebDriver driver,WebElement element) {
		Actions action=new  Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * This method used to perform double click on element provided with driver and element
	 * @param driver
	 * @param element
	 */
	public void toDoubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	/**
	 * This method used to perform drag and drop of an element provided with driver and two elements
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void toDragAndDrop(WebDriver driver,WebElement src,WebElement target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method is used to handle AlertPopup by accepting it provided driver
	 * @param driver
	 */
	public void toHandleAlertPopupByAccept(WebDriver driver) {
		Alert alertpopup = driver.switchTo().alert();
		alertpopup.accept();
	}
	
	/**
	 *  This method is used to handle AlertPopup by Dismissing it provided driver
	 * @param driver
	 */
	public void toHandleAlertPopupByDismiss(WebDriver driver) {
		Alert alertpopup = driver.switchTo().alert();
		alertpopup.dismiss();
	}
	
	/**
	 * This message is used to capture message in alert popup and then accept it
	 * and provided driver
	 * @param driver
	 * @return
	 */
	public String toCaptureAlertMessageAndAccept(WebDriver driver) {
		Alert alertPopup = driver.switchTo().alert();
		String alertMessage = alertPopup.getText();
		alertPopup.accept();
		return alertMessage;
	}
	
	/**
	 * This mathod is used to take screenshot of an entire webpage provided driver 
	 * and screenshotname
	 * @param driver
	 * @param screenshotname
	 * @return 
	 * @throws IOException
	 */
	public String toTakeScreenshot(WebDriver driver,String screenshotname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
	    File temp = ts.getScreenshotAs(OutputType.FILE);
	    File src=new File("./errorShots/"+screenshotname+".png");
	    FileHandler.copy(temp, src);
	    String path = src.getAbsolutePath(); //ExtentReports getting path, where screenshot
	    return path;
	}  
	
	/**
	 * This method is used to transfer driver control to window provided driver
	 * and particular window title
	 * @param driver
	 * @param partialTitle
	 */
	public void toSwitchWindow(WebDriver driver,String partialTitle) {
		
		//Step 1:- Capture All session Ids
		Set<String> allIds = driver.getWindowHandles();
		
		//Step 2:- Traverse to every window and capture Title
		for(String id:allIds) {
			String title = driver.switchTo().window(id).getTitle();
			
		//Step 3:- Compare the title captured with partialtitle given	
			if(title.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void toHandleWindows(WebDriver driver) throws InterruptedException {
		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		allIds.remove(parentId);
		for(String id:allIds) {
			driver.switchTo().window(id);
		}
		Thread.sleep(3000);
		driver.switchTo().window(parentId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
