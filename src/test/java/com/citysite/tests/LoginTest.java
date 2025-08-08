package com.citysite.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.citysite.base.BaseTest;
import com.citysite.pages.LoginPage;

public class LoginTest  extends BaseTest{

	 private LoginPage loginPage;

	    @BeforeMethod
	    public void setupTest() {
	        setup();
	        loginPage = new LoginPage(driver);
	    }

	    @Test(priority = 1)
	    public void testJobSeekerLogin() throws InterruptedException {
	        loginPage.openJobSeekerLogin();
	        Thread.sleep(1000); // Can be replaced with WebDriverWait
	        loginPage.enterEmail("testdeveloper30@gmail.com");
	        loginPage.enterPassword("Test#123?");
	        loginPage.checkRememberMe();
	        loginPage.clickLogin();
	        // Add assertion here for successful login
	    }

	    @Test(priority = 2)
	    public void testRecruiterLogin() throws InterruptedException {
	        loginPage.openRecruiterLogin();
	        Thread.sleep(1000); // Can be replaced with WebDriverWait
	        loginPage.enterEmail("testdeveloper30@gmail.com");
	        loginPage.enterPassword("Test#123?");
	        loginPage.checkRememberMe();
	        loginPage.clickLogin();
	        // Add assertion here for successful login
	    }

	    @AfterMethod
	    public void teardownTest() {
	        teardown();
	    }
}
