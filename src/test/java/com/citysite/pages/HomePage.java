package com.citysite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By jobSeekerButton = By.xpath("//a[@href='#jobseekerLoginModal' and @data-bs-toggle='modal' and @class='button1']");
	By recruiterButton = By.xpath("//a[@href='#recruiterLoginModal' and @data-bs-toggle='modal' and @class='button2']");

	// Actions
	public void openJobSeekerLogin() {
		driver.findElement(jobSeekerButton).click();
	}

	public void openRecruiterLogin() {
		driver.findElement(recruiterButton).click();
	}

}
