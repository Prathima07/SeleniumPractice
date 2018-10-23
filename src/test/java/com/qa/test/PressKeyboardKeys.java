package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PressKeyboardKeys {
	WebDriver driver;

	@BeforeMethod
	public void Before() {
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

	}
	@Test
	public void test() {
		//Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
		//WebElement search=driver.findElement(By.id("opentab"));
		driver.findElement(By.xpath("ele_path")).sendKeys(Keys.ENTER);
		
	}

}
