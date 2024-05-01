package com.crm.qa.testcases;

import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase {
	LoginPage login;
	HomePage homepage;
 
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void beforeClass() throws IOException {
		initailization();
		login=new LoginPage();
		homepage = login.ValidateLogin(prop.getProperty("username"), "password");
		//both are same
	//	homepage = login.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void Test() {
	}

	@AfterMethod
	public void afterClass() {
	}

}
