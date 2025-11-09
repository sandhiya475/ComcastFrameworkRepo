package com.crm.generic.webdriverUtility;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method is used to maximize window
	 * @param driver
	 */				
	public void toMaximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * To minimize windo
	 * @param driver
	 */
	public void toMinimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * To wait until the element loaded
	 * @param driver
	 */
	public void toimplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	/**
	 * To give explicitWait
	 * @param driver
	 * @param element
	 */
	public void explicitwaitforelementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void explicitwaitforelementToBeSelected(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void explicitwaitforinvisibilityOf(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void explicitwaitforinvisibilityOf(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void explicitwaitforalertIsPresent(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void fluentwait(WebDriver driver,WebElement element) {
		FluentWait<WebDriver> wait=new FluentWait<>(driver);
		wait.pollingEvery(Duration.ofSeconds(1000));
		wait.withTimeout(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	/**
	 * To take Screenshot
	 * @param driver
	 * @param screenshotname
	 * @throws IOException
	 */
	public void toTakesScreenshotOfEntireWebPage(WebDriver driver,String screenshotname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./errorShots"+screenshotname+".png");
		FileHandler.copy(temp, dest);
	}
	
	public void toTakesScreenshotOfwebElement(WebDriver driver,WebElement element,String screenshotname) throws IOException {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest=new File("./errorShots"+screenshotname+".jpeg");
		FileHandler.copy(temp, dest);
	}
	
	/**
	 * To handle windows
	 * @param driver
	 * @param partialTitle
	 */
public void toHandleWindowByTitle(WebDriver driver,String partialTitle) {
		
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
	
	/**
	 * To handle frames
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void toHandleFrame(WebDriver driver,String name_id) {
		driver.switchTo().frame(name_id);
	}
	
	public void toHandleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void toHandleMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void toHandleParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * To handle dropdown
	 * @param element
	 * @param index
	 */
	public void toHandleDropdownbyindex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void toHandleDropdownbyvalue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void toHandleDropdownbyVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void toHandleDropdownDeselectByindex(WebElement element,int index) {
		Select select=new Select(element);
		select.deselectByIndex(index);
	}
	
	public void toHandleDropdownDeselectByvalue(WebElement element,String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	
	public void toHandleDropdownDeselectByVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	
	public void toHandleDropdownDeselectAll(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();
	}
	
	public void toHandleDropdownTogetAllSelectedOptions(WebElement element) {
		Select select=new Select(element);
		select.getAllSelectedOptions();
	}
	
	public void toHandleDropdownTogetFirstSelectedOption(WebElement element) {
		Select select=new Select(element);
		select.getFirstSelectedOption();
	}
	
	public void toHandleDropdownTogetOptions(WebElement element) {
		Select select=new Select(element);
		select.getOptions();
	}
	
	/**
	 * To handle mouse and keyboard related actions
	 * @param driver
	 */
	public void toMousehover(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void todoubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void tocontextClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void todragAndDrop(WebDriver driver,WebElement srcelement,WebElement tarelement) {
		Actions action=new Actions(driver);
		action.dragAndDrop(srcelement,tarelement).perform();
	}
	
	public void toclickAndHold(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.clickAndHold(element).perform();
	}
	
	public void torelease(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.release(element).perform();
	}
	
	public void scrollByAmount(WebDriver driver,int x,int y) {
		Actions action=new Actions(driver);
		action.scrollByAmount(x, y).perform();
	}
	
	public void scrollToElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.scrollToElement(element).perform();
	}
	
	public void toHandleAlertByAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void toHandleAlertByDissmiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void javascriptScrollBy(WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	}
	
	public void javascriptScrollTo(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		}
	
	public void javascriptScrollElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		}
	
	public void javascriptDisableElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element);
		}
	
	
	
	
}
