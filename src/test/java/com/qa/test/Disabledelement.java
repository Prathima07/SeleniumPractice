package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Disabledelement {
	WebDriver driver;
	JavascriptExecutor jse;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","..//SeleniumPractice//Driver//chromedriver" );
		driver=new ChromeDriver();
		jse = (JavascriptExecutor)driver;
		driver.get("https://www.freecrm.com/register/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void isenabled() throws InterruptedException {
		jse.executeScript("window.scrollBy(0, 900)");
		Thread.sleep(2000);
		Boolean b = driver.findElement(By.xpath("//*[@id='multipleForm']/div[12]/div"))
		System.out.println(b);
		Boolean b1 = driver.findElement(By.id("multipleForm")).isDisplayed();
		b.booleanValue();
		System.out.println(b1);
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
