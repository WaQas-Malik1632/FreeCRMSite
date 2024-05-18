package com.crm.qa.testcases;

import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginPageTest extends TestBase {

	LoginPage login;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initailization();
		login = new LoginPage();
	}

	@Test(priority = 1)
	public void VerifyLoginPageTitle() {
		String loginPageTitle = login.validateLoginTitle();
		Assert.assertEquals(loginPageTitle,
				"Free CRM software for customer relationship management, sales, and support.",
				"Free CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void VerifyLoginCRMLogo() {
		boolean flag = login.ValidateLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void LoginTest()
	{
		homepage = login.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {

	}
}
