package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SetupExtentReport{
	
	public static ExtentReports setupExtentReport() {
		
		String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport_" + timestamp + ".html";
				
		ExtentReports extent = new ExtentReports();
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
