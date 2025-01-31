package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import io.reactivex.rxjava3.functions.Action;

public class ProjectPage extends BaseClass{
	
	@FindBy(xpath="//div[@class='order-xl-2 mb-5 mb-xl-0 text-left  col']")
	WebElement pageHeader_project;
	
	@FindBy(xpath="//a[normalize-space()='Project']")
	WebElement link_project;
	
	public ProjectPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPageHeader_project() {
		return pageHeader_project;
	}
	
	public WebElement getLink_project() {
		return link_project;
	}
	
	public void verifyPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "AECP";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void verifyPageHeader() {
		@Nullable
		String x = driver.getPageSource();
		x.contains("h1");
	}

}
