package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass1;

public class TaskPage extends BaseClass1{
	@FindBy(xpath="//a[text()='Task']")
	WebElement link_task;

	@FindBy(xpath="//img[@class='navbar-brand-img']")
	WebElement logo;

	@FindBy(xpath ="//button[normalize-space()='Select Employee']")
	WebElement dd_employee;

	@FindBy(xpath="//div[@class='dropdown-menu show']//button")
	WebElement list_emp_dd;

	@FindBy(xpath ="//button[normalize-space()='Select Project']")
	WebElement dd_project;

	@FindBy(xpath = "//button[normalize-space()='Select Period']")
	WebElement dd_period;

	@FindBy(xpath="//button[normalize-space()='Add Task']")
	WebElement btn_AddTask;

	@FindBy(xpath="//form[@enctype='multipart/form-data']")
	WebElement form_Task;
	
	@FindBy(xpath="(//div[@class='dropdown'])[1]")
	WebElement inprogress_ddToggle;
	
	@FindBy(xpath="(//div[@class='dropdown'])[2]")
	WebElement completed_ddToggle;
	
	@FindBy(xpath="(//button[text()='View'])[1]")
	WebElement btn_view;
	
	@FindBy(xpath="//div[contains(@class,'dropdown-menu dropdown-menu-right show')]//button[contains(@role,'menuitem')][normalize-space()='Edit']")
	WebElement btn_edit;
	
	@FindBy(xpath="//div[contains(@class,'dropdown-menu dropdown-menu-right show')]//button[contains(@role,'menuitem')][normalize-space()='Delete']")
	WebElement btn_delete;

	public TaskPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLink_task() {
		return link_task;
	}

	public WebElement getLogo() {
		return logo;
	}

	public boolean checkFooterSticky() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Object footer = driver.findElement(By.xpath("//div[@class='align-items-center justify-content-xl-between row']"));
		// Get the CSS position property of the footer

		return (boolean) js.executeScript("var rect = arguments[0].getBoundingClientRect();"
				+ "return (rect.bottom <= window.innerHeight && rect.bottom > 0);", footer);

	}

	public void employee_dd(String employee) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		waitExplicit(dd_employee);
		dd_employee.click();
		List<WebElement> list_emp = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//button"));
		for(WebElement emp : list_emp)
		{
			if(emp.getText().equals(employee))
			{
				emp.click();
				break;
			}
		}
	}

	public WebElement getList_emp_dd() {
		return list_emp_dd;
	}

	public void projectdd() {
		waitExplicit(dd_project);
		dd_project.click();
	}

	public void periodDd(String period) {
		waitExplicit(dd_period);
		dd_period.click();
		List<WebElement> list_period = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//button"));
		for(WebElement period1: list_period)
		{
			if(period1.getText().equals(period))
			{
				Assert.assertEquals(period1.getText(), period, "Selected period does not match with expected period");
				period1.click();
				break;
			}
		}
	}
	
	public void addTaskButtonFunctionality() {
		btn_AddTask.click();
		waitExplicit(form_Task);
		Assert.assertTrue(form_Task.isDisplayed());
	}
	
	public void taskOptions() {
		inprogress_ddToggle.click();
		waitImplicit();
		WebElement options = driver.findElement(By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']"));
		Assert.assertTrue(options.isDisplayed());
	}
	
	public void viewTaskDetails() {
		inprogress_ddToggle.click();
		waitExplicit(btn_view);
		btn_view.click();
		WebElement taskDetailPage = driver.findElement(By.xpath("//h1[normalize-space()='View Task Details']"));
		Assert.assertTrue(taskDetailPage.isDisplayed());	
	}
	
	public void editTaskDetails() {
		inprogress_ddToggle.click();
		waitExplicit(btn_edit);
		btn_edit.click();
		WebElement editTaskPage = driver.findElement(By.xpath("//h1[text()='Edit Task Details']"));
		Assert.assertTrue(editTaskPage.isDisplayed());
	}
	
	public void deleteTask() {
		completed_ddToggle.click();
		waitExplicit(btn_delete);
		btn_delete.click();
		WebElement taskToDelete = driver.findElement(By.xpath("(//div[@class='card-body'])[5]"));
		Assert.assertFalse(taskToDelete.isDisplayed());
	}










}
