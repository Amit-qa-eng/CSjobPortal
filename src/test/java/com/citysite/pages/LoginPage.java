package com.citysite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	    WebDriver driver;

	    // Home Page Buttons
	    private By jobSeekerButton = By.xpath("//a[@href='#jobseekerLoginModal' and @data-bs-toggle='modal' and @class='button1']");
	    private By recruiterButton = By.xpath("//a[@href='#recruiterLoginModal' and @data-bs-toggle='modal' and @class='button2']");

	    // Login Fields (common for both modals)
	    private By emailInput = By.id("email");
	    private By passwordInput = By.id("password");
	    private By rememberMeCheckbox = By.id("remember");
	    private By loginButton = By.cssSelector(".button1.w-100");
	    private By errorMessage = By.cssSelector(".error-message");

	    // Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void openJobSeekerLogin() {
	        driver.findElement(jobSeekerButton).click();
	    }

	    public void openRecruiterLogin() {
	        driver.findElement(recruiterButton).click();
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailInput).clear();
	        driver.findElement(emailInput).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordInput).clear();
	        driver.findElement(passwordInput).sendKeys(password);
	    }

	    public void checkRememberMe() {
	        driver.findElement(rememberMeCheckbox).click();
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }

	    public String getErrorMessage() {
	        return driver.findElement(errorMessage).getText();
	    }
	
	
}
