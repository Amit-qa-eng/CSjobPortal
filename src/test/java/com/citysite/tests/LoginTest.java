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
	        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    }

	    @Test(priority = 1)
	    public void testJobSeekerLogin() throws InterruptedException {
	        loginPage.openJobSeekerLogin();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	        loginPage.enterEmail("testdeveloper30@gmail.com");
	        loginPage.enterPassword("Test#123?");
	        loginPage.checkRememberMe();
	        loginPage.clickLogin();
	        // Add assertion here for successful login
	    }

	    @Test(priority = 2)
	    public void testRecruiterLogin() throws InterruptedException {
	        loginPage.openRecruiterLogin();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
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
