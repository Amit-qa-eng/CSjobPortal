package com.citysite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

 
	@FindBy(xpath="//a[@href='#jobseekerLoginModal' and @data-bs-toggle='modal' and @class='button1']")
	WebElement jobSeekerButton;
	
	
	@FindBy(xpath="//a[@href='#jobseekerLoginModal' and @data-bs-toggle='modal' and @class='button1']")
	WebElement recruiterButton;
	// Actions
	public void openJobSeekerLogin() {
		jobSeekerButton.click();
	}

	public void openRecruiterLogin() {
		recruiterButton.click();
	}

}
