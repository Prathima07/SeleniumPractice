package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadFile {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void upload() {
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("/home/css/Desktop/SeleniumPractice/Driver/samplefile");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
