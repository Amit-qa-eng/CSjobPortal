package com.citysite.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobseekerRegistrationPage {

    WebDriver driver;

    // Constructor
    public JobseekerRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators using PageFactory
    @FindBy(xpath = "//input[@name='name']")
	public
    WebElement fullnameField;

    @FindBy(id = "image")  // target the actual input element
    public WebElement imageUpload;

    @FindBy(xpath = "//input[@name='contact']")
	public
    WebElement contactField;

    @FindBy(xpath = "//input[@name='email']")
    public
    WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    public
    WebElement passwordField;

    @FindBy(xpath = "//input[@name='password_confirmation']")
    public
    WebElement confirmPasswordField;

    @FindBy(xpath = "//select[@name='gender']")
    public
    WebElement genderDropdown;

    @FindBy(xpath = "//input[@name='dob']")
    public
    WebElement dobField;

    @FindBy(xpath = "//input[@name='cityname']")
    public
    WebElement cityField;

    @FindBy(xpath = "//input[@name='address']")
    public
    WebElement addressField;

    @FindBy(xpath = "//select[@name='qualification']")
    public
    WebElement qualificationDropdown;

    @FindBy(xpath = "//select[@name='categories[]']")
    public
    WebElement categoriesDropdown;

    // Skills multi-select dropdown
    @FindBy(xpath = "//select[@name='skills[]']")
    public 
    WebElement skillsSelect;
    
    @FindBy(xpath ="//label[@for='experience_status_experienced']")
    public
    WebElement experiencedRadioBtn;

    @FindBy(xpath = "//input[@name='experience_years']")
    public
    WebElement expYearsField;

    @FindBy(xpath = "//textarea[@name='experience_details']")
    public
    WebElement expDetailsField;

    @FindBy(xpath = "//input[@type='file' and @name='resume']")
    public
    WebElement resumeUploadField;

    @FindBy(xpath = "//button[@type='submit']")
    public
    WebElement submitBtn;

    // Methods to interact with elements
    public void enterName(String name) {
        fullnameField.sendKeys(name);
    }

    public void uploadImage(String imageName) {
        String imagePath = System.getProperty("user.dir") + "/src/test/resources/files/" + imageName;
        imageUpload.sendKeys(imagePath);
    }

    public void enterContact(String contact) {
        contactField.sendKeys(contact);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void selectGender(String gender) {
        new Select(genderDropdown).selectByVisibleText(gender);
    }

    public void enterDOB(String dob) {
        dobField.sendKeys(dob);
    }

    public void enterCity(String city) {
        cityField.sendKeys(city);
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    public void selectQualification(String qualification) {
        new Select(qualificationDropdown).selectByVisibleText(qualification);
    }

    public void selectAllCategories() {
        Select categories = new Select(categoriesDropdown);
        if (categories.isMultiple()) {
            List<WebElement> allOptions = categories.getOptions();
            for (WebElement option : allOptions) {
                if (!option.getText().equalsIgnoreCase("Select Qualification")) {
                    categories.selectByVisibleText(option.getText());
                }
            }
        }
    }

    public void selectAllSkills() {
        Select skills = new Select(skillsSelect);

        if (skills.isMultiple()) {
            List<WebElement> allSkills = skills.getOptions();
            for (WebElement skill : allSkills) {
                if (!skill.getText().equalsIgnoreCase("-- Select Skills --")) {
                    skills.selectByVisibleText(skill.getText());
                }
            }
        }
    }
    
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    
    // Method to scroll to element before clicking (for experienced option)
    public void selectExperiencedOption() {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});",experiencedRadioBtn
        );
        experiencedRadioBtn.click();
    }
    
    
    public void selectExperienced() {
       // experiencedRadioBtn.click();
    	WebElement experiencedLabel = driver.findElement(By.xpath("//label[@for='experience_status_experienced']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", experiencedLabel);
        experiencedLabel.click();
    }

    public void enterExperienceYears(String years) {
        expYearsField.sendKeys(years);
    }

    public void enterExperienceDetails(String details) {
        expDetailsField.sendKeys(details);
    }

    public void uploadResume(String resumeName) {
        String resumePath = System.getProperty("user.dir") + "/src/test/resources/files/" + resumeName;
        resumeUploadField.sendKeys(resumePath);
    }

    public void clickSubmit() {
        submitBtn.click();
    }
	
	
}
