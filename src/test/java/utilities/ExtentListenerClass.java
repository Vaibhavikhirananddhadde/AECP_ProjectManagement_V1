package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.BaseClass;

public class ExtentListenerClass extends BaseClass implements ITestListener{


	/*public void configureReport()
	{
		 htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentListenerReport.html");
		//htmlReporter = new ExtentSparkReporter("ExtentListenerReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//set system information
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("username", "Vaibhavi Khiranand Dhadde");
		reports.setSystemInfo("browser", "Edge");
		
		//configure to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report");
		htmlReporter.config().setReportName("========== Test Report ============");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}*/
	
	@BeforeSuite
	public void onStart(ITestContext context)
	{
		//setup method call
		//configureReport();
		extent = SetupExtentReport.setupExtentReport();
		System.out.println("On Start method invoked..... ");
	}
	
	//When the test get started this method is invoked
	
		public void onTestStart(ITestResult Result)
		{
			//before each test case
			test = extent.createTest(Result.getName());
			System.out.println("Name of test method started: "+Result.getName());
		}
		
	
	
	//When the test case get failed this method is called
	
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of the method failed: "+Result.getName());
		test = extent.createTest(Result.getName());//Create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: "+Result.getName(), ExtentColor.RED));
		test.log(Status.FAIL, "the testcase failed cause is: "+Result.getThrowable());
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		//get current date
		
		String Actualdate = format.format(new Date());
		
		
		String screenShotPath =System.getProperty("user.dir")+"\\Screenshots\\"+Result.getName()+Actualdate+".png";
		
		File screenshotFile = new File(screenShotPath);
		
		try {
			FileUtils.copyFile(src, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(screenshotFile.exists())
		{
			test.fail("Captured Screenshot is below: "+test.addScreenCaptureFromPath(screenShotPath));
		}
		//test.addScreenCaptureFromPath("");
	}
	
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of the test method skipped: "+Result.getName());
		test = extent.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is: "+Result.getName(), ExtentColor.YELLOW));
		
	}
	
	
	
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of the test method passed is: "+Result.getName());
		test = extent.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name Of the passed test case is: "+Result.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
		
	}
	
	@AfterSuite
	public void onFinish(ITestContext Result)
	{
		//close extent
		System.out.println("On Finish method invoked..........");
		extent.flush();//It is mandatory to ensure information is written to the started report
	}
	
}
