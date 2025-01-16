package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class DashboardPage extends BaseClass{
	@FindBy(xpath="//img[@class='navbar-brand-img']")
	WebElement logo;
	
	

}
