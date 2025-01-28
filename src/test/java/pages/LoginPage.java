package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email_txtfield;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pass_txtfield;
	
	@FindBy(xpath=" //button[normalize-space()='Submit']")
	WebElement btn_submit;
	
	@FindBy(css = "div[class='Container'] div h1")
	WebElement login_header;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void successfulLogin() throws Exception {
	    waitUntillVisiblity(email_txtfield);
		email_txtfield.sendKeys(readProperty("username", "/src/test/resources/configfiles/config.properties"));
		waitImplicit();
		pass_txtfield.sendKeys(readProperty("password", "/src/test/resources/configfiles/config.properties"));
		waitImplicit();
		btn_submit.click();
		Thread.sleep(3000);
	}
	
	public void invalidCredentials(String email, String password) throws InterruptedException {
		waitUntillVisiblity(email_txtfield);
		email_txtfield.sendKeys(email);
		waitImplicit();
		pass_txtfield.sendKeys(password);
		waitImplicit();
		btn_submit.click();
		Thread.sleep(3000);
		checkAlertpresent();
	}

	public WebElement getEmail_txtfield() {
		return email_txtfield;
	}

	public void setEmail_txtfield(WebElement email_txtfield) {
		this.email_txtfield = email_txtfield;
	}

	public WebElement getPass_txtfield() {
		return pass_txtfield;
	}

	public void setPass_txtfield(WebElement pass_txtfield) {
		this.pass_txtfield = pass_txtfield;
	}

	public WebElement getBtn_submit() {
		return btn_submit;
	}

	public void setBtn_submit(WebElement btn_submit) {
		this.btn_submit = btn_submit;
	}
	
	public WebElement getLogin_header() {
		return login_header;
	}
	
	
	
	
}
