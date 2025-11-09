package com.crm.generic.webdriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
/**
 * This class help us to share my static var for multiple threads for parallel execution
 */
public class UtilityClassObject {

public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

public static ExtentTest getTest() {
	return test.get();
	}

public static void setTest(ExtentTest actTest) {
	test.set(actTest);
	}
public static WebDriver getDriver() {
	return driver.get();
	}

public static void SetDriver(WebDriver actdriver) {
	driver.set(actdriver);
	}

}
