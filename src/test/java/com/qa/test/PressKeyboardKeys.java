package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PressKeyboardKeys {
	WebDriver driver;

	@BeforeMethod
	public void Before() {
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

	}
	@Test
	public void test() throws Exception {
		//Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		//WebElement search=driver.findElement(By.id("opentab"));
		driver.findElement(By.id("opentab")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
