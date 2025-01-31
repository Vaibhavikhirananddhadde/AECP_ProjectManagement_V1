package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass1;
import pages.DashboardPage;
import pages.ProjectPage;

public class ProjectTests extends BaseClass1{
	private static final Logger logger =  LogManager.getLogger(LoginTests.class);
	ProjectPage project;
	DashboardPage dashboard;

	//Verify that page loaded with all the components
	//@Test(priority =1)
	public void AECP_ProjectManager_Project_TC001() {
		test = extent.createTest("Verify that page loaded successfully");
		project = new ProjectPage();
		try {
		project.getLink_project().click();
		waitExplicit(project.getPageHeader_project());
		Assert.assertTrue(project.getPageHeader_project().isDisplayed());
		test.pass("Page load test passed");
		}catch(Exception e)
		{
			 logger.error("An error occured while loading page", e);
			 test.fail("Page logo verification failed: "+e.getMessage());
			 throw e;
		}
	}
	
	//Verify that page title is present
	//@Test(priority =2)
	public void AECP_ProjectManager_Project_TC002() {
		test = extent.createTest("Verify whether page title is present");
		logger.info("Verifying page title");
		project = new ProjectPage();
		try {
		project.verifyPageTitle();
		test.pass("Verify page title test passed");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying page title", e);
			test.fail("verify page title test failed: "+e.getMessage());
			throw e;
		}
		
	}
	

	//Verify logo is displayed.
	@Test(priority = 3)
	public void AECP_ProjectManager_Dashboard_TC004() {
		logger.info("Verify logo", "Ensure logo is displayed in the page");
		dashboard = new DashboardPage();
		project = new ProjectPage();
		project.getLink_project().click();
		test = extent.createTest("Verify logo", "Ensure the logo is displayed in the page");
		 try {
		Assert.assertTrue(dashboard.getLogo().isDisplayed());
		test.pass("Page logo verification passed");
		 }catch(Exception e)
		 {
			 logger.error("An error occured while validating the logo:", e);
			 test.fail("Page logo verification failed: "+e.getMessage());
			 throw e;
		 }
		
	}
	
	
}
