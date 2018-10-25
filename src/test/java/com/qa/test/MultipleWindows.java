package com.qa.test;

import java.util.concurrent.TimeUnit;

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
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		
	}
	@Test
	public void MultiWindow() throws Exception {
	
		String currentUrl="https://learn.letskodeit.com/p/practice";
		System.out.println(currentUrl);
		
		String Urltonavigate="https://sso.teachable.com/secure/42299/users/sign_up?reset_purchase_session=1";
		driver.navigate().to(Urltonavigate);
		Thread.sleep(2999);
			
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().forward();
		Thread.sleep(2000);
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
