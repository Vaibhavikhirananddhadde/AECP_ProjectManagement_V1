package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;

public class DashboardPage extends BaseClass{
	@FindBy(xpath="//img[@class='navbar-brand-img']")
	WebElement logo;

	@FindBy(xpath="//div[@class='react-calendar']")
	WebElement calender;

	@FindBy(xpath = "//button[contains(text(),'›')]")
	WebElement next_month;

	@FindBy(xpath="//button[contains(text(),'‹')]")
	WebElement previous_month;

	@FindBy(xpath="//span[@class='react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from']")
	WebElement current_month;

	@FindBy(xpath="//button[normalize-space()='»']")
	WebElement next_year;

	@FindBy(xpath="//button[normalize-space()='«']")
	WebElement previous_year;

	@FindBy(xpath="//div[@class='react-calendar__month-view__days']//button")
	WebElement month_date;

	@FindBy(xpath="//span[@class='mb-0 text-sm font-weight-bold']")
	WebElement profile_name;

	@FindBy(xpath="//button[@role='menuitem']//span[contains(text(),'Logout')]")
	WebElement btn_logout;
	

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogo() {
		return logo;
	}

	public void navigationLinks(String link_text) throws InterruptedException {
		List<WebElement> nav_links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//a"));
		for (WebElement link : nav_links) {
			// Step 4: Check if the link's text matches the target string
			if (link.getText().equalsIgnoreCase(link_text)) {
				// Step 5: If it matches, click the link
				link.click();
				driver.getPageSource().contains(link_text);
				System.out.println("Clicked on the navigation link: " + link_text);

				// Exit the loop once the link has been clicked
				break;
			}
		}
	}

	public WebElement getNext_month() {
		return next_month;
	}

	public void clickNextMonth() {
		String previousMonth = current_month.getText();
		next_month.click();
		//System.out.println(current_month.getText());
		String nextMonth = current_month.getText();
	    Assert.assertNotEquals(nextMonth, previousMonth);
	}

	public void clickPreviousMonth() {
		String previousMonth = current_month.getText();
		previous_month.click();
		String nextMonth = current_month.getText();
		//System.out.println(current_month.getText());
		Assert.assertNotEquals(nextMonth, previousMonth);
	}

	public void clickNextYear() {
		String previousMonth = current_month.getText();
		next_year.click();
		String nextMonth = current_month.getText();
		//System.out.println(current_month.getText());
		Assert.assertNotEquals(nextMonth, previousMonth);
	}

	public void clickPreviousYear() {
		String previousMonth = current_month.getText();
		previous_year.click();
		waitImplicit();
		String nextMonth = current_month.getText();
		//System.out.println(current_month.getText());
		Assert.assertNotEquals(nextMonth, previousMonth);
	}


	public void selectDate(String targetDay) throws InterruptedException {
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='react-calendar__month-view__days']//button"));
		for(WebElement date:dates)
		{
			if(date.getText().equals(targetDay))
			{
				waitUntillVisiblity(date);
				date.click();				 
				Assert.assertEquals(date.getText(), targetDay);
				waitImplicit();
				break;
			}		
		}

	}

	public void logout() {
		profile_name.click();
		btn_logout.click();
	}
	
	public boolean checkFooterSticky() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Object footer = driver.findElement(By.xpath("//footer[@class='footer mt-4']"));
		 // Get the CSS position property of the footer
		
		return (boolean) js.executeScript("var rect = arguments[0].getBoundingClientRect();"
				+ "return (rect.bottom <= window.innerHeight && rect.bottom > 0);", footer);
       
	}






}
