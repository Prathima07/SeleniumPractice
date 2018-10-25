package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
		WebElement textbox = driver.findElement(By.id("carselect"));
		textbox.sendKeys(Keys.ENTER);
		textbox.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		//textbox.sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.xpath("//[@id='navbar']/div/div/button/span[4]")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(4000);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
