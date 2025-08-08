package com.citysite.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	protected WebDriver driver;
	
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		  driver.get("https://citysite-jobportal.24livehost.com/");
	}
	
	public void teardown() {
		if(driver !=null) {
			driver.quit();
		}
	}
	
}
