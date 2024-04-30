package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class LoginPageTest extends TestBase {

	LoginPage login;
	HomePage homepage;
	String sheetName="LoginData";

	public LoginPageTest() throws IOException {
		super();
	}

	//Test case should be separated--Independent with each other.
	//Before each test case --Launch the browser and login->Test the functionality
	//After each test case --Close the browser
	
	@BeforeMethod
	public void setUp() throws IOException {
		initailization();
		login = new LoginPage();

	}

	@Test(priority = 1)
	public void VerifyLoginPagetitle() {
		String loginPageTitle = login.validateLoginTitle();
		Assert.assertEquals(loginPageTitle, "Free CRM software for customer relationship management, sales, and support.", "Free CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void VerifyLoginCRMLogo() {
		boolean flag = login.ValidateLogo();
		Assert.assertTrue(flag);
	}

	@DataProvider
	public Object [][] GetTestData(String sheetName) 
	{
		Object data[][];
		try {
			data = TestUtil.getTestData(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(priority = 3, dataProvider="GetTestData")
	public void LoginTest(String username, String password) {
		homepage=login.ValidateLogin(username, password);
		//homepage = login.ValidateLogin(prop.getProperty("username"), "password");
	}

	@AfterTest
	public void tearDown() {

	}

}
