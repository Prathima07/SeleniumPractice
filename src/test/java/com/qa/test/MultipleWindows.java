package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void MultiWindow() throws Exception {
		driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
		for (String childwindow : driver.getWindowHandles()) { 

		    driver.switchTo().window(childwindow);
		    Thread.sleep(2000);
		    }
		String title=driver.getTitle();
		System.out.println( title);

		//*[@id="content"]/div/a
	
		
	}
	@AfterMethod
	public void teardown() {
	driver.quit();
	}

}
