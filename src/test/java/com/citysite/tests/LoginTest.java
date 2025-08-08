package com.citysite.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.citysite.base.BaseTest;
import com.citysite.pages.LoginPage;

public class LoginTest  extends BaseTest{

	 private LoginPage loginPage;
	 private WebDriverWait wait;
	 
	 
	    @BeforeMethod
	    public void setupTest() {
	        setup();
	        loginPage = new LoginPage(driver);
	        wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	    }

	    @Test(priority = 1)
	    public void testJobSeekerLogin()  {
//	     
	    	
	    	 loginPage.openJobSeekerLogin();
	         wait.until(ExpectedConditions.visibilityOf(loginPage.jobSeekerEmailInput));
	         loginPage.enterJobSeekerEmail("testdeveloper30@gmail.com");
	         loginPage.enterJobSeekerPassword("Test#123?");
	         loginPage.checkJobSeekerRememberMe();
	         loginPage.clickJobSeekerLogin();
	    }

	    @Test(priority = 2)
	    public void testRecruiterLogin()  {
	    	loginPage.openRecruiterLogin();
	        wait.until(ExpectedConditions.visibilityOf(loginPage.recruiterEmailInput));
	        loginPage.enterRecruiterEmail("testdeveloper30@gmail.com");
	        loginPage.enterRecruiterPassword("Test#123?");
	        loginPage.checkRecruiterRememberMe();
	        loginPage.clickRecruiterLogin();
	        // Add assertion here for successful login
	    }

	    @AfterMethod
	    public void teardownTest() {
	        teardown();
	    }
}
