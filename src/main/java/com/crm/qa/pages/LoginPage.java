package com.crm.qa.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement Loginbtn;

	@FindBy(xpath = "//img[@alt='Free CRM Software for customer relationship management, sales and support']")
	WebElement crmLogo;
	
	@FindBy(xpath="//a[contains(text(),'About Us')];")
	WebElement AboutUstext;

	//Initalize the page objects
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public String validateLoginTitle() {
		return driver.getTitle();
	}

	public boolean ValidateLogo() {
		return crmLogo.isDisplayed();
	}

	public HomePage ValidateLogin(String Uname, String Pass) {
		username.sendKeys(Uname);
		password.sendKeys(Pass);
		Loginbtn.click();
        //After successfull login->it should return Homepage
		return new HomePage();
	}

}
