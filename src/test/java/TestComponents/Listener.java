package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;




public class Listener extends BaseTest implements ITestListener {
	
	ExtentTest test;
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	
	@Override
	public void onTestStart(ITestResult result) {
	test = extent.createTest(result.getMethod().getMethodName());
	 
	
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
	test.log(Status.PASS, "Test Passed");
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String filepath =null;
	
	
	try {
		 filepath = getScreenshot(result.getMethod().getMethodName(), driver );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	
	@Override
    public void onTestFailure(ITestResult result) {
   System.out.println("Test failed: " + result.getName());
   
  
 }
	 
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
	extent.flush();	
	}
	
	
}
