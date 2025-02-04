package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass1;
import pages.TaskPage;
import utilities.DataProviders;

public class TaskTests extends BaseClass1{
	public static  Logger logger = LogManager.getLogger(TaskTests.class);
	public TaskPage task;
	
	//Verify Page Loads within acceptable time limit.
	@Test(priority = 1)
	public void AECP_ProjectManager_Task_TC001() throws InterruptedException {
		test = extent.createTest("Verify Page load", "Ensure the page loads successfully");
		 // Wait for the page to fully load
       JavascriptExecutor js = (JavascriptExecutor) driver;
       boolean isPageLoaded = false;

       for (int i = 0; i < 10; i++) { // Max 10 retries
           if (js.executeScript("return document.readyState").equals("complete")) {
               isPageLoaded = true;
               break;
           }
           Thread.sleep(1000); // Wait 1 second before checking again
       }
       if (isPageLoaded) {
           System.out.println("Page has fully loaded!");
       } else {
    	   test.fail("Verifying page load test failed");
    	   logger.error("An error occured while page loading");
           System.out.println("Page load timed out.");
       }
	}
	
	//Verify that page title is displayed as expected.
	@Test(priority=2)
	public void AECP_ProjectManager_Task_TC002() {
		test = extent.createTest("Verify page title", "Verify that page title is displayed as expected.");
		task = new TaskPage();
		task.getLink_task().click();
		String expectedTitle = "AECP";
		String actualTitle = driver.getTitle();
		try {
			logger.info("Verifying page title");
			Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
			test.pass("Verifying page title test passed");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying page title", e);
			test.fail("verify page title test failed: "+e.getMessage());
			throw e;
		}
	}
	
	//Verify that logo is displayed at appropriate place.
	@Test(priority = 3)
	public void AECP_ProjectManager_Task_TC004() {
		test = extent.createTest("Verify logo", "Verify that logo is displayed at appropriate place.");
		task = new TaskPage();
		task.getLink_task().click();
		try {
			Assert.assertTrue(task.getLogo().isDisplayed());
			test.pass("Verifying logo displayed test passed");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying page logo", e);
			test.fail("Verifying page load test failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify Footer is Sticky (Remains at the Bottom)
	@Test(priority = 4)
	public void AECP_ProjectManager_Task_TC006() {
		test = extent.createTest("Verify footer sticky", "Verify Footer is Sticky (Remains at the Bottom)");
		task = new TaskPage();
		task.getLink_task().click();
		try {
			boolean isSticky = task.checkFooterSticky();
			Assert.assertTrue(isSticky);
			test.pass("Verify footer sticky test is passed");
		}catch(Exception e)
		{
			logger.error("an error occured while verifying footer sticky", e);
			test.fail("Verifying footer sticky"+e.getMessage());
			throw e;
		}
	}
	
	//Verify "Employee" dropdown functionality.
	@Test(priority = 5, dataProvider = "Task_employee_dropdowndata", dataProviderClass = DataProviders.class)
	public void AECP_ProjectManager_Task_TC009(String employee) {
		test = extent.createTest("Employee dropdown", "Verify \"Employee\" dropdown functionality.");
		task = new TaskPage();
		task.getLink_task().click();
		try {
			
			task.employee_dd(employee);
			test.pass("Verify employee dropdown test passed");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying employee dropdown", e);
			test.fail("employee dropdown verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify the "Select Project" dropdown functionality.
	@Test(priority = 6)
	public void AECP_ProjectManager_Task_TC010() {
		test = extent.createTest("Select project dropdown", "Verify the \"Select Project\" dropdown functionality.");
		task = new TaskPage();
		task.getLink_task().click();
		try {
			task.projectdd();
			test.pass("Verify project dropdown test is passed");
		}catch(Exception e)
		{
			logger.error("an error occured while selecting option from project dropdown", e);
			test.fail("project dropdown verification test failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify the "Select Period" dropdown functionality.
	@Test(priority = 7, dataProvider = "Task_Period_dropdowndata", dataProviderClass = DataProviders.class)
	public void AECP_ProjectManager_Task_TC011(String period) {
		test = extent.createTest("Select period dropdown", "Verify the \"Select Period\" dropdown functionality.");
		task = new TaskPage();
		task.getLink_task().click();
		try {
			task.periodDd(period);	
			test.pass("Verify period dropdown test passed");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying period dropdown", e);
			test.fail("period dropdown verification test failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify the "Add Task" button functionality.
	@Test(priority = 8)
	public void AECP_ProjectManager_Task_TC012() {
		test = extent.createTest("Add Task button", "Verify the \"Add Task\" button functionality.");
		task = new TaskPage();
		task.getLink_task().click();
		try {
			task.addTaskButtonFunctionality();
			test.pass("Add Task button is functioning well");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying add task button functionality",e);
			test.fail("Add task button verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify task options View, Edit, delete
	@Test(priority =9)
	public void AECP_ProjectManager_Task_TC018() {
		test = extent.createTest("Dropdown toggle","Verify task options View, Edit, delete");
		task = new TaskPage();
		task.getLink_task().click();
		try {
			task.taskOptions();
			test.pass("View Edit Delete options are displayed in task dropdown toggle");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying view, edit and delete options in task",e);
			test.fail("Task options verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify that user can view the task details
	@Test(priority = 10)
	public void AECP_ProjectManager_Task_TC033() {
		test = extent.createTest("View Task Details", "Verify that user can view the task details");
		task = new TaskPage();
		task.getLink_task().click();
		try {
			task.viewTaskDetails();
			test.pass("Verify that user can view the task details passed");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying task details page displayed", e);
			test.fail("Task details page verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify that user can edit the details by clicking on edit button.
	@Test(priority = 11)
	public void AECP_ProjectManager_Task_TC034() {
		test = extent.createTest("View Task Details", "Verify that user can view the task details");
		task = new TaskPage();
		task.getLink_task().click();
		try {
			task.editTaskDetails();
			test.pass("Verify that user can edit the details by clicking on edit button.");
		}catch(Exception e)
		{
			logger.error("An error occured while editing task details", e);
			test.fail("Task edit verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify that user can delete the task by clicking on delete button.
	@Test(priority =12)
	public void AECP_ProjectManager_Task_TC035() {
		test = extent.createTest("Delete task", "Verify that user can delete the task by clicking on delete button.");
		task =new TaskPage();
		task.getLink_task().click();
		try {
			task.deleteTask();
			test.pass("Verify that user can delete the task by clicking on delete button.");
		}catch(Exception e) {
			logger.error("An error occured while deleting the task", e);
			test.fail("Delete task test got failed"+e.getMessage());
			throw e;
		}
	}

}
