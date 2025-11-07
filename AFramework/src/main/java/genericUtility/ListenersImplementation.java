package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"----Started");
		test=report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"----Passed");
		test.log(Status.PASS, methodname+"----Passed");
	
		}
	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"----Failed");
		test.log(Status.FAIL, methodname+"---Failed");
		test.log(Status.INFO, result.getThrowable());
	
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		
		String screenshotname = methodname+"-"+jutil.toGetSystemDateandTime();
		try {
			String path = wutil.toTakeScreenshot(BaseClass.sDriver, screenshotname);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Skipped");
		test.log(Status.SKIP, methodname+"---Skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
     System.out.println("----Suite Execution Started----");
     
     //ExtentSparkReporter
     ExtentSparkReporter htmlreporter=new ExtentSparkReporter("./ExtentReports/Reports"+new JavaUtility().toGetSystemDateandTime()+".html");
     htmlreporter.config().setDocumentTitle("vtiger execution reports");
     htmlreporter.config().setTheme(Theme.DARK);
     htmlreporter.config().setReportName("VTIGER EXECUTION REPORTS");
      
     //ExtentReports
     report=new ExtentReports();
     report.attachReporter(htmlreporter);
     report.setSystemInfo("base url","http://localhost:8888/" );
     report.setSystemInfo("base browser","chrome" );
     report.setSystemInfo("username", "admin");
     report.setSystemInfo("password","password" );
     report.setSystemInfo("ReporterName", "sandhiya");
     
}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("----Suite Execution Finished----");
		report.flush();
			}
}
