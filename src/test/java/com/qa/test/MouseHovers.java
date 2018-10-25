package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHovers {
WebDriver driver;
JavascriptExecutor jse;
@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
	driver=new ChromeDriver();
	jse = (JavascriptExecutor)driver;
	driver.get("https://learn.letskodeit.com/p/practice");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
@Test
public void hover() throws Exception {
	jse.executeScript("window.scrollBy(0, 900)");
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.id("mousehover"))).perform();
	Thread.sleep(3000);
	WebElement element1=driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
	action.moveToElement(element1).click().perform();
	Thread.sleep(3000);
	
}
@AfterMethod
public void teardown() {
	driver.quit();
}
}
