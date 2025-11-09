package com.crm.listenerutility;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.webdriverUtility.UtilityClassObject;

public class ListImpClass implements  ITestListener,ISuiteListener{
 ExtentReports report;
 ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		//spark report config
		String time = new Date().toString().replace(" ","_").replace(":","_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backUP");
		report.flush();
	}
    //It will execute before method
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===="+result.getMethod().getMethodName()+">====START====");
	    test = report.createTest(result.getMethod().getMethodName());
	    UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"==> STARTED <==");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==="+result.getMethod().getMethodName()+">=====END====");
		test.log(Status.INFO,result.getMethod().getMethodName()+"==> COMPLETED <==");	
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath, testName+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"==> FAILED <==");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"===> SKIPPED <===");
	}


}
