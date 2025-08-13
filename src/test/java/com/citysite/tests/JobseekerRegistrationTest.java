package com.citysite.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.citysite.base.BaseTest;
import com.citysite.pages.JobseekerRegistrationPage;


public class JobseekerRegistrationTest extends BaseTest {
	  JobseekerRegistrationPage registrationPage;
	    private WebDriverWait wait;

	    @BeforeMethod
	    public void setupTest() {
	        setup(); // initialize driver from BaseTest
	        driver.get("https://citysite-jobportal.24livehost.com/jobseeker/create"); // direct registration page
	        registrationPage = new JobseekerRegistrationPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }

	    @Test
	    public void testJobseekerRegistration() {

	        // Wait for Name field to be visible
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.fullnameField));
	        registrationPage.enterName("USER ONE");

	        // Upload image
	    //    wait.until(ExpectedConditions.visibilityOf(registrationPage.imageUpload))
         //   .sendKeys(System.getProperty("user.dir") + "/src/test/resources/files/download.png");
	        registrationPage.imageUpload.sendKeys(System.getProperty("user.dir") + "/src/test/resources/files/download.png");

	        // Contact
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.contactField));
	        registrationPage.enterContact("9876543210");

	        // Email
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.emailField));
	        registrationPage.enterEmail("testdeveloper30@yopmail.com");

	        // Password
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.passwordField));
	        registrationPage.enterPassword("Admin@12345");

	        // Confirm Password
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.confirmPasswordField));
	        registrationPage.enterConfirmPassword("Admin@12345");

	        // Gender
	        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.genderDropdown));
	        registrationPage.selectGender("Male");

	        // DOB
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.dobField));
	        registrationPage.enterDOB("12/12/2003");

	        // City
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.cityField));
	        registrationPage.enterCity("New York");

	        // Address
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.addressField));
	        registrationPage.enterAddress("123 Main Street");

	        // Qualification
	        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.qualificationDropdown));
	        registrationPage.selectQualification("Graduate");

	        registrationPage.scrollToBottom();
	        
	        
	        // Categories (multi-select)
	        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.categoriesDropdown));
	        registrationPage.selectAllCategories();

	     // Skills (multi-select)
	        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.skillsSelect));
	        registrationPage.selectAllSkills();
	        
	        // Experience
	      
	        registrationPage.scrollToBottom();
	        
	        registrationPage.selectExperiencedOption();
	        // Years of experience
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.expYearsField));
	        registrationPage.enterExperienceYears("3");

	        // Experience details
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.expDetailsField));
	        registrationPage.enterExperienceDetails("I have 3 years of experience as a sales executive in FMCG.");

	        // Upload resume
	        wait.until(ExpectedConditions.visibilityOf(registrationPage.resumeUploadField))
            .sendKeys(System.getProperty("user.dir") + "/src/test/resources/files/800KB.pdf");

	        // Submit
	        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.submitBtn));
	        registrationPage.clickSubmit();

	        // Optionally, add assertion to verify successful registration
	    }

	    @AfterMethod
	    public void teardownTest() {
	      //  teardown();
	    }
}
