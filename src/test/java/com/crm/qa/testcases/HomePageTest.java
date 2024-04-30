package com.crm.qa.testcases;

import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase {
	LoginPage login;
	TestUtil testUtil;
	HomePage homepage;
 
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void beforeClass() throws IOException {
		initailization();
		testUtil=new TestUtil();
	//	homepage = login.ValidateLogin(prop.getProperty("username"), "password");
		//both are same
		homepage = login.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void Test() {
	}

	@AfterMethod
	public void afterClass() {
	}

}
