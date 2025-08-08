package com.citysite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	// Home Page Buttons to open login modals
    @FindBy(xpath = "//a[@href='#jobseekerLoginModal' and @data-bs-toggle='modal' and @class='button1']")
    WebElement jobSeekerButton;

    @FindBy(xpath = "//a[@href='#recruiterLoginModal' and @data-bs-toggle='modal' and @class='button2']")
    WebElement recruiterButton;

    // Jobseeker Login Modal fields (scoped inside Jobseeker modal)
    @FindBy(xpath = "//div[@id='jobseekerLoginModal']//input[@id='email']")
	public
    WebElement jobSeekerEmailInput;

    @FindBy(xpath = "//div[@id='jobseekerLoginModal']//input[@id='password']")
    WebElement jobSeekerPasswordInput;

    @FindBy(xpath = "//div[@id='jobseekerLoginModal']//input[@id='remember']")
    WebElement jobSeekerRememberMeCheckbox;

    @FindBy(xpath = "//div[@id='jobseekerLoginModal']//button[contains(@class,'button1') and contains(@class,'w-100')]")
    WebElement jobSeekerLoginButton;

    // Recruiter Login Modal fields (scoped inside Recruiter modal)
    @FindBy(xpath = "//div[@id='recruiterLoginModal']//input[@id='email']")
	public
    WebElement recruiterEmailInput;

    @FindBy(xpath = "//div[@id='recruiterLoginModal']//input[@id='password']")
    WebElement recruiterPasswordInput;

    @FindBy(xpath = "//div[@id='recruiterLoginModal']//input[@id='remember']")
    WebElement recruiterRememberMeCheckbox;

    @FindBy(xpath = "//div[@id='recruiterLoginModal']//button[contains(@class,'button1') and contains(@class,'w-100')]")
    WebElement recruiterLoginButton;

    // Common error message (assumed same for both modals)
    @FindBy(css = ".error-message")
    WebElement errorMessage;

    // Register button locators inside popups
    @FindBy(xpath = "//a[@href='https://citysite-jobportal.24livehost.com/jobseeker/create' and normalize-space(text())='Register here.']")
    WebElement jobSeekerRegisterLink;

    @FindBy(xpath = "//a[@href='https://citysite-jobportal.24livehost.com/recruiter/create' and normalize-space(text())='Register here.']")
    WebElement recruiterRegisterLink;

    // Methods to open login modals
    public void openJobSeekerLogin() {
        jobSeekerButton.click();
    }

    public void openRecruiterLogin() {
        recruiterButton.click();
    }

    // Jobseeker login actions
    public void enterJobSeekerEmail(String email) {
        jobSeekerEmailInput.clear();
        jobSeekerEmailInput.sendKeys(email);
    }

    public void enterJobSeekerPassword(String password) {
        jobSeekerPasswordInput.clear();
        jobSeekerPasswordInput.sendKeys(password);
    }

    public void checkJobSeekerRememberMe() {
        if (!jobSeekerRememberMeCheckbox.isSelected()) {
            jobSeekerRememberMeCheckbox.click();
        }
    }

    public void clickJobSeekerLogin() {
        jobSeekerLoginButton.click();
    }

    // Recruiter login actions
    public void enterRecruiterEmail(String email) {
        recruiterEmailInput.clear();
        recruiterEmailInput.sendKeys(email);
    }

    public void enterRecruiterPassword(String password) {
        recruiterPasswordInput.clear();
        recruiterPasswordInput.sendKeys(password);
    }

    public void checkRecruiterRememberMe() {
        if (!recruiterRememberMeCheckbox.isSelected()) {
            recruiterRememberMeCheckbox.click();
        }
    }

    public void clickRecruiterLogin() {
        recruiterLoginButton.click();
    }

    // Common
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void clickJobSeekerRegister() {
        jobSeekerRegisterLink.click();
    }

    public void clickRecruiterRegister() {
        recruiterRegisterLink.click();
    }
	
	
}
