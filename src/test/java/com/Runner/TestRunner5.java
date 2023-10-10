package com.Runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Base.Base_Class;

public class TestRunner5 extends Base_Class {
	
	@BeforeSuite
	
	private void validateHomePage() throws IOException {
		
		browserLaunch("chrome");
		urlLaunch("https://www.facebook.com/login/");
		
	}
	
    @Test
	private void LoginAccount() {
		driver.findElement(By.id("email")).sendKeys("prabahlv123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123444");
		driver.findElement(By.id("loginbutton")).click();
		
	}
    @AfterSuite
    private void afterscreenshot() {
    	 screenshot("facebook");
    	
    }
}
