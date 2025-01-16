package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class SetupExtentReport extends BaseClass{
	
	public static ExtentReports setupExtentReport() {
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		//get current date
		
		String Actualdate = format.format(new Date());
		
		String reportPath = System.getProperty("user.dir")+"/Reports/ExtentReport_"+Actualdate+".html";
		
		extent = new ExtentReports();
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("Document Title");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Report name");
		
		//set system information
		extent.setSystemInfo("Machine", "testpc1");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("username", "Vaibhavi Khiranand Dhadde");
		extent.setSystemInfo("browser", "Edge");
	
		return extent;
	}

}
